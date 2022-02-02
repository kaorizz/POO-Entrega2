package ejercicio4;

import java.time.LocalDate;

/**
 * Es una clase de objetos inmutables que recoge la información de la compra a
 * un vendedor de una cantidad de un determinado producto por parte de un
 * cliente
 */
public final class Venta {

	// Constantes
	/**
	 * Constante que define una cantidad por defecto, con valor 1
	 */
	final static int CANTIDAD_POR_DEFECTO = 1;

	// Atributos
	/**
	 * Fecha en la que se realiza la venta
	 */
	private final LocalDate fecha;
	/**
	 * Cliente que efectúa la compra del producto que se está vendiendo
	 */
	private final String cliente;
	/**
	 * Oferta que contiene la información del producto que se está comprando
	 */
	private final Oferta oferta;
	/**
	 * Entero con el número de unidades del producto que se compran
	 */
	private final int cantidad;

	// Getters
	/**
	 * Método de consulta para obtener la fecha en la que se efectúa la venta
	 * 
	 * @return La fecha de la venta
	 */
	public LocalDate getFecha() {
		return fecha;
	}

	/**
	 * Método de consulta para obtener el cliente que compra el producto
	 * 
	 * @return El cliente de la venta
	 */
	public String getCliente() {
		return cliente;
	}

	/**
	 * Método de consulta para obtener la oferta de la venta
	 * 
	 * @return La oferta de la venta
	 */
	public Oferta getOferta() {
		return oferta;
	}

	/**
	 * Método de consulta para obtener la cantidad de productos que se compran
	 * 
	 * @return La cantidad de productos que se compran
	 */
	public int getCantidad() {
		return cantidad;
	}

	// Propiedad calculada
	/**
	 * Propiedad calculada que devuelve el precio final de la compra
	 * 
	 * @return El precio final de la compra
	 */
	public int getTotal() {
		return getOferta().getPrecio() * getCantidad();

	}

	// Constructor
	/**
	 * Constructor de la clase Venta para crear objetos de esta clase. Se inicializa
	 * fecha la fecha actual.
	 * 
	 * @param cliente
	 *            Cliente de la venta a crear
	 * @param cantidad
	 *            Unidades de la venta a crear
	 * @param oferta
	 *            Oferta de la venta a crear
	 */
	public Venta(String cliente, int cantidad, Oferta oferta) {
		this.fecha = LocalDate.now();
		this.cliente = cliente;
		this.cantidad = cantidad;
		this.oferta = oferta;
	}

	/**
	 * Constructor sobrecargado de la clase Venta. Establece en la cantidad una
	 * cantidad por defecto (1)
	 * 
	 * @param cliente
	 *            Cliente de la venta a crear
	 * @param oferta
	 *            Oferta de la venta a crear
	 */
	public Venta(String cliente, Oferta oferta) {
		this(cliente, CANTIDAD_POR_DEFECTO, oferta);
	}

	/**
	 * Método toString asociado a la clase venta
	 */
	// toString
	@Override
	public String toString() {
		return "Venta [fecha=" + fecha + ", cliente=" + cliente + ", oferta=" + oferta + ", cantidad=" + cantidad + "]";
	}

}
