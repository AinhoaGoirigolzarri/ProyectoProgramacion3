package consultasMedicas.bussinesLogic.domain.objects;
import java.io.Serializable;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

import consultasMedicas.bussinesLogic.domain.utilities.Especialidad;
import consultasMedicas.bussinesLogic.domain.utilities.Sexo;

/**
 * Clase que representa a un m�dico. Hereda de la clase Persona.
 * 
 * @author Ainhoa Goirigolzarri
 *
 */

public class Medico extends Persona implements Cloneable, Serializable {
	
	/**
	 * ID para la serializaci�n
	 */
	private static final long serialVersionUID = 6426724970747922207L;

	/**
	 * Atributo que almacena el n�mero de colegiado del m�dico
	 */
    private String codmedico;
    
	/**
	 * Atributo que almacena la especialidad del m�dico
	 */
	private Especialidad especialidad;


	/**
	 * Override del m�todo abstracto equivalente de la clase padre Persona
	 * Metodo que permite obtener el nombre completo del m�dico con el tratamiento de Doctor por delante
	 * @return Cadena de texto que representa el nombre de la persona
	 */
	@Override
	public String getNombreCompleto() {
		if (super.getSexo() == Sexo.MUJER )
			return  "Doctora " + super.getNombre() +  " " + super.getApellido1() +  " " + super.getApellido2();
		else
			return  "Doctor " + super.getNombre() +  " " + super.getApellido1() +  " " + super.getApellido2();
	}
	
	/**
	 * M�todo que permite obtener el n�mero de colegiado
	 * @return Cadena de texto que representa el n�mero de colegiado
	 */
	public String getcodmedico(){
		return this.codmedico;
	}
	
	/**
	 * M�todo que permite modificar el n�mero de colegiado
	 * @param codmedico Cadena de texto que representa el nuevo n�mero de colegiado
	 */
	public void setCodmedico(String codmedico){
		this.codmedico=codmedico;
	}
	
	/**
	 * M�todo que permite obtener la especialidad 
	 * @return Elemento de enumeraci�n de tipo Especialidad que representa la especialidad
	 */
	public Especialidad getEspecialidad() {
		return this.especialidad;
	}

	/**
	 * M�todo que permite modificar la especialidad 
	 * @param especialidad Elemento de enumeraci�n de tipo Especialidad que representa la nueva especialidad
	 */
	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}
	
	/**
	 * Constructor por defecto de la clase;
	 */
	public Medico() {
		super();
	    codmedico = "";
		especialidad = null;
	}
	
	/**
	 * Constructor de la clase con par�metros
	 * @param codmedico Cadena de texto con n�mero de colegiado
	 * @param especialidad Elemento de la enumeraci�nde tipo Especialidad
	 * @param nombre Cadena de texto con el nombre
	 * @param apellido Cadena de texto con el apellido
	 * @param dni Cadena de texto con el dni
	 * @param sexo Elemento de la enumeraci�n de tipo Sexo
	 * @param fechanacimiento Date con la fecha de nacimiento
	 */
	public Medico(String codmedico, Especialidad especialidad, String nombre, String apellido1, String apellido2, String dni, Sexo sexo, Date fechaNacimiento){
		super(nombre, apellido1, apellido2, dni, sexo, fechaNacimiento);
		this.codmedico=codmedico;
		this.especialidad=especialidad;
	}
		
	/**
	 * M�todo de la interfaz Cloneable que permite realizar el clonado
	 */
	@Override
	public Object clone() {
		try {
			Medico medicoClonado = (Medico)super.clone();
			return medicoClonado;
		}
		catch (CloneNotSupportedException ex) {
			return null;
		}
	}
	
	
	/**
	 * M�todo que obtiene una cadena de texto con el m�dico
	 * @return Cadena de texto con los datos del m�dico
	 */
	@Override
	public String toString() {
		String str = "";
		/*
		str += super.toString();
		str += "N�mero colegiado: " + this.codmedico + " \n";
		str += "Especialidad: " + this.especialidad + " \n";
		*/
		
		str += super.getNombre() + " " + super.getApellido1() + " " + super.getApellido2() + " - Colegiado: " + this.codmedico + " - " + this.especialidad ;
		return str;
	}

	/**
	 * Programa principal para realizar las pruebas de la clase Medico
	 * @param args
	 */
	public static void main(String[] args) {
		// Creamos un objeto
		System.out.println("Creamos un objeto de tipo Medico y visualizamos sus propiedades");
		System.out.println("--------------------------------------------------------------------------");
		Medico medicodeprueba = new Medico();
		// Asignamos los datos a las propiedades
		medicodeprueba.setCodmedico("11111");
		medicodeprueba.setEspecialidad(Especialidad.CARDIOLOGIA);
		medicodeprueba.setDni("22222222Z");
		medicodeprueba.setApellido1("OLEAGA");
		medicodeprueba.setApellido2("GOMEZ");
		medicodeprueba.setNombre("LEIRE");
		medicodeprueba.setSexo(Sexo.MUJER);
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		medicodeprueba.setFechaNacimiento(sdf.parse("11-08-1970", new ParsePosition(0)));
		
		// Los visualizamos por pantalla
		System.out.println(medicodeprueba);
		
	
		// Polimorfismo. medicodeprueba2 se define de tipo Persona pero se le asigna un nuevo Medico y utiliza el m�todo getNombreCompleto de la clase Medico
		/* 
		 * Persona medicodeprueba2 = new Medico();
		 * medicodeprueba2.setApellido1("OLEAGA");
		 * medicodeprueba2.setNombre("LEIRE");
		 * System.out.println(medicodeprueba2.getNombreCompleto());
		 */
		
	}
	
}

