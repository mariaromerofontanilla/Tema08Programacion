package ejercicio02;

public class Main {
	public static void main(String[] args) {
		try {
			Hora hora = new Hora(10, 20, 30);
			System.out.println("Hora creada: " + hora.getHora() + ":" + hora.getMinuto() + ":" + hora.getSegundo());

			// Intentamos crear una hora con valores negativos para probar las excepciones
			Hora horaInvalida = new Hora(-1, 20, 30);
		} catch (NegativeHourException | NegativeMinuteException | NegativeSecondException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
