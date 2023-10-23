package tests;
import ejercicios.Ejercicio1;
import ejercicios.Ejercicio2;
import ejercicios.Ejercicio3;

public class Test {

	public static void main(String[] args) {
		
		System.out.println(Ejercicio1.ejercicio1_Iterativo(32, 55));
		System.out.println(Ejercicio1.ejercicio1_RecursivoFinal(32, 55));
		System.out.println(Ejercicio2.ejercicio2Iterativo(250, 43));
		System.out.println(Ejercicio2.ejercicio2RecursivoNoFinal(250, 43));
		System.out.println(Ejercicio2.ejercicio2RevursivoFinal(250, 43));
		System.out.println(Ejercicio2.ejercicio2Funcional(250, 43));
		System.out.println(Ejercicio3.ejercicio3Iterativo("src/ficheros/PI1Ej3DatosEntrada1A.txt", "src/ficheros/PI1Ej3DatosEntrada1b.txt"));
		System.out.println(Ejercicio3.ejercicio3RecursivoFinal("src/ficheros/PI1Ej3DatosEntrada1A.txt", "src/ficheros/PI1Ej3DatosEntrada1b.txt"));
		System.out.println(Ejercicio3.ejercicio3Funcional("src/ficheros/PI1Ej3DatosEntrada1A.txt", "src/ficheros/PI1Ej3DatosEntrada1b.txt"));
	}
}
