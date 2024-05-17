package ejercicio04;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {
			System.out.print("Ingrese el nombre del artículo: ");
			String nombre = scanner.nextLine();
			System.out.print("Ingrese el precio del artículo: ");
			double precio = scanner.nextDouble();
			System.out.print("Ingrese la cantidad de stock del artículo: ");
			int stock = scanner.nextInt();

			Articulo articulo = new Articulo(nombre, precio, stock);
			System.out.println("Artículo creado: Nombre: " + articulo.getNombre() + ", Precio: " + articulo.getPrecio()
					+ ", Stock: " + articulo.getStock());
		} catch (NombreException | PrecioException | StockException e) {
			System.out.println("Error al crear el artículo: " + e.getMessage());
		}
	}
}
