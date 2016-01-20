package consultasMedicas.bussinesLogic.domain.objects;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import consultasMedicas.bussinesLogic.domain.utilities.Presentacion;

/**
 * Clase que representa a un medicamento.
 * 
 * @author Ainhoa Goirigolzarri
 *
 */

public class Medicamento implements Cloneable, Serializable {
	
	/**
	 * ID para la serialización
	 */
	private static final long serialVersionUID = -4526187736257092754L;

	/**
	 * Atributo que almacena el código único del medicamento
	 */
	private String codigo;
		
	/**
	 * Atributo que almacena el nombre del medicamento
	 */
	private String nombre;
	
	/**
	 * Atributo que almacena la lista de principios activos del medicamento
	 */
	private HashMap<String, PrincipioActivo> listaPrincipiosActivos;
	
	/**
	 * Atributo que almacena el nombre del laboratorio que lo fabrica
	 */
	private String laboratorio;
		
	/**
	 * Atributo que almacena si el medicamento es un genérico o no
	 */
	private boolean generico;
	
	/**
	 * Atributo que almacena si el medicamento solo se vende con receta médica
	 */
	private boolean ventaConReceta;
	
	/**
	 * Atributo que almacena el tipo de preparación del medicamento 
	 */
	private Presentacion presentacion;

	/**
	 * Atributo que almacena el número de unidades que trae el medicamento 
	 */
	private int unidades;

	/**
	 * Metodo que permite obtener el código del medicamento 
	 * @return Cadena de texto que representa el código del medicamento 
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * Metodo que permite modificar el código del medicamento 
	 * @param codigo Cadena de texto que representa el nuevo código del medicamento 
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * Metodo que permite obtener el nombre del medicamento 
	 * @return Cadena de texto que representa el nombre del medicamento 
	 */
	public String getNombre() {
		return this.nombre;
	}

	/**
	 * Metodo que permite modificar el nombre del medicamento 
	 * @param nombre Cadena de texto que representa el nuevo nombre del medicamento 
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Método que devuelve la lista completa de Principios Activos del medicamento
	 * @return ArrayList que almacena la lista completa de Principios Activos del medicamento
	 */
	public ArrayList<PrincipioActivo> getListaPrincipiosActivos() {
		ArrayList<PrincipioActivo> lpa = new ArrayList<PrincipioActivo>();
		for(PrincipioActivo principioActivo : this.listaPrincipiosActivos.values())
			lpa.add(principioActivo);
		return lpa;
	}

	/**
	 * Método que transforma a cadena de texto la lista completa de Principios Activos del medicamento
	 * @return Cadena de texto con la lista completa de Principios Activos del medicamento
	 */
	public String listaPrincipiosActivosToString() {
		String stringPrincipiosActivos = "";
		if (this.listaPrincipiosActivos.size() > 0) { 
			stringPrincipiosActivos = "Principios Activos: " + this.listaPrincipiosActivos.size() + " \n";
			for(PrincipioActivo principioActivo : this.listaPrincipiosActivos.values())
				stringPrincipiosActivos += "   - " + principioActivo.getNombre() + " " + principioActivo.getDosis() + "\n";
		}
		else
		{
			stringPrincipiosActivos = "Medicamento sin principios activos \n";
		}
		return stringPrincipiosActivos;
	}

	
	/**
	 * Metodo que permite modificar la lista completa de Principios Activos del medicamento
	 * @param listaPrincipiosActivos Array que almacena la nueva lista completa de Principios Activos del medicamento
	 */
	public void setListaPrincipiosActivos(HashMap<String, PrincipioActivo> listaPrincipiosActivos) {
		this.listaPrincipiosActivos = listaPrincipiosActivos;
	}

	/**
	 * Metodo que permite añadir un Principio Activo al medicamento
	 * @param listaPrincipiosActivos Array que almacena la nueva lista completa de Principios Activos del medicamento
	 */
	public boolean  anyadirPrincipioActivo(PrincipioActivo principioActivo) {
		if (this.listaPrincipiosActivos == null)  
			this.listaPrincipiosActivos = new HashMap<String, PrincipioActivo>();
		if (this.listaPrincipiosActivos.containsKey(principioActivo.getNombre().toUpperCase()))
			return false;
		this.listaPrincipiosActivos.put(principioActivo.getNombre().toUpperCase(), principioActivo);
		return true;
	}
	
	/**
	 * Metodo que permite obtener el nombre del laboratorio que lo fabrica
	 * @return Cadena de texto que representa el nombre del laboratorio que lo fabrica
	 */
	public String getLaboratorio() {
		return laboratorio;
	}

	/**
	 * Metodo que permite modificar el nombre del laboratorio que lo fabrica
	 * @param laboratorio Cadena de texto que representa el nuevo nombre del laboratorio que lo fabrica
	 */
	public void setLaboratorio(String laboratorio) {
		this.laboratorio = laboratorio;
	}

	/**
	 * Metodo que permite obtener si el medicamento es un genérico o no
	 * @return Boolean que indica si el medicamento es un genérico o no
	 */
	public boolean isGenerico() {
		return this.generico;
	}

	/**
	 * Metodo que permite modificar si el medicamento es genérico o no
	 * @param generico Boolean que indica si el medicamento es un genérico o no
	 */	
	public void setGenerico(boolean generico) {
		this.generico = generico;
	}

	/**
	 * Metodo que permite obtener si el medicamento se vende con receta médica
	 * @return Boolean que indica si el medicamento se vende con receta médica
	 */
	public boolean isVentaConReceta() {
		return ventaConReceta;
	}

