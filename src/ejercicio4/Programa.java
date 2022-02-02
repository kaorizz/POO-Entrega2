package ejercicio4;

import java.time.LocalDate;
import java.util.Collections;
import java.util.LinkedList;

/**
 * Clase que sirve par comprobar el funcionamiento del programa compuesto por
 * las clases Producto, Oferta, Venta, Escaparate, EscaparatePremium y
 * EscaparateLimitado
 */
public class Programa {

	/**
	 * Programa principal
	 * 
	 * @param args
	 *            Argumentos del programa
	 */
	public static void main(String[] args) {

		EscaparatePremium escaparate1 = new EscaparatePremium("Electrónica");
		escaparate1.addCliente("vipper@gmail.es");
		EscaparateLimitado escaparate2 = new EscaparateLimitado("Límite 48h");
		escaparate2.abrir(LocalDate.now().plusDays(2));
		LinkedList<Escaparate> escaparates = new LinkedList<Escaparate>();
		Collections.addAll(escaparates, escaparate1, escaparate2);

		for (Escaparate esc : escaparates) {
			System.out.println("Nombre: " + esc.getNombre());
			Producto producto1 = esc.altaProducto("auricular bluetooth", "auricular inalámbrico");
			Producto producto2 = esc.altaProducto("Chromecast", "reproductor multimedia");
			esc.altaOferta(20, "vendedor1", producto1);
			esc.altaOferta(22, "vendedor1", producto2);
			esc.altaOferta(34, "vendedor2", producto1);
			esc.altaOferta(27, "vendedor2", producto2);
			if (esc instanceof EscaparatePremium)
				((EscaparatePremium) esc).addProducto(producto2);
			for (Producto prod : esc.getProductos()) {
				Oferta ofer = esc.mejorOferta(prod);
				esc.realizarVenta("voraz@um.es", ofer, esc.numeroUnidades(ofer));
				System.out.println("¿Existe en el escaparate la mejor oferta?\n" + esc.consultarOferta(ofer));
			}
			System.out.println(esc.getVentas());
			System.out.println();
		}
	}
}
