package ejercicio4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

/**
 * Clase en la que se publicitan las ofertas de vendedores para los productos y
 * se gestionan las ventas de los productos ofertados controlando que haya stock
 * disponible Es una clase abstracta y permite clonación
 */
public abstract class Escaparate implements Cloneable {

	// Atributos
	/**
	 * Cadena de texto que identifica al escaparate. Puede cambiar.
	 */
	private String nombre;
	private HashMap<Producto, HashSet<Oferta>> ofertas;
	private LinkedList<Venta> ventas;
	private HashMap<Oferta, Integer> stock;

	// Getters
	/**
	 * Método de consulta para obtener el nombre del escaparate
	 * 
	 * @return El nombre del escaparate
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Método de establecimiento para cambiar el nombre del escaparate
	 * 
	 * @param nombre
	 *            Nombre del escaparate
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Método de consulta para obtener la lista de ventas del escaparate
	 * 
	 * @return La lista de ventas del escaparate
	 */
	public LinkedList<Venta> getVentas() {
		return new LinkedList<Venta>(ventas);
	}

	/**
	 * Propiedad calculada para obtener el conjunto de productos del escaparate, a
	 * través del mapa de ofertas
	 * 
	 * @return Conjunto de productos del escaparate
	 */
	public Set<Producto> getProductos() {
		return ofertas.keySet();
	}

	// Constructores
	/**
	 * Constructor de la clase Escaparate para crear objetos de esta clase. Ofertas,
	 * ventas y stock se inicializan como vacías.
	 * 
	 * @param nombre
	 *            Nombre del escaparate a crear
	 */
	public Escaparate(String nombre) {
		this.nombre = nombre;
		this.ofertas = new HashMap<Producto, HashSet<Oferta>>();
		this.ventas = new LinkedList<Venta>();
		this.stock = new HashMap<Oferta, Integer>();
	}

	// Funcionalidad
	/**
	 * Función que se encarga de dar de alta un producto
	 * 
	 * @param nombre
	 *            Nombre del producto a dar de alta
	 * @param descripcion
	 *            Descripción del producto a dar de alta
	 * @return El producto dado de alta
	 */
	public Producto altaProducto(String nombre, String descripcion) {
		Producto producto = new Producto(nombre, descripcion);
		ofertas.put(producto, new HashSet<Oferta>());
		return producto;
	}

	/**
	 * Función que se encarga de dar de alta una oferta
	 * 
	 * @param precio
	 *            Precio de la oferta a dar de alta
	 * @param vendedor
	 *            Vendedor de la oferta a dar de alta
	 * @param producto
	 *            Producto de la oferta a dar de alta
	 * @return La oferta dada de alta si se ha podido, o null en caso contrario
	 */
	public Oferta altaOferta(int precio, String vendedor, Producto producto) {
		if (getProductos().contains(producto)) {
			Iterator<Oferta> it = ofertas.get(producto).iterator();
			while (it.hasNext()) {
				Oferta of = it.next();
				if (of.getVendedor().equals(vendedor))
					it.remove();
			}
			Oferta oferta = new Oferta(vendedor, producto, precio);
			ofertas.get(producto).add(oferta);
			stock.put(oferta, 10);
			return oferta;
		}
		return null;
	}

	/**
	 * Función que se encarga de dar de baja una oferta
	 * 
	 * @param oferta
	 *            Oferta a dar de baja
	 * @return True si se ha dado de baja, false en caso contrario
	 */
	public boolean bajaOferta(Oferta oferta) {
		for (Producto prod : getProductos()) {
			if (ofertas.get(prod).contains(oferta)) {
				Iterator<Oferta> it = ofertas.get(prod).iterator();
				while (it.hasNext()) {
					Oferta of = it.next();
					if (of.equals(oferta))
						it.remove();
				}
				stock.remove(oferta);
				return true;
			}
		}
		return false;
	}

	/**
	 * Función que se encarga de consultar las ofertas disponibles para un producto
	 * dado
	 * 
	 * @param producto
	 *            Producto sobre el que se ven las ofertas
	 * @return Un conjunto con las ofertas de ese producto
	 */
	public HashSet<Oferta> consultarOfertas(Producto producto) {
		HashSet<Oferta> ofer = ofertas.get(producto);
		if (ofer != null)
			return ofer;
		return new HashSet<Oferta>();
	}