	/**
	 * Metodo que permite modificar si el medicamento se vende con receta médica
	 * @param ventaConReceta Boolean que indica si el medicamento se vende con receta médica
	 */	
	public void setVentaConReceta(boolean ventaConReceta) {
		this.ventaConReceta = ventaConReceta;
	}

	/**
	 * Metodo que permite obtener el tipo de presentación del medicamento
	 * @return Elemento de enumeración de tipo Presentacion que representa el tipo de presentación del medicamento
	 */
	public Presentacion getPresentacion() {
		return this.presentacion;
	}

	/**
	 * Metodo que permite modificar el tipo de presentación del medicamento
	 * @param presentacion Elemento de enumeración de tipo Presentacion que representa el nuevo tipo de presentación del medicamento
	 */	
	public void setPresentacion(Presentacion presentacion) {
		this.presentacion = presentacion;
	}
	
	/**
	 * Metodo que permite obtener el número de unidades que trae el medicamento 
	 * @return Integer que representa el número de unidades que trae el medicamento 
	 */
	public int getUnidades() {
		return unidades;
	}

	/**
	 * Metodo que permite modificar el número de unidades que trae el medicamento 
	 * @param presentacion Integer que representa el número de unidades que trae el medicamento 
	 */	
	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}
	
	/**
	 * Constructor por defecto de la clase;
	 */
	public Medicamento() {
		this.codigo = "";
		this.nombre = "";
		this.listaPrincipiosActivos = new HashMap<String, PrincipioActivo>();
		this.laboratorio = "";
		this.generico = true;
		this.ventaConReceta = true;
		this.presentacion = null;
		this.unidades = 0;
	}
	
	/**
	 * Constructor de la clase con parámetros
	 * @param nombre Cadena de texto con el nombre del medicamento 
	 * @param generico Boolean que indica si el medicamento es un genérico o no
	 * @param presentacion Elemento de la enumeración de tipo Preparacion
	 */
	public Medicamento(String codigo, String nombre, HashMap<String, PrincipioActivo> listaPrincipiosActivos, String laboratorio, boolean generico, boolean ventaConReceta, Presentacion presentacion, int unidades){
		this.codigo = codigo;
		this.nombre = nombre;
		this.listaPrincipiosActivos = listaPrincipiosActivos;
		this.laboratorio = laboratorio;
		this.generico = generico;
		this.ventaConReceta = ventaConReceta;
		this.presentacion = presentacion;
		this.unidades = unidades;
	}

	/**
	 * Método de la interfaz Cloneable que permite realizar el clonado
	 */
	@Override
	public Object clone() {
		try {
			Medicamento medicamentoClonado = (Medicamento)super.clone();
			return medicamentoClonado;
		}
		catch (CloneNotSupportedException ex) {
			return null;
		}
	}
	
	/**
	 * Metodo que obtiene una cadena de texto con el nombre del medicamento 
	 * @return Cadena de texto con el nombre del medicamento 
	 */
	@Override
	public String toString() {
		return this.nombre + " - " + this.unidades + " "  + this.presentacion ;
	}
	
	/**
	 * Metodo que obtiene una cadena de texto con los datos del medicamento 
	 * @return Cadena de texto con los datos del medicamento 
	 */
	public String toStringLargo() {
		String str = "";
		str += "Medicamento: " + this.nombre  + "\n";
		str += listaPrincipiosActivosToString();
		str += "Laboratorio: " + this.laboratorio + " \n";
		str += "Código: " + this.codigo + " \n";
		str += "Genérico: ";
		if (this.generico == true) 
			str += "Si \n";
		else
			str += "No \n";
		str += "Venta con receta: ";
		if (this.ventaConReceta == true) 
			str += "Si \n";
		else
			str += "No \n";
		str += "Presentación: " + this.presentacion + " \n";
		str += "Unidades: " + this.unidades + " \n";
		return str;
	}
	
	/**
	 * Programa principal para realizar las pruebas de la clase Medicamento
	 * @param args
	 */
	public static void main(String[] args) {
		// Creamos un objeto
		System.out.println("Creamos un objeto de tipo Medicamento y visualizamos sus propiedades");
		System.out.println("--------------------------------------------------------------------------");
		Medicamento medicamentoDePrueba = new Medicamento();
		// Asignamos los datos a las propiedades
		medicamentoDePrueba.setCodigo("660287.4");
		medicamentoDePrueba.setNombre("Fluimucil Complex");
		
		PrincipioActivo principioActivoDePrueba1 = new PrincipioActivo("Paracetamol", "500 mg");
		PrincipioActivo principioActivoDePrueba2 = new PrincipioActivo("Acetilcisteína", "200 mg");
		
		medicamentoDePrueba.anyadirPrincipioActivo(principioActivoDePrueba1);
		medicamentoDePrueba.anyadirPrincipioActivo(principioActivoDePrueba2);
		// comprobamos que el Principio Activo no se repite si ya está incluido 
		medicamentoDePrueba.anyadirPrincipioActivo(principioActivoDePrueba2);
		
		medicamentoDePrueba.setLaboratorio("Zambon");
		medicamentoDePrueba.setGenerico(false);
		medicamentoDePrueba.setVentaConReceta(false);
		medicamentoDePrueba.setPresentacion(Presentacion.COMPRIMIDO_EFERVESCENTE);
		medicamentoDePrueba.setUnidades(16);
		// Los visualizamos por pantalla
		System.out.println(medicamentoDePrueba);
		
	
		
	}
	
}

	
	


