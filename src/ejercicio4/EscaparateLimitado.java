package ejercicio4;

import java.time.LocalDate;

/**
 * Clase heredada de la clase Escaparate
 */
public class EscaparateLimitado extends Escaparate {

	// Atributos
	/**
	 * Fecha fin del escaparate
	 */
	private LocalDate fechaFin;

	// Getters
	/**
	 * Método de consulta para obtener la fecha fin del escaparate
	 * 
	 * @return La fecha fin del escaparate
	 */
	public LocalDate getFechaFin() {
		return fechaFin;
	}

	/**
	 * Constructor heredado de la clase padre Escaparate. Se establece fechaFin a
	 * null.
	 * 
	 * @param nombre
	 *            Nombre del escaparate a crear
	 */
	public EscaparateLimitado(String nombre) {
		super(nombre);
		this.fechaFin = null;
	}

	// Fucionalidad
	/**
	 * Función que se encarga de establecer la fechaFin
	 * 
	 * @param fechaFin
	 *            Fecha fin del escaparate limitado
	 */
	public void abrir(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	/**
	 * Función que se encarga de ver si el escaparate está abierto o no
	 * 
	 * @return True si la fechaFin no es null y la fechaFin no ha llegado aún
	 */
	public boolean isAbierto() {
		return ((fechaFin != null) && (LocalDate.now().isBefore(fechaFin)));
	}

	/**
	 * Método plantilla heredado de la clase padre
	 */
	@Override
	public boolean isVendible(String cliente, Oferta oferta) {
		return isAbierto();
	}

	// toString
	/**
	 * Método toString asociado a la clase EscaparateLimitado
	 */
	@Override
	public String toString() {
		return super.toString() + "fechaFin=" + fechaFin + "]";
	}

	// método Clone
	/**
	 * Método clone asocuado a la clase EscaparateLimitado
	 */
	@Override
	public EscaparateLimitado clone() {
		EscaparateLimitado copia = (EscaparateLimitado) super.clone();
		copia.fechaFin = null;
		return copia;
	}
}