	/**
	 * Función que se encarga de consultar si una oferta se encuentra en el mapa de
	 * stock
	 * 
	 * @param oferta
	 *            Oferta que se va a consultar
	 * @return True si está dentro de stock, false en caso contrario
	 */
	public boolean consultarOferta(Oferta oferta) {
		return stock.containsKey(oferta);
	}

	/**
	 * Función que se encarga de consultar la mejor oferta para un producto dado
	 * 
	 * @param producto
	 *            Producto del que se va a buscar la mejor oferta
	 * @return La mejor oferta para el producto dado
	 */
	public Oferta mejorOferta(Producto producto) {
		Oferta min = new Oferta("", producto, 999999999);
		for (Oferta ofer : stock.keySet()) {
			if (ofer.getPrecio() < min.getPrecio())
				min = ofer;
		}
		return min;
	}

	/**
	 * Función que se encarga de consultar el número de unidades de una oferta
	 * 
	 * @param oferta
	 *            Oferta de la que se va a consultar el número de unidades
	 * @return El número de unidades de la oferta, 0 si no se encuentra la oferta
	 */
	public int numeroUnidades(Oferta oferta) {
		if (stock.containsKey(oferta))
			return stock.get(oferta);
		return 0;
	}

	/**
	 * Función que se encarga de consultar el stock de una oferta
	 * 
	 * @param oferta
	 *            Oferta de la que se va a consultar el stock
	 * @return El stock para una determinada oferta
	 */
	public boolean consultarStock(Oferta oferta) {
		return stock.containsKey(oferta);
	}

	/**
	 * Método plantilla que establece la condición "vendible" para una oferta. Se
	 * hereda a sus clases heredadas.
	 * 
	 * @param cliente
	 *            Cliente que compra la oferta
	 * @param oferta
	 *            Oferta en la que se comprueba la condición
	 * @return True si es vendible, falso en caso contrario
	 */
	abstract public boolean isVendible(String cliente, Oferta oferta);

	/**
	 * Función que se encarga de realizar la venta de una oferta
	 * 
	 * @param cliente
	 *            Cliente que compra la venta realizada
	 * @param oferta
	 *            Oferta de la que se realiza la venta
	 * @param unidades
	 *            Unidades que quedan de la oferta de la que se realiza la venta
	 * @return La venta realizada, null si no se ha realizado
	 */
	public Venta realizarVenta(String cliente, Oferta oferta, int unidades) {
		if ((consultarOferta(oferta)) && (unidades <= numeroUnidades(oferta)) && (isVendible(cliente, oferta))) {
			Venta venta = new Venta(cliente, unidades, oferta);
			ventas.add(venta);
			int n = stock.get(oferta);
			n = n - unidades;
			if (n == 0)
				bajaOferta(oferta);
			else
				stock.replace(oferta, n);
			return venta;
		}
		return null;
	}

	/**
	 * Método sobrecargado de la función realizarVenta, omitiendo las unidades por
	 * una cantidad por defecto (1)
	 * 
	 * @param cliente
	 *            Cliente que compra la venta realizada
	 * @param oferta
	 *            Oferta de la que se realiza la venta
	 * @return La venta realizada, null si no se ha realizado
	 */
	public Venta realizarVenta(String cliente, Oferta oferta) {
		return realizarVenta(cliente, oferta, Venta.CANTIDAD_POR_DEFECTO);
	}

	// toString
	/**
	 * Método toString asociado a la clase Escaparate
	 */
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + "[nombre=" + nombre + ", ofertas=" + ofertas + ", ventas=" + ventas
				+ ", stock=" + stock + ", ";
	}

	// método Clone
	/**
	 * Método copiaSuperficial asociado a la clase Escaparate
	 * 
	 * @return Una copia del escaparate
	 */
	private Escaparate copiaSuperficial() {
		try {
			Escaparate copiaSuperficial = (Escaparate) super.clone();
			return copiaSuperficial;
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Método clone asociado a la clase Escaparate
	 */
	@Override
	public Escaparate clone() {
		Escaparate copia = copiaSuperficial();

		copia.ofertas = new HashMap<Producto, HashSet<Oferta>>(ofertas);
		copia.ventas = new LinkedList<Venta>();
		for (Oferta ofer : stock.keySet())
			copia.stock.replace(ofer, 10);

		return copia;

	}

}
