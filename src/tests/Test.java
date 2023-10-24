package tests;
import java.util.List;
import java.util.function.Function;

import ejercicios.Ejercicio1;
import ejercicios.Ejercicio2;
import ejercicios.Ejercicio3;
import ejercicios.Ejercicio4;
import us.lsi.common.Files2;
import us.lsi.common.Pair;

public class Test {
	
	private static List<Pair<Integer,Integer>> casos(String fileName){	
		Function<String, Pair<Integer, Integer>> parseInteger2 = s -> {
			String[] numeros = s.split(",");
			return Pair.of(Integer.valueOf(numeros[0]), Integer.valueOf(numeros[1]));
		};
		
		return Files2.streamFromFile(fileName).map(parseInteger2).toList();
	}

	public static void main(String[] args) {
			
		System.out.println("Ejercicio 1\n\n");
		Integer cont = 1;
		for(Pair<Integer, Integer> nums: casos("src/ficheros/PI1Ej1DatosEntrada.txt")) {
			
			Integer a = nums.first();
			Integer b = nums.second();
			
			System.out.println("Test " + cont.toString() + "\n");
			System.out.println("Solucion iterativa : " + Ejercicio1.ejercicio1_Iterativo(a, b));
			System.out.println("Solucion RecursivaF: " + Ejercicio1.ejercicio1_RecursivoFinal(a, b) + "\n");
			cont++;
		}
		
		System.out.println("-------------------------------------------------------------------------\n");
		System.out.println("Ejercicio 2\n\n");
		cont = 1;
		for(Pair<Integer, Integer> nums: casos("src/ficheros/PI1Ej2DatosEntrada.txt")) {
			
			Integer a = nums.first();
			Integer b = nums.second();
			
			System.out.println("Test " + cont.toString() + "\n");
			System.out.println("Solucion iterativa  : " + Ejercicio2.ejercicio2Iterativo(a, b));
			System.out.println("Solucion RecursivaF : " + Ejercicio2.ejercicio2RecursivoFinal(a, b));
			System.out.println("Solucion RecursivaNF: " + Ejercicio2.ejercicio2RecursivoNoFinal(a, b));
			System.out.println("Solucion Funcional  : " + Ejercicio2.ejercicio2Funcional(a, b) + "\n");
			cont++;
		}
		
		System.out.println("-------------------------------------------------------------------------\n");
		System.out.println("Ejercicio 3\n\n");
		
		for(cont = 1; cont<=3; cont++) {
			System.out.println("Test " + cont.toString() + "\n");
			System.out.println("Solucion iterativa : " + Ejercicio3.ejercicio3Iterativo("src/ficheros/PI1Ej3DatosEntrada" + cont.toString() + "A.txt", "src/ficheros/PI1Ej3DatosEntrada" + cont.toString() + "B.txt"));
			System.out.println("Solucion RecursivaF: " + Ejercicio3.ejercicio3RecursivoFinal("src/ficheros/PI1Ej3DatosEntrada" + cont.toString() + "A.txt", "src/ficheros/PI1Ej3DatosEntrada" + cont.toString() + "B.txt"));
			System.out.println("Solucion Funcional : " + Ejercicio3.ejercicio3Funcional("src/ficheros/PI1Ej3DatosEntrada" + cont.toString() + "A.txt", "src/ficheros/PI1Ej3DatosEntrada" + cont.toString() + "B.txt") + "\n");
		}
		
		System.out.println("Ejercicio 4\n\n");
		cont = 1;
		for(Pair<Integer, Integer> nums: casos("src/ficheros/PI1Ej4DatosEntrada.txt")) {
			
			Integer a = nums.first();
			Integer b = nums.second();
			
			System.out.println("Test " + cont.toString() + "\n");
			System.out.println("Solucion Imperativo : " + Ejercicio4.ejercicio4Imperativo(a, b));
			System.out.println("Solucion RecursivaCM: " + Ejercicio4.ejercicio4RecursivoConMemoria(a, b));
			System.out.println("Solucion RecursivaSM: " + Ejercicio4.ejercicio4RecursivoSinMemoria(a, b) + "\n");
			cont++;
		}
		
		
		/*
		System.out.println(Ejercicio1.ejercicio1_Iterativo(32, 55));
		System.out.println(Ejercicio1.ejercicio1_RecursivoFinal(32, 55));
		System.out.println(Ejercicio2.ejercicio2Iterativo(250, 43));
		System.out.println(Ejercicio2.ejercicio2RecursivoNoFinal(250, 43));
		System.out.println(Ejercicio2.ejercicio2RevursivoFinal(250, 43));
		System.out.println(Ejercicio2.ejercicio2Funcional(250, 43));
		System.out.println(Ejercicio3.ejercicio3Iterativo("src/ficheros/PI1Ej3DatosEntrada1A.txt", "src/ficheros/PI1Ej3DatosEntrada1b.txt"));
		System.out.println(Ejercicio3.ejercicio3RecursivoFinal("src/ficheros/PI1Ej3DatosEntrada1A.txt", "src/ficheros/PI1Ej3DatosEntrada1b.txt"));
		System.out.println(Ejercicio3.ejercicio3Funcional("src/ficheros/PI1Ej3DatosEntrada1A.txt", "src/ficheros/PI1Ej3DatosEntrada1b.txt"));
		System.out.println(Ejercicio4.ejercicio4Imperativo(10, 6));
		System.out.println(Ejercicio4.ejercicio4RecursivoSinMemoria(10, 6));
		System.out.println(Ejercicio4.ejercicio4RecursivoConMemoria(10, 6));
		*/
	}
}
