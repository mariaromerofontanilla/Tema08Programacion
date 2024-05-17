package ficheroEje08;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Eje08 {
    private static final String NOMBRE_FICHERO = "src\\ficheroEje08\\temperaturas.txt";
    private static List<RegistroTemperatura> registros = new ArrayList<>();

    public static void main(String[] args) {
        cargarRegistros();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Menú:");
            System.out.println("1. Registra nueva temperatura");
            System.out.println("2. Mostrar historial de registros");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();  // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    registrarNuevaTemperatura(sc);
                    break;
                case 2:
                    mostrarHistorial();
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida, intenta de nuevo.");
            }
        } while (opcion != 3);

        sc.close();
    }

    private static void cargarRegistros() {
        try (BufferedReader br = new BufferedReader(new FileReader(NOMBRE_FICHERO))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 3) {
                    String fecha = data[0];
                    int tempMax = Integer.parseInt(data[1]);
                    int tempMin = Integer.parseInt(data[2]);
                    registros.add(new RegistroTemperatura(fecha, tempMax, tempMin));
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar los registros: " + e.getMessage());
        }
    }

    private static void guardarRegistro(RegistroTemperatura registro) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(NOMBRE_FICHERO, true))) {
            bw.write(registro.toString());
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error al guardar el registro: " + e.getMessage());
        }
    }

    private static void registrarNuevaTemperatura(Scanner sc) {
        System.out.print("Introduce la fecha (AAAA-MM-DD): ");
        String fecha = sc.nextLine();
        System.out.print("Introduce la temperatura máxima: ");
        int tempMax = sc.nextInt();
        System.out.print("Introduce la temperatura mínima: ");
        int tempMin = sc.nextInt();
        sc.nextLine();  // Consumir la nueva línea

        RegistroTemperatura nuevoRegistro = new RegistroTemperatura(fecha, tempMax, tempMin);
        registros.add(nuevoRegistro);
        guardarRegistro(nuevoRegistro);
        System.out.println("Registro guardado exitosamente.");
    }

    private static void mostrarHistorial() {
        int maxTempMax = Integer.MIN_VALUE;
        int minTempMin = Integer.MAX_VALUE;

        System.out.println("Historial de registros:");
        for (RegistroTemperatura registro : registros) {
            System.out.println(registro);
            if (registro.getTempMax() > maxTempMax) {
                maxTempMax = registro.getTempMax();
            }
            if (registro.getTempMin() < minTempMin) {
                minTempMin = registro.getTempMin();
            }
        }

        System.out.println("\nTemperatura máxima registrada: " + maxTempMax);
        System.out.println("Temperatura mínima registrada: " + minTempMin);
    }
}

