package ejercicio4;

/**
 * Un producto es una clase que define objetos inmutables que representa cada
 * uno de los productos que se ofertan
 */
public final class Producto {

	// Atributos
	/**
	 * Cadena de texto inmutable que representa el código del producto
	 */
	private final String codigo;
	/*
	 * Cadena de texto inmutable que representa el nombre del producto
	 */
	private final String nombre;
	/*
	 * Cadena de texto inmutable que representa la descripción del producto
	 */
	private final String descripcion;

	// Getters
	/**
	 * Método de consulta para obtener el código del producto
	 * 
	 * @return El código del producto
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * Método de consulta para obtener el nombre del producto
	 * 
	 * @return El nombre del producto
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Método de consulta para obtener la descripción del producto
	 * 
	 * @return La descripción del producto
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Constructor de la clase Producto para crear objetos de esta clase
	 * 
	 * @param nombre
	 *            Nombre del producto a crear
	 * @param descripcion
	 *            Descripción del producto a crear
	 */
	// Constructor
	public Producto(String nombre, String descripcion) {
		this.codigo = java.util.UUID.randomUUID().toString();
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	/**
	 * Método hashCode asociado a la clase Producto
	 */
	// Métodos equals y hashCode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	/**
	 * Método equals asociado a la clase Producto
	 */
	@Override
	public boolean equals(Object obj) {
		Producto other = (Producto) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	/**
	 * Método toString asociado a la clase Producto
	 */
	// toString
	@Override
	public String toString() {
		return "Producto [codigo=" + codigo + ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
	}

}
