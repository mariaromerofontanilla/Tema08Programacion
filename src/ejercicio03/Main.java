package ejercicio03;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {
			System.out.print("Ingrese el DNI del titular: ");
			long dni = scanner.nextLong();
			scanner.nextLine(); // Limpiar el buffer del scanner
			System.out.print("Ingrese el nombre del titular: ");
			String nombre = scanner.nextLine();
			System.out.print("Ingrese el saldo inicial: ");
			double saldoInicial = scanner.nextDouble();

			CuentaCorriente cuenta = new CuentaCorriente(dni, nombre, saldoInicial);
			System.out.println("Cuenta creada: Titular: " + cuenta.getNombre() + ", DNI: " + cuenta.getDNI()
					+ ", Saldo: " + cuenta.getSaldo());
		} catch (DniException | NombreException | SaldoInicialException e) {
			System.out.println("Error al crear la cuenta: " + e.getMessage());
		}
	}
}
