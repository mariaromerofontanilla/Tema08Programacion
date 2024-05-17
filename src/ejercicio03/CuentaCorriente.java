package ejercicio03;

public class CuentaCorriente {
	private long dni;
	private String nombre;
	private double saldo;

	public CuentaCorriente(long dni, String nombre, double saldo)
			throws DniException, NombreException, SaldoInicialException {
		setDNI(dni);
		setNombre(nombre);
		setSaldo(saldo);
	}

	public long getDNI() {
		return dni;
	}

	public void setDNI(long dni) throws DniException {
		if (dni < 0) {
			throw new DniException("El DNI no puede ser negativo.");
		}
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) throws DniException {
		if (nombre.isEmpty()) {
			throw new DniException("El nombre no puede estar vacío.");
		}
		this.nombre = nombre;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) throws SaldoInicialException {
		if (saldo < 0) {
			throw new SaldoInicialException("El saldo inicial no puede ser negativo.");
		}
		this.saldo = saldo;
	}
}
