package ejercicio01;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		double readDouble;
		int readInt;

		System.out.print("Double: ");
		readDouble = Utils.readDouble(sc);

		System.out.println();

		System.out.print("Int: ");
		readInt = Utils.readInt(sc);

	}

}
