package consultasMedicas.bussinesLogic.domain.objects;
import java.io.Serializable;

/**
 * 
 */

/**
 * Clase que representa a un Principio Activo de un medicamento.
 * 
 * @author Ainhoa Goirigolzarri
 *
 */

public class PrincipioActivo implements Cloneable, Serializable {

	/**
	 * ID para la serialización
	 */
	private static final long serialVersionUID = -8442671442631081961L;

	/**
	 * Atributo que almacena el nombre del Principio Activo
	 */
	private String nombre;
	
	/**
	 * Atributo que almacena la dosis del Principio Activo por unidad del medicamento
	 */
	private String dosis;
	

	/**
	 * Metodo que permite obtener el nombre del Principio Activo
	 * @return Cadena de texto que representa el nombre del Principio Activo
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Metodo que permite modificar el nombre del Principio Activo
	 * @param nombre Cadena de texto que representa el nuevo nombre del Principio Activo
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Metodo que permite obtener la dosis del Principio Activo por unidad del medicamento
	 * @return Cadena de texto que representa la dosis del Principio Activo por unidad del medicamento
	 */
	public String getDosis() {
		return dosis;
	}

	/**
	 * Metodo que permite modificar la dosis del Principio Activo por unidad del medicamento
	 * @param nombre Cadena de texto que representa la nueva dosis del Principio Activo por unidad del medicamento
	 */
	public void setDosis(String dosis) {
		this.dosis = dosis;
	}

	/**
	 * Constructor por defecto de la clase;
	 */
	public PrincipioActivo() {
		this.nombre = "";
		this.dosis = "";
	}
	
	/**
	 * Constructor de la clase con parámetros
	 * @param nombre Cadena de texto con el nombre del Principio Activo 
	 * @param dosis Cadena de texto con la dosis del Principio Activo por unidad del medicamento
	 */
	public PrincipioActivo(String nombre, String dosis) {
		this.nombre = nombre;
		this.dosis = dosis;
	}
	
	/**
	 * Método de la interfaz Cloneable que permite realizar el clonado
	 */
	@Override
	public Object clone() {
		try {
			PrincipioActivo principioActivoClonado = (PrincipioActivo)super.clone();
			return principioActivoClonado;
		}
		catch (CloneNotSupportedException ex) {
			return null;
		}
	}
	
	/**
	 * Metodo que obtiene una cadena de texto con los datos del Principio Activo
	 * @return Cadena de texto con los datos del Principio Activo
	 */
	@Override
	public String toString() {
		String str = "";
		str += "Principio activo: " + this.nombre  + "\n";
		str += "Dosis: " + this.dosis + " \n";
		return str;
	}
		
	/**
	 * Programa principal para realizar las pruebas de la clase PrincipioActivo
	 * @param args
	 */
	public static void main(String[] args) {
		// Creamos un objeto
		System.out.println("Creamos un objeto de tipo PrincipioActivo y visualizamos sus propiedades");
		System.out.println("--------------------------------------------------------------------------");
		PrincipioActivo principioActivoDePrueba = new PrincipioActivo();
		// Asignamos los datos a las propiedades
		principioActivoDePrueba.setNombre("Ácido acetilsalicílico");
		principioActivoDePrueba.setDosis("500 mg");
		// Los visualizamos por pantalla
		System.out.println(principioActivoDePrueba);
	
	
	}

}
