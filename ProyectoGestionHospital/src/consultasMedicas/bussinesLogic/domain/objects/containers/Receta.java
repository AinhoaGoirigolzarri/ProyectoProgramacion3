package consultasMedicas.bussinesLogic.domain.objects.containers;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import consultasMedicas.bussinesLogic.domain.objects.Medicamento;
import consultasMedicas.bussinesLogic.domain.objects.PrincipioActivo;
import consultasMedicas.bussinesLogic.domain.utilities.Presentacion;


/**
 * Clase que representa a una receta.
 * 
 * @author Ainhoa Goirigolzarri
 *
 */

public class Receta implements Cloneable, Serializable {
	
	/**
	 * ID para la serialización
	 */
	private static final long serialVersionUID = 519550911457200084L;

	/**
	 * Atributo que almacena el medicamento recetado
	 */
	private Medicamento medicamento;
	
	/**
	 * Atributo que almacena la fecha de Inicio del Tratamiento
	 */
	private Date fechaInicioTratamiento;
	
	/**
	 * Atributo que almacena el número de días que hay que tomar el medicamento
	 */
	private int diasDeTratamiento;
	
	/**
	 * Atributo que almacena el número de dosis que hay que tomar con el desayuno
	 */
	private int dosisDesayuno;
	
	/**
	 * Atributo que almacena el número de dosis que hay que tomar con la comida
	 */
	private int dosisComida;
	
	/**
	 * Atributo que almacena el número de dosis que hay que tomar con la cena
	 */
	private int dosisCena;


	/**
	 * Metodo que permite obtener el medicamento recetado
	 * @return Objeto de tipo medicamento con el medicamento recetado
	 */
	public Medicamento getMedicamento() {
		return this.medicamento;
	}

