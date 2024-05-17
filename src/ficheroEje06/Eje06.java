package ficheroEje06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Eje06 {

	public static void main(String[] args) {

		String archivoEntrada = "numeros.txt";
		String archivoSalida = "numeros_ordenados.txt";

		// Leer números del archivo de entrada y almacenarlos en una lista
		List<Integer> numeros = new ArrayList<>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader("src\\ficheroEje06\\numeros.txt"));
			String linea;
			while ((linea = reader.readLine()) != null) {
				int numero = Integer.parseInt(linea.trim());
				numeros.add(numero);
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Error al leer el archivo de entrada: " + e.getMessage());
			return;
		} catch (NumberFormatException e) {
			System.out.println("Error: El archivo de entrada contiene datos no numéricos.");
			return;
		}

		// Ordenar la lista de números
		Collections.sort(numeros);

		// Escribir números ordenados en el archivo de salida
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("src\\ficheroEje06\\numeros_ordenados.txt"));
			for (int numero : numeros) {
				writer.write(Integer.toString(numero));
				writer.newLine();
			}
			writer.close();
			System.out.println(
					"Los números se han ordenado y guardado en el archivo " + archivoSalida + " correctamente.");
		} catch (IOException e) {
			System.out.println("Error al escribir en el archivo de salida: " + e.getMessage());
		}
	}

}