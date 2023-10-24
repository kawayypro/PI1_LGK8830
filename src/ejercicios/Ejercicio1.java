package ejercicios;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio1 {
	
	private record EnteroCadena(Integer a, String s) {
		
		public static EnteroCadena of(Integer a, String s) {
			return new EnteroCadena(a,s);
		}
	}
	
	public static String ejercicio1_Iterativo (Integer varA, Integer varB) {
		
		List<String> ac = new ArrayList<String>();
		EnteroCadena elem = EnteroCadena.of(varA, "A");
		while(elem.a()<varB) {
			
			if(elem.a()%10!=0) {
				ac.add(elem.s());
			}
			Integer nuevoa = elem.a() +3;
			String nuevos = elem.a()%2==0? elem.a()+"*" : elem.a()+"!";
			elem = EnteroCadena.of(nuevoa, nuevos);
			
		}
		return String.join("-", ac);
	}
	
	public static String ejercicio1_RecursivoFinal(Integer varA, Integer varB) {
		return String.join("-", recFinal(new ArrayList<String>(), EnteroCadena.of(varA, "A"), varB));
	}
	
	public static List<String> recFinal(List<String> ac, EnteroCadena elem, Integer varB) {
		List<String> r = ac;
		if(elem.a()<varB) {
			if(elem.a()%10!=0) {
				ac.add(elem.s());
			}
			Integer nuevoa = elem.a()+3;
			String nuevos = elem.a()%2==0? elem.a()+"*" : elem.a()+"!";
			elem = EnteroCadena.of(nuevoa, nuevos);
			r= recFinal(ac, elem, varB);
			
		}
		return r;
		
	}
	

}
