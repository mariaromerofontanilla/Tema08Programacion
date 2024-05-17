package ejercicio02;

public class Hora {
	private int hora;
	private int minuto;
	private int segundo;

	public Hora(int hora, int minuto, int segundo)
			throws NegativeHourException, NegativeMinuteException, NegativeSecondException {
		setHora(hora);
		setMinuto(minuto);
		setSegundo(segundo);
	}

	public int getHora() {
		return hora;
	}

	public void setHora(int hora) throws NegativeHourException {
		if (hora < 0) {
			throw new NegativeHourException("La hora no puede ser negativa.");
		}
		this.hora = hora;
	}

	public int getMinuto() {
		return minuto;
	}

	public void setMinuto(int minuto) throws NegativeMinuteException {
		if (minuto < 0) {
			throw new NegativeMinuteException("El minuto no puede ser negativo.");
		}
		this.minuto = minuto;
	}

	public int getSegundo() {
		return segundo;
	}

	public void setSegundo(int segundo) throws NegativeSecondException {
		if (segundo < 0) {
			throw new NegativeSecondException("El segundo no puede ser negativo.");
		}
		this.segundo = segundo;
	}
}
