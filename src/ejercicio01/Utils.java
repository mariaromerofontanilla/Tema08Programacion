package ejercicio01;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Utils {

	public static double readDouble(Scanner sc) {
		double resul;
		try {
			resul = sc.nextDouble();
		} catch (InputMismatchException e) {
			resul = 0;
			System.out.println();
			System.err.println("El valor introducido no es de tipo double");
		}
		return resul;
	}

	public static int readInt(Scanner sc) {
		int resul;
		try {
			resul = sc.nextInt();
		} catch (InputMismatchException e) {
			resul = 0;
			System.out.println();
			System.err.println("El valor introducido no es de tipo int");
		}
		return resul;
	}

}
