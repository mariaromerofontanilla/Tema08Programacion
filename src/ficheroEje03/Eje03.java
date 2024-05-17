package ficheroEje03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Eje03 {

	public static void main(String[] args) {

		//String archivo = "Alumnos.txt";
		try {
			BufferedReader in = new BufferedReader(new FileReader("src\\ficheroEje03\\Alumnos.txt"));
			String linea = "";
			int totalEdades = 0;
			double totalEstaturas = 0;
			int contador = 0;
			int edad = 0;
			double estatura = 0;
			String[] partes;
			String nombre = "";

			while ((linea = in.readLine()) != null) {
				System.out.println(linea);
				System.out.println();
				partes = linea.split(" ");
				nombre = partes[0];
				edad = Integer.parseInt(partes[1]);
				estatura = Double.parseDouble(partes[2]);

				System.out.println("Nombre: " + nombre);
				System.out.println("Edad: " + edad);
				System.out.println("Estatura: " + estatura);

				totalEdades += edad;
				totalEstaturas += estatura;
				contador++;
			}

			if (contador > 0) {
				double mediaEdades = (double) totalEdades / contador;
				double mediaEstaturas = totalEstaturas / contador;
				System.out.println("Media de las edades: " + mediaEdades);
				System.out.println("Media de las estaturas: " + mediaEstaturas);
			} else {
				System.out.println("No se encontraron datos de alumnos en el archivo.");
			}

			in.close();
		} catch (IOException e) {
			System.out.println("Error al leer el archivo: " + e.getMessage());
		} catch (NumberFormatException e) {
			System.out.println("Error en el formato de los datos en el archivo.");
		}
	}

}
