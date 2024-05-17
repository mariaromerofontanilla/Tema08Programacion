package ficheroEj01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Eje01 {

	public static void main(String[] args) {

		try {
			BufferedReader in = new BufferedReader(new FileReader("src\\ficheroEj01\\NumeroReales.txt"));
			String linea = "";
			double suma = 0;
			int contador = 0;

			while ((linea = in.readLine()) != null) {
				System.out.println(linea);
				String[] numeros = linea.split(" ");
				for (String numeroStr : numeros) {
					double numero = Double.parseDouble(numeroStr);
					suma += numero;
					contador++;
				}
			}

			if (contador > 0) {
				double media = suma / contador;
				System.out.println("La suma de los números es: " + suma);
				System.out.println("La media aritmética de los números es: " + media);
			} else {
				System.out.println("El archivo está vacío.");
			}

			in.close();

		} catch (IOException e) {
			System.out.println("Error al leer el archivo: " + e.getMessage());
		} catch (NumberFormatException e) {
			System.out.println("Error al convertir un número: " + e.getMessage());
		}
	}
}