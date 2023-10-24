package ejercicios;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class Ejercicio2 {
	
	public static List<Integer> ejercicio2Iterativo(Integer a, Integer b){
		LinkedList<Integer> ac = new LinkedList<Integer>();
		while((a>=2 & b>=2) | a>b) {
			
			if(a>b) {
				ac.addFirst(a);
				a = a%b;
				b -= 1;
			}else {
				ac.addFirst(b);
				a -= 2;
				b = b/2;
			}
			
		}
		ac.addFirst(a * b);
		return ac;
	}
	
	public static List<Integer> ejercicio2RecursivoNoFinal (Integer a, Integer b){
		LinkedList<Integer> ac = new LinkedList<Integer>();
		if(a<2 | b<2) {
			ac.addFirst(a * b);
		}else if(a>b) {
			ac.addFirst(a);
			ac.addAll(0, ejercicio2RecursivoNoFinal(a%b,b-1));
		}else {
			ac.addFirst(b);
			ac.addAll(0, ejercicio2RecursivoNoFinal(a-2,b/2));
		}
		return ac;
	}
	
	public static List<Integer> ejercicio2RecursivoFinal(Integer a, Integer b){
		LinkedList<Integer> ac = new LinkedList<Integer>();
		return RecursionFinal(ac, a, b);
	}
	
	private static List<Integer> RecursionFinal(LinkedList<Integer> ac, Integer a, Integer b){
		if(a<2 | b<2) {
			ac.addFirst(a*b);
		}else if(a>b) {
			ac.addFirst(a);
			RecursionFinal(ac, a%b,b-1);
		}else {
			ac.addFirst(b);
			RecursionFinal(ac,a-2,b/2);
		}
		return ac;
	}
	
	private static record Tupla(Integer a, Integer b, LinkedList<Integer> ac) {
		public static Tupla of(Integer a, Integer b, LinkedList<Integer> ac) {
			return new Tupla(a,b,ac);
		}
		public Tupla next() {
			Tupla nx = null;
			
			if(a>b) {
				ac.addFirst(a);
				nx = of(a%b, b-1, ac);
				
			}else {
				ac.addFirst(b);
				nx = of(a-2,b/2,ac);
					
			}
			return nx;
		}
	}
	
	public static List<Integer> ejercicio2Funcional(Integer a, Integer b){
		Tupla t = Stream.iterate(Tupla.of(a, b, new LinkedList<Integer>()), e -> e.next())
				.filter(e -> e.a()<2 || e.b()<2).findFirst().get();
		
		t.ac().addFirst(t.a()*t.b());
		return t.ac();
	}

}
