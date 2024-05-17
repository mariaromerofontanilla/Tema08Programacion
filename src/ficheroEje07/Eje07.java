package ficheroEje07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Eje07 {
	private static final int MAX_CONTACTOS = 20;
	private static final String ARCHIVO_AGENDA = "src\\ficheroEje07\\agenda.txt";
	private static TreeMap<String, String> contactos = new TreeMap<>();

	public static void main(String[] args) {
		cargarAgenda();

		Scanner sc = new Scanner(System.in);
		int opcion;
		do {
			System.out.println("\nMenú:");
			System.out.println("1. Nuevo contacto.");
			System.out.println("2. Buscar por nombre.");
			System.out.println("3. Mostrar todos.");
			System.out.println("4. Salir.");
			System.out.print("Seleccione una opción: ");
			opcion = sc.nextInt();
			sc.nextLine(); // Consumir el salto de línea

			switch (opcion) {
			case 1:
				nuevoContacto(sc);
				break;
			case 2:
				buscarPorNombre(sc);
				break;
			case 3:
				mostrarTodos();
				break;
			case 4:
				guardarAgenda();
				System.out.println("¡Hasta luego!");
				break;
			default:
				System.out.println("Opción no válida. Inténtelo de nuevo.");
			}
		} while (opcion != 4);
	}

	private static void nuevoContacto(Scanner sc) {
		if (contactos.size() >= MAX_CONTACTOS) {
			System.out.println("La agenda está llena. No se pueden añadir más contactos.");
			return;
		}

		System.out.print("Ingrese el nombre del nuevo contacto: ");
		String nombre = sc.nextLine();

		if (contactos.containsKey(nombre)) {
			System.out.println("El nombre ya está en la agenda.");
			return;
		}

		System.out.print("Ingrese el teléfono de " + nombre + ": ");
		String telefono = sc.nextLine();

		contactos.put(nombre, telefono);
		System.out.println("Contacto añadido correctamente.");
	}

	private static void buscarPorNombre(Scanner sc) {
		System.out.print("Ingrese el nombre a buscar: ");
		String nombre = sc.nextLine();

		String telefono = contactos.get(nombre);
		if (telefono != null) {
			System.out.println("Teléfono de " + nombre + ": " + telefono);
		} else {
			System.out.println("El nombre no se encuentra en la agenda.");
		}
	}

	private static void mostrarTodos() {
		if (contactos.isEmpty()) {
			System.out.println("La agenda está vacía.");
			return;
		}

		System.out.println("Lista de contactos:");
		for (Map.Entry<String, String> contacto : contactos.entrySet()) {
			System.out.println(contacto.getKey() + ": " + contacto.getValue());
		}
	}

	private static void cargarAgenda() {
		try (BufferedReader reader = new BufferedReader(new FileReader(ARCHIVO_AGENDA))) {
			String linea;
			while ((linea = reader.readLine()) != null) {
				String[] partes = linea.split(":");
				if (partes.length == 2) {
					contactos.put(partes[0], partes[1]);
				}
			}
			System.out.println("Agenda cargada correctamente.");
		} catch (IOException e) {
			System.out.println("No se pudo cargar la agenda. La agenda está vacía.");
		}
	}

	private static void guardarAgenda() {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO_AGENDA))) {
			for (Map.Entry<String, String> contacto : contactos.entrySet()) {
				writer.write(contacto.getKey() + ":" + contacto.getValue());
				writer.newLine();
			}
			System.out.println("Agenda guardada correctamente en " + ARCHIVO_AGENDA);
		} catch (IOException e) {
			System.out.println("Error al guardar la agenda en " + ARCHIVO_AGENDA);
		}
	}
}