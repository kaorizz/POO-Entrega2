package ejercicio4;

import java.util.Collections;
import java.util.HashSet;

/**
 * Clase heredada de la clase padre Escaparate
 */
public class EscaparatePremium extends Escaparate {

	// Atributos
	/**
	 * Conjunto de productos premium
	 */
	private HashSet<Producto> productosPremium;
	/**
	 * Conjunto de clientes vip
	 */
	private HashSet<String> clientesVIP;

	// Getters
	/**
	 * M�todo de consulta para obtener los productos premium
	 * 
	 * @return El conjunto de productos premium
	 */
	public HashSet<Producto> getProductosPremium() {
		return new HashSet<Producto>(productosPremium);
	}

	/**
	 * M�todo de consulta para obtener los clientes vip
	 * 
	 * @return El conjunto de clientes vip
	 */
	public HashSet<String> getClientesVIP() {
		return new HashSet<String>(clientesVIP);
	}

	// Constructores
	/**
	 * Constructor heredado de la clase padre Escaparate. productosPremium y
	 * clientesVIP se inicializan como vaci�s
	 * 
	 * @param nombre
	 *            Nombre del escaparate a crear
	 */
	public EscaparatePremium(String nombre) {
		super(nombre);
		this.productosPremium = new HashSet<Producto>();
		this.clientesVIP = new HashSet<String>();
	}

	// Funcionalidad
	/**
	 * Funci�n que se encarga de a�adir productos al conjunto de productosPremium
	 * 
	 * @param productos
	 *            Argumento variable de los productos a a�adir
	 */
	public void addProducto(Producto... productos) {
		for (Producto prod : productos) {
			if (super.getProductos().contains(prod))
				productosPremium.add(prod);
		}
	}

	/**
	 * Funci�n que se encarga de a�adir clientes al conjunto de clientesVIP
	 * 
	 * @param clientes
	 *            Argumento variable de los clientes a a�adir
	 */
	public void addCliente(String... clientes) {
		Collections.addAll(clientesVIP, clientes);
	}

	/**
	 * Funci�n que se encarga de quitar un producto del conjunto de productosPremium
	 * 
	 * @param producto
	 *            Producto a quitar
	 */
	public void removeProducto(Producto producto) {
		productosPremium.remove(producto);
	}

	/**
	 * Funci�n que se encarga de quitar un cliente del conjunto de clientesVIP
	 * 
	 * @param cliente
	 *            Cliente a quitar
	 */
	public void removeCliente(String cliente) {
		clientesVIP.remove(cliente);
	}

	/**
	 * M�todo plantilla heredado de la clase padre
	 */
	@Override
	public boolean isVendible(String cliente, Oferta oferta) {
		if (productosPremium.contains(oferta.getProducto())) {
			if (clientesVIP.contains(cliente))
				return true;
			return false;
		}
		return true;
	}

	// toString
	/**
	 * M�todo toString asociado a la clase EscaparatePremium
	 */
	@Override
	public String toString() {
		return super.toString() + "productosPremium=" + productosPremium + ", clientesVIP=" + clientesVIP + "]";
	}

	// m�todo Clone
	/**
	 * M�todo clone asociado a la clase EscaparatePremium
	 */
	@Override
	public EscaparatePremium clone() {
		EscaparatePremium copia = (EscaparatePremium) super.clone();
		copia.productosPremium = new HashSet<Producto>(productosPremium);
		copia.clientesVIP = new HashSet<String>(clientesVIP);
		return copia;
	}

}
