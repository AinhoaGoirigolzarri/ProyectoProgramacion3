package consultasMedicas.bussinesLogic.domain.objects.containers;
import java.io.Serializable;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

import consultasMedicas.bussinesLogic.domain.objects.Medico;
import consultasMedicas.bussinesLogic.domain.objects.Paciente;
import consultasMedicas.bussinesLogic.domain.utilities.Especialidad;
import consultasMedicas.bussinesLogic.domain.utilities.Sexo;


/**
 * Clase que representa una consulta médica de un paciente a un médico.
 * 
 * @author Ainhoa Goirigolzarri
 *
 */

public class Consulta implements Cloneable, Serializable {

	/**
	 * ID para la serialización
	 */
	private static final long serialVersionUID = 4679032855779507092L;

	/**
	 * Atributo que almacena la fecha y hora de la consulta
	 */
	private Cita cita;
	
	/**
	 * Atributo que almacena los sintomas que tiene el paciente
	 */
	private String sintomas;
	
	/**
	 * Atributo que almacena un objeto de tipo Diagnostico con el diagnóstico que el médico realiza sobre el paciente
	 */
	private String diagnostico;


	/**
	 * Método que permite obtener la cita de la consulta
	 * @return Objeto de tipo Cita con la cita de la consulta
	 */
	public Cita getCita() {
		return cita;
	}

	/**
	 * Método que permite modificar la cita de la consulta
	 * @param cita Nueva cita de la consulta
	 */
	public void setCita(Cita cita) {
		this.cita = cita;
	}

	/**
	 * Método que permite obtener los síntomas del paciente
	 * @return Cadena de texto con los síntomas del paciente
	 */
	public String getSintomas() {
		return sintomas;
	}

	/**
	 * Metodo que permite modificar los síntomas del paciente
	 * @param sintomas Cadena de texto con los síntomas del paciente
	 */
	public void setSintomas(String sintomas) {
		this.sintomas = sintomas;
	}

	/**
	 * Método que permite obtener el diagnóstico del médico
	 * @return Cadena de texto con el diagnóstico del médico
	 */
	public String getDiagnostico() {
		return diagnostico;
	}

	/**
	 * Método que permite modificar el diagnóstico del médico
	 * @param diagnostico Cadena de texto con el nuevo diagnóstico
	 */
	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	/**
	 * Constructor por defecto de la clase;
	 */
	public Consulta() {
			  this.setCita(new Cita());
			  this.sintomas = "";
			  this.diagnostico = "";
	}

	/**
	 * Constructor de la clase con parámetros
	 * @param cita Objeto de tipo Cita que representa la cita de la consulta
	 * @param sintomas Cadena de texto con los sintomas que tiene el paciente
	 * @param diagnostico Cadena de texto con el diagnóstico del médico
	 */
	public Consulta(Cita cita, String sintomas, String diagnostico){
		this.setCita(cita);
		this.sintomas = sintomas;
		this.diagnostico = diagnostico;
	}

	/**
	 * Método de la interfaz Cloneable que permite realizar el clonado
	 */
	@Override
	public Object clone() {
		try {
			Consulta consultaClonada = (Consulta)super.clone();
			return consultaClonada;
		}
		catch (CloneNotSupportedException ex) {
			return null;
		}
	}
	
	
	/**
	 * Método que obtiene una cadena de texto con la Consulta
	 * @return Cadena de texto con los datos de la Consulta
	 */
	@Override
	public String toString() {
		String str = "";
		str += cita.toString();
		str += "Síntomas: " + this.sintomas + " \n";
		str += "Diagnóstico: " + this.diagnostico + " \n";
		str += "--------------------------------------------------------------------------\n";
		return str;
	}

	
	/**
	 * Programa principal para realizar las pruebas de la clase Consulta
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Creamos un objeto de tipo Medico para incluirlo en la consulta
		Medico medicodeprueba = new Medico();
		// Asignamos los datos a las propiedades del medico
		medicodeprueba.setCodmedico("11111");
		medicodeprueba.setEspecialidad(Especialidad.MEDICINA_INTERNA);
		medicodeprueba.setDni("22222222Z");
		medicodeprueba.setApellido1("OLEAGA");
		medicodeprueba.setApellido2("GOMEZ");
		medicodeprueba.setNombre("LEIRE");
		medicodeprueba.setSexo(Sexo.MUJER);
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		medicodeprueba.setFechaNacimiento(sdf.parse("11-08-1990", new ParsePosition(0)));
		
		// Creamos un objeto de tipo Paciente
		Paciente pacientedeprueba = new Paciente();
		// Asignamos los datos a las propiedades del paciente
		pacientedeprueba.setNumeroSeguridadSocial("48111111");
		pacientedeprueba.setDni("44444444Q");
		pacientedeprueba.setApellido1("ALONSO");
		pacientedeprueba.setApellido2("GARAY");
		pacientedeprueba.setNombre("MARTA");
		pacientedeprueba.setSexo(Sexo.MUJER);
		pacientedeprueba.setFechaNacimiento(sdf.parse("19-01-1991", new ParsePosition(0)));

		Cita citaDePrueba = new Cita(new Date(),medicodeprueba,pacientedeprueba);
		
		System.out.println("Creamos un objeto de tipo Consulta y visualizamos sus propiedades");
		System.out.println("--------------------------------------------------------------------------");
		
		// Creamos un objeto de tipo Consulta
		Consulta consultaDePrueba = new Consulta();
		consultaDePrueba.cita = citaDePrueba;
		consultaDePrueba.sintomas = "Dolor de cabeza y fiebre.";
		consultaDePrueba.diagnostico = "El paciente tiene gripe";

		System.out.println(consultaDePrueba);
		
	}
	
	
}
