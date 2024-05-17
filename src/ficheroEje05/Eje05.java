package ficheroEje05;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Eje05 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Ingrese su nombre: ");
		String nombre = sc.nextLine();

		System.out.print("Ingrese su edad: ");
		int edad = sc.nextInt();

		try {
			FileWriter writer = new FileWriter("src\\ficheroEje05\\datos.txt", true); // El parámetro true indica que se añadirán datos al
																	// final del archivo
			writer.write(nombre + " " + edad + "\n");
			writer.close();
			System.out.println("Los datos se han guardado en el archivo correctamente.");
		} catch (IOException e) {
			System.out.println("Error al escribir en el archivo: " + e.getMessage());
		}
	}
}