	/**
	 * Metodo que permite modificar el medicamento recetado
	 * @param medicamento Objeto de tipo medicamento con el nuevo medicamento recetado
	 */
	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}

	/**
	 * Metodo que permite obtener la fecha del día que el paciente empeza a tomar el medicamento
	 * @return Date con la fecha del día que el paciente empeza a tomar el medicamento
	 */
	public Date getFechaInicioTratamiento(){
		return this.fechaInicioTratamiento;
	}
	
	/**
	 * Metodo que permite modificar la fecha del día que el paciente empeza a tomar el medicamento
	 * @param fechaInicioTratamiento Date con la nueva fecha del día que el paciente empeza a tomar el medicamento
	 */
	public void setFechaInicioTratamiento(Date fechaInicioTratamiento){
		this.fechaInicioTratamiento=fechaInicioTratamiento;
	}
		
	/**
	 * Metodo que permite obtener el número de días que el paciente tiene que tomar el medicamento
	 * @return Número entero con el número de días que el paciente tiene que tomar el medicamento
	 */
	public int getDiasDeTratamiento(){
		return this.diasDeTratamiento;
	}
	
	/**
	 * Metodo que permite modificar el número de días que el paciente tiene que tomar el medicamento
	 * @param diasDeTratamiento Número entero con el nuevo número de días que el paciente tiene que tomar el medicamento
	 */
	public void setDiasDeTratamiento(int diasDeTratamiento){
		this.diasDeTratamiento=diasDeTratamiento;
	}
	
	/**
	 * Metodo que permite obtener el número de dosis que el paciente tiene que tomar con el desayuno
	 * @return Número entero con el número de dosis que el paciente tiene que tomar con el desayuno
	 */
	public int getDosisDesayuno() {
		return this.dosisDesayuno;
	}

	/**
	 * Metodo que permite modificar el número de dosis que el paciente tiene que tomar con el desayuno
	 * @param dosisDesayuno Número entero con el nuevo número dosis que el paciente tiene que tomar con el desayuno
	 */
	public void setDosisDesayuno(int dosisDesayuno) {
		this.dosisDesayuno = dosisDesayuno;
	}
	
	/**
	 * Metodo que permite obtener el número de dosis que el paciente tiene que tomar con la comida
	 * @return Número entero con el número de dosis que el paciente tiene que tomar con la comida
	 */
	public int getDosisComida() {
		return this.dosisComida;
	}

	/**
	 * Metodo que permite modificar el número de dosis que el paciente tiene que tomar con la comida
	 * @param dosisComida Número entero con el nuevo número dosis que el paciente tiene que tomar con la comida
	 */
	public void setDosisComida(int dosisComida) {
		this.dosisComida = dosisComida;
	}
	
	/**
	 * Metodo que permite obtener el número de dosis que el paciente tiene que tomar con la cena
	 * @return Número entero con el número de dosis que el paciente tiene que tomar con la cena
	 */
	public int getDosisCena() {
		return this.dosisCena;
	}

	/**
	 * Metodo que permite modificar el número de dosis que el paciente tiene que tomar con la cena
	 * @param dosisCena Número entero con el nuevo número dosis que el paciente tiene que tomar con la cena
	 */
	public void setDosisCena(int dosisCena) {
		this.dosisCena = dosisCena;
	}
	
	/**
	 * Constructor por defecto de la clase;
	 */
    public Receta() {
		this.medicamento = new Medicamento();
		this.fechaInicioTratamiento = new Date();
		this.diasDeTratamiento = 0;
		this.dosisDesayuno = 0;
		this.dosisComida = 0;
		this.dosisCena = 0;
	}
	
	/**
	 * Constructor de la clase con parámetros
	 * @param medicamento Objeto de tipo medicamento con el medicamento recetado
	 * @param fechaInicioTratamiento Fecha del día que el paciente tiene que empezar a tomar el medicamento
	 * @param diasDeTratamiento Número entero con el número de días que el paciente tiene que tomar el medicamento
	 * @param dosisDesayuno Número entero con el número de dosis que el paciente tiene que tomar con el desayuno
	 * @param dosisComida Número entero con el número de dosis que el paciente tiene que tomar con la comida
	 * @param dosisCena Número entero con el número de dosis que el paciente tiene que tomar con la cena
	 */
	public Receta(Medicamento medicamento, Date fechaInicioTratamiento, int diasDeTratamiento, int dosisDesayuno, int dosisComida, int dosisCena){
		this.medicamento = medicamento;
		this.fechaInicioTratamiento = fechaInicioTratamiento;
		this.diasDeTratamiento = diasDeTratamiento;
		this.dosisDesayuno = dosisDesayuno;
		this.dosisComida = dosisComida;
		this.dosisCena = dosisCena;
	}
	
	/**
	 * Método de la interfaz Cloneable que permite realizar el clonado
	 */
	@Override
	public Object clone() {
		try {
			Receta recetaClonada = (Receta)super.clone();
			return recetaClonada;
		}
		catch (CloneNotSupportedException ex) {
			return null;
		}
	}
	
	/**
	 * Metodo que obtiene una cadena de texto con la receta
	 * @return Cadena de texto con los datos de la receta
	 */
	@Override
	public String toString() {
		return  this.medicamento.getNombre() + " " + this.medicamento.getPresentacion() + " (" + this.dosisDesayuno + "/" + this.dosisComida  + "/" + this.dosisCena + ") " + this.getDiasDeTratamiento() + " días"; 
	}
	
	/**
	 * Metodo que obtiene una cadena de texto con la receta
	 * @return Cadena de texto con los datos de la receta
	 */
	public String toStringLargo() {
		String stringReceta = "";

		stringReceta +="Fecha de inicio del tratamiento: " + new SimpleDateFormat("dd-MM-yyyy").format(this.fechaInicioTratamiento) + " \n";
		stringReceta +="Duración del tratamiento: " + this.diasDeTratamiento + " días \n";
		
		if (this.dosisDesayuno > 0) 
			stringReceta += "   - " + this.dosisDesayuno + " " + this.medicamento.getPresentacion() + " con el desayuno \n";
		if (this.dosisComida > 0) 
			stringReceta += "   - " + this.dosisComida + " " + this.medicamento.getPresentacion() + " con la comida \n";
		if (this.dosisCena > 0) 
			stringReceta += "   - " + this.dosisCena + " " + this.medicamento.getPresentacion() + " con la cena \n";
		
		stringReceta += this.medicamento + "\n";
		
		return stringReceta;
	}
	
	/**
	 * Programa principal para realizar las pruebas de la clase Receta
	 * @param args
	 */
	public static void main(String[] args) {
		// Creamos un objeto de tipo Medicamento para incluirlo en la receta

		// Creamos un objeto
		Medicamento medicamentoDePrueba = new Medicamento();
		// Asignamos los datos a las propiedades
		medicamentoDePrueba.setCodigo("660287.4");
		medicamentoDePrueba.setNombre("Fluimucil Complex");
		
		PrincipioActivo principioActivoDePrueba1 = new PrincipioActivo("Paracetamol", "500 mg");
		PrincipioActivo principioActivoDePrueba2 = new PrincipioActivo("Acetilcisteína", "200 mg");
		
		medicamentoDePrueba.anyadirPrincipioActivo(principioActivoDePrueba1);
		medicamentoDePrueba.anyadirPrincipioActivo(principioActivoDePrueba2);
		
		medicamentoDePrueba.setLaboratorio("Zambon");
		medicamentoDePrueba.setGenerico(false);
		medicamentoDePrueba.setVentaConReceta(false);
		medicamentoDePrueba.setPresentacion(Presentacion.COMPRIMIDO_EFERVESCENTE);
		medicamentoDePrueba.setUnidades(16);
		
		System.out.println("Creamos un objeto de tipo Receta y visualizamos sus propiedades");
		System.out.println("--------------------------------------------------------------------------");
		// Creamos un objeto de tipo Receta
		Receta recetaDePrueba = new Receta();
		
		// Asignamos los datos a las propiedades
		recetaDePrueba.setMedicamento(medicamentoDePrueba);
		// Asignamos como fecha inicio tratamiento la fecha de hoy
		recetaDePrueba.setFechaInicioTratamiento(new Date());
		recetaDePrueba.setDiasDeTratamiento(5);
		recetaDePrueba.setDosisDesayuno(1);
		recetaDePrueba.setDosisComida(0);
		recetaDePrueba.setDosisCena(1);

		System.out.println(recetaDePrueba);
	
	
	}
	
}

	


