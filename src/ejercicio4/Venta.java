package ejercicio4;

import java.time.LocalDate;

/**
 * Es una clase de objetos inmutables que recoge la informaci�n de la compra a
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
	 * Cliente que efect�a la compra del producto que se est� vendiendo
	 */
	private final String cliente;
	/**
	 * Oferta que contiene la informaci�n del producto que se est� comprando
	 */
	private final Oferta oferta;
	/**
	 * Entero con el n�mero de unidades del producto que se compran
	 */
	private final int cantidad;

	// Getters
	/**
	 * M�todo de consulta para obtener la fecha en la que se efect�a la venta
	 * 
	 * @return La fecha de la venta
	 */
	public LocalDate getFecha() {
		return fecha;
	}

	/**
	 * M�todo de consulta para obtener el cliente que compra el producto
	 * 
	 * @return El cliente de la venta
	 */
	public String getCliente() {
		return cliente;
	}

	/**
	 * M�todo de consulta para obtener la oferta de la venta
	 * 
	 * @return La oferta de la venta
	 */
	public Oferta getOferta() {
		return oferta;
	}

	/**
	 * M�todo de consulta para obtener la cantidad de productos que se compran
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
	 * M�todo toString asociado a la clase venta
	 */
	// toString
	@Override
	public String toString() {
		return "Venta [fecha=" + fecha + ", cliente=" + cliente + ", oferta=" + oferta + ", cantidad=" + cantidad + "]";
	}

}
