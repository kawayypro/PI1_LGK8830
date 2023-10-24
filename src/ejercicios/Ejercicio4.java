package ejercicios;

import java.util.HashMap;
import java.util.Map;
import us.lsi.common.IntPair;

public class Ejercicio4 {
	
	public static String ejercicio4Imperativo(Integer a, Integer b) {
		Map<IntPair, String> map = new HashMap<IntPair, String>();
		
		String v = null;
		for(int i = 0; i <= a; i++) {
			for(int j = 0; j <= b; j++) {
				if(i<=4) {
					v = Integer.toString(i) + "." + Integer.toString(j);
				}else if(j<=4){
					v = Integer.toString(j) + "-" + Integer.toString(i);
				}else {
					v = map.get(IntPair.of(i/2,j-2)) + "," + map.get(IntPair.of(i-2,j/2)) + "," + map.get(IntPair.of(i-1,j-1));
				}
				map.put(IntPair.of(i,j), v);
			}
		}
		return map.get(IntPair.of(a,b));
	}
	
	public static String ejercicio4RecursivoSinMemoria(Integer a, Integer b) {
		String ac = null;
		if(a<=4) {
			ac = Integer.toString(a) + "." + Integer.toString(b);
		}else if(b<=4) {
			ac = Integer.toString(b) + "-" + Integer.toString(a);
		}else {
			ac = ejercicio4RecursivoSinMemoria(a/2,b-2) + "," + ejercicio4RecursivoSinMemoria(a-2, b/2) + "," + ejercicio4RecursivoSinMemoria(a-1, b-1);
		}
		return ac;
	}
	
	public static String ejercicio4RecursivoConMemoria(Integer a, Integer b) {
		
		return gRecConMem(a, b, new HashMap<>());
	}
	
	private static String gRecConMem(Integer a, Integer b, Map<IntPair, String> m) {
		String ac = null;
		IntPair key = IntPair.of(a,b);
		if(m.containsKey(key)) {
			ac = m.get(key);
		} else {
			if (a<=4) {
				ac = Integer.toString(a) + "." + Integer.toString(b);
			} else if(b<=4) {
				ac = Integer.toString(b) + "-" + Integer.toString(a);
			}else {
				ac = gRecConMem(a/2,b-2,m) + "," + gRecConMem(a-2,b/2,m) + "," + gRecConMem(a-1,b-1,m);
			}
			m.put(IntPair.of(a,b), ac);
				
		}
		return ac;
	}

}
