package ejercicios;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import us.lsi.common.Files2;

public class Ejercicio3 {
	
	public static List<String> ejercicio3Iterativo(String file1, String file2){
		
		List<String> ac = new ArrayList<String>();
		Iterator<String> f1 = Files2.linesFromFile(file1).iterator();
		Iterator<String> f2 = Files2.linesFromFile(file2).iterator();
		
		while(f1.hasNext() || f2.hasNext()) {
			if(f1.hasNext()) {
				ac.add(f1.next());
				if(f1.hasNext()) {
					ac.add(f1.next());
				}
			}
			
			if(f2.hasNext()) {
				ac.add(f2.next());
				if(f2.hasNext()) {
					ac.add(f2.next());
				}
			}
		}
		
		return ac;
		
	}
	
	public static List<String> ejercicio3RecursivoFinal(String file1, String file2){
		List<String> ac = new ArrayList<String>();
		Iterator<String> f1 = Files2.linesFromFile(file1).iterator();
		Iterator<String> f2 = Files2.linesFromFile(file2).iterator();
		return recursionFinal(f1,f2,ac);
	}
	
	private static List<String> recursionFinal(Iterator<String> f1, Iterator<String> f2, List<String> ac){
		if(f1.hasNext()||f2.hasNext()) {
			
			if(f1.hasNext()) {
				ac.add(f1.next());
				if(f1.hasNext()) {
					ac.add(f1.next());
				}
			}
		
			if(f2.hasNext()) {
				ac.add(f2.next());
				if(f2.hasNext()) {
					ac.add(f2.next());
				}
			}
			ac = recursionFinal(f1,f2,ac);
		}
		return ac;
		
	}
	
	private static record Tupla(Iterator<String> f1, Iterator<String> f2, List<String> ac) {
		
		public static Tupla of(String file1, String file2, List<String> ac) {
			Iterator<String> f1 = Files2.linesFromFile(file1).iterator();
			Iterator<String> f2 = Files2.linesFromFile(file2).iterator();
			return new Tupla(f1,f2,ac);
		}
		
		public static Tupla ofIterator(Iterator<String> f1, Iterator<String> f2, List<String> ac) {
			return new Tupla(f1,f2,ac);
		}
		
		public Tupla next() {
			
			if(f1.hasNext()) {
				ac.add(f1.next());
				if(f1.hasNext()) {
					ac.add(f1.next());
				}
			}
		
			if(f2.hasNext()) {
				ac.add(f2.next());
				if(f2.hasNext()) {
					ac.add(f2.next());
				}
			}
			return ofIterator(f1,f2,ac);
		}
		
	}
	
	public static List<String> ejercicio3Funcional(String file1, String file2){
		
		Tupla t = Stream.iterate(Tupla.of(file1, file2, new ArrayList<String>()), e -> e.next())
				.filter(e-> !(e.f1().hasNext() || e.f2().hasNext())).findFirst().get();
		return t.ac();
	}

}
