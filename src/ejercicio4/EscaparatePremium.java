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
	 * Método de consulta para obtener los productos premium
	 * 
	 * @return El conjunto de productos premium
	 */
	public HashSet<Producto> getProductosPremium() {
		return new HashSet<Producto>(productosPremium);
	}

	/**
	 * Método de consulta para obtener los clientes vip
	 * 
	 * @return El conjunto de clientes vip
	 */
	public HashSet<String> getClientesVIP() {
		return new HashSet<String>(clientesVIP);
	}

	// Constructores
	/**
	 * Constructor heredado de la clase padre Escaparate. productosPremium y
	 * clientesVIP se inicializan como vaciós
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
	 * Función que se encarga de añadir productos al conjunto de productosPremium
	 * 
	 * @param productos
	 *            Argumento variable de los productos a añadir
	 */
	public void addProducto(Producto... productos) {
		for (Producto prod : productos) {
			if (super.getProductos().contains(prod))
				productosPremium.add(prod);
		}
	}

	/**
	 * Función que se encarga de añadir clientes al conjunto de clientesVIP
	 * 
	 * @param clientes
	 *            Argumento variable de los clientes a añadir
	 */
	public void addCliente(String... clientes) {
		Collections.addAll(clientesVIP, clientes);
	}

	/**
	 * Función que se encarga de quitar un producto del conjunto de productosPremium
	 * 
	 * @param producto
	 *            Producto a quitar
	 */
	public void removeProducto(Producto producto) {
		productosPremium.remove(producto);
	}

	/**
	 * Función que se encarga de quitar un cliente del conjunto de clientesVIP
	 * 
	 * @param cliente
	 *            Cliente a quitar
	 */
	public void removeCliente(String cliente) {
		clientesVIP.remove(cliente);
	}

	/**
	 * Método plantilla heredado de la clase padre
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
	 * Método toString asociado a la clase EscaparatePremium
	 */
	@Override
	public String toString() {
		return super.toString() + "productosPremium=" + productosPremium + ", clientesVIP=" + clientesVIP + "]";
	}

	// método Clone
	/**
	 * Método clone asociado a la clase EscaparatePremium
	 */
	@Override
	public EscaparatePremium clone() {
		EscaparatePremium copia = (EscaparatePremium) super.clone();
		copia.productosPremium = new HashSet<Producto>(productosPremium);
		copia.clientesVIP = new HashSet<String>(clientesVIP);
		return copia;
	}

}
