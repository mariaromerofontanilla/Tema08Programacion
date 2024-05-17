package ficheroEje04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Eje04 {

	public static void main(String[] args) {

		//final String nombreArchivo = "src\\ficheroEje04\\Fin.txt";

		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("src\\sficheroEje04\\Fin.txt"));
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

			String linea;
			System.out.println("Introduce líneas de texto. Escribe 'fin' para terminar:");

			while (!(linea = reader.readLine()).equals("fin")) {
				writer.write(linea);
				writer.newLine();
			}

			writer.close();
			System.out.println("Texto guardado en el archivo " + "src\\ficheroEje04\\Fin.txt" + " correctamente.");
		} catch (IOException e) {
			System.out.println("Error al escribir en el archivo: " + e.getMessage());
		}
	}

}
