package ficheroEj02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Eje02 {

	public static void main(String[] args) {
		try {
			BufferedReader in = new BufferedReader(new FileReader("src\\ficheroEj02\\Enteros.txt"));
			String linea = "";
			double suma = 0;
			int contador = 0;

			while ((linea = in.readLine()) != null) {
				System.out.println(linea);
				// Usamos split con una expresión regular para dividir la línea en números
				String[] numeros = linea.trim().split("\\s+");
				for (String numeroStr : numeros) {
					try {
						double numero = Double.parseDouble(numeroStr);
						suma += numero;
						contador++;
					} catch (NumberFormatException e) {
						// Ignoramos los elementos que no son números
					}
				}
			}

			if (contador > 0) {
				double media = suma / contador;
				System.out.println("La suma de los números es: " + suma);
				System.out.println("La media aritmética de los números es: " + media);
			} else {
				System.out.println("El archivo está vacío o no contiene números válidos.");
			}

			in.close();

		} catch (IOException e) {
			System.out.println("Error al leer el archivo: " + e.getMessage());
		}
	}
}