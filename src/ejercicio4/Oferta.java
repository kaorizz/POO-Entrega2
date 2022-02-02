package ejercicio4;

/**
 * Clase que representa una propuesta de venta de un producto por parte de un
 * vendedor
 */
public class Oferta {

	// Atributos
	/**
	 * Cadena de texto que identifica al vendedor que hace la oferta
	 */
	private final String vendedor;
	/**
	 * Producto que se oferta
	 */
	private final Producto producto;
	/**
	 * Precio de venta del producto
	 */
	private final int precio;

	// Getters
	/**
	 * Método de consulta para obtener el vendedor de la oferta
	 * 
	 * @return El vendedor de la oferta
	 */
	public String getVendedor() {
		return vendedor;
	}

	/**
	 * Método de consulta para obtener el producto que se oferta
	 * 
	 * @return El producto que se oferta
	 */
	public Producto getProducto() {
		return producto;
	}

	/**
	 * Método de consulta para obtener el precio de la oferta
	 * 
	 * @return El precio de la oferta
	 */
	public int getPrecio() {
		return precio;
	}

	// Constructores
	/**
	 * Constructor de la clase Oferta para crear objetos de esta clase.
	 * 
	 * @param vendedor
	 *            Vendedor de la clase a crear
	 * @param producto
	 *            Producto de la clase a crear
	 * @param precio
	 *            Precio de la clase a crear
	 */
	public Oferta(String vendedor, Producto producto, int precio) {
		this.vendedor = vendedor;
		this.producto = producto;
		this.precio = precio;
	}

	// Métodos equals y hashCode
	/**
	 * Método hashCode asociado a la clase Oferta
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + precio;
		result = prime * result + ((producto == null) ? 0 : producto.hashCode());
		result = prime * result + ((vendedor == null) ? 0 : vendedor.hashCode());
		return result;
	}

	/**
	 * Método equals asociado a la clase Oferta
	 */
	@Override
	public boolean equals(Object obj) {
		Oferta other = (Oferta) obj;
		if (precio != other.precio)
			return false;
		if (producto == null) {
			if (other.producto != null)
				return false;
		} else if (!producto.equals(other.producto))
			return false;
		if (vendedor == null) {
			if (other.vendedor != null)
				return false;
		} else if (!vendedor.equals(other.vendedor))
			return false;
		return true;
	}

	// toString
	/**
	 * Método toString asociado a la clase Oferta
	 */
	@Override
	public String toString() {
		return "Oferta [vendedor=" + vendedor + ", producto=" + producto + ", precio=" + precio + "]";
	}

}
