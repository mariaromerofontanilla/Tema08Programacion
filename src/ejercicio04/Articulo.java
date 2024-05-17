package ejercicio04;

import javax.naming.InvalidNameException;

public class Articulo {
	private String nombre;
	private double precio;
	private int stock;

	public Articulo(String nombre, double precio, int stock) throws NombreException, PrecioException, StockException {
		setNombre(nombre);
		setPrecio(precio);
		setStock(stock);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) throws NombreException {
		if (nombre == null || nombre.isEmpty()) {
			throw new NombreException("El nombre del artículo no puede estar vacío.");
		}
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) throws PrecioException {
		if (precio <= 0) {
			throw new PrecioException("El precio del artículo debe ser mayor que cero.");
		}
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) throws StockException {
		if (stock < 0) {
			throw new StockException("La cantidad de stock del artículo no puede ser negativa.");
		}
		this.stock = stock;
	}
}
