package consultasMedicas.bussinesLogic.domain.objects;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.io.EOFException;
import java.io.IOException;
import java.io.Serializable;

import consultasMedicas.bussinesLogic.domain.objects.containers.Receta;
import consultasMedicas.bussinesLogic.domain.utilities.Cuidado;
import consultasMedicas.bussinesLogic.domain.utilities.Presentacion;
import consultasMedicas.bussinesLogic.domain.utilities.Sexo;

/**
 * Clase que representa a un paciente. Hereda de la clase Persona.
 * 
 * @author Ainhoa Goirigolzarri
 *
 */

public class Paciente extends Persona implements Serializable {
	
	/**
	 * ID para la serialización
	 */
	private static final long serialVersionUID = 9166017119919328872L;

	/**
	 * Atributo que almacena el número de Seguridad Social
	 */
	private String numeroSeguridadSocial;
	
	/**
	 * Atributo que almacena la lista de enfermedades del paciente
	 */
	private HashMap<String, Enfermedad> listaEnfermedades;
	
	/**
	 * Atributo que almacena la lista de recetas del paciente
	 */
	private HashMap<String, Receta> listaRecetas;
	
	/**
	 * Atributo que almacena la lista de cuidados del paciente
	 */
	private HashMap<String, Cuidado> listaCuidados;

	/**
	 * Override del método abstracto equivalente de la clase padre Persona
	 * Metodo que permite obtener el nombre completo del paciente
	 * @return Cadena de texto que representa el nombre de la persona
	 */
	@Override
	public String getNombreCompleto() {
			return  "Paciente " + super.getNombre() +  " " + super.getApellido1() +  " " + super.getApellido2();
	}
	
	/**
	 * Metodo que permite obtener el número de Seguridad Social del paciente
	 * @return Cadena de texto que representa el número de Seguridad Social del paciente
	 */
	public String getNumeroSeguridadSocial() {
		return this.numeroSeguridadSocial;
	}

	/**
	 * Metodo que permite modificar el número de Seguridad Social del paciente
	 * @param numerosocial Cadena de texto que representa el nuevo número de Seguridad Social del paciente
	 */
	public void setNumeroSeguridadSocial(String numeroSeguridadSocial) {
		this.numeroSeguridadSocial = numeroSeguridadSocial;
	}

	/**
	 * Método que devuelve la lista completa de enfermedades del paciente
	 * @return ArrayList con los medicamentos que el paciente tiene recetados
	 */
	public ArrayList<Enfermedad> getListaEnfermedades() {
		ArrayList<Enfermedad> le = new ArrayList<Enfermedad>();
		for (Enfermedad enfermedad : this.listaEnfermedades.values())
			le.add(enfermedad);
		return le;
	}

	/**
	 * Método que transforma a cadena de texto la lista de enfermedades del paciente
	 * @return Cadena de texto con las enfermedades del paciente
	 */
	public String listaEnfermedadesToString() {
		String str = "";
		if (this.listaEnfermedades.size() > 0) { 
			str +=  "Enfermedades: " + this.listaEnfermedades.size() + " \n\n";
			for(Enfermedad enfermedad : this.listaEnfermedades.values())
				str += enfermedad ;
		}
		else
		{
			str = "Paciente sin enfermedades \n";
		}
		return str;
	}
	
	/**
	 * Metodo que permite añadir una enfermedad diagnosticada al paciente
	 * @param enfermedad Objeto de tipo Enfermedad con la nueva enfermedad diagnosticada al paciente
	 */
	public void diagnosticarEnfermedad(Enfermedad enfermedad) {
		if (this.listaEnfermedades == null)
			this.listaEnfermedades = new  HashMap<String, Enfermedad>();
		if(!this.listaEnfermedades.containsKey(enfermedad.getNombre().toUpperCase()))
				this.listaEnfermedades.put(enfermedad.getNombre().toUpperCase(), enfermedad);
	}
	
	/**
	 * Metodo que permite quitar una enfermedad ya curada al paciente
	 * @param enfermedad Objeto de tipo Enfermedad con la enfermedad ya curada del paciente
	 */
	public void diagnosticarCuracion(Enfermedad enfermedad) {
		if (this.listaEnfermedades == null)
			this.listaEnfermedades = new  HashMap<String, Enfermedad>();
		if(this.listaEnfermedades.containsKey(enfermedad.getNombre().toUpperCase()))
				this.listaEnfermedades.remove(enfermedad.getNombre().toUpperCase());
	}
	
	/**
	 * Método que devuelve la lista completa de medicamentos que el paciente tiene recetados
	 * @return ArrayList con los medicamentos que el paciente tiene recetados
	 */
	public ArrayList<Medicamento> getListaMedicamentos() {
		ArrayList<Medicamento> lm = new ArrayList<Medicamento>();
		for (Receta receta : this.listaRecetas.values()) 
			lm.add(receta.getMedicamento() );
		return lm;
	}
	
	/**
	 * Método que devuelve la lista completa de recetas del paciente
	 * @param receta 
	 * @return Array que almacena las recetas del paciente
	 */
	public ArrayList<Receta> getListaRecetas() {
		ArrayList<Receta> lr = new ArrayList<Receta>();
		for(Receta receta : this.listaRecetas.values())
			lr.add(receta);
		return lr;
	}
	
	/**
	 * Método que transforma a cadena de texto la lista de recetas del paciente
	 * @return Cadena de texto con las recetas del paciente
	 */
	public String listaRecetasToString() {
		String str = "";
		if (this.listaRecetas.size() > 0) { 
			str +=  "Recetas: " + this.listaRecetas.size() + " \n\n";
			for(Receta receta : this.listaRecetas.values())
				str += receta ;
		}
		else
		{
			str = "Paciente sin recetas \n";
		}
		return str;
	}

	/**
	 * Metodo que permite recetar una lista de medicamentos al paciente
	 * @param Parametros variables Objetos Recetas con las nuevas recetas del paciente
	 */
	public void recetarMedicamentos(Receta ... listaRecetas) {
		if (this.listaRecetas == null)
			this.listaRecetas = new  HashMap<String, Receta>();
		for (Receta nuevaReceta: listaRecetas) {
			if(!this.listaRecetas.containsKey(nuevaReceta.getMedicamento().getCodigo()))
					this.listaRecetas.put(nuevaReceta.getMedicamento().getCodigo(), nuevaReceta);
		}
	}
	
	/**
	 * Metodo que permite quitar un medicamento al paciente
	 * @param medicamentoAQuitar Objeto Medicamento con el medicamento a quitar
	 */
	public boolean quitarMedicamento(Medicamento medicamentoAQuitar) {
		Receta receta = getReceta(medicamentoAQuitar);
	    if (receta != null) {
	    	this.listaRecetas.remove(medicamentoAQuitar.getCodigo());
	    	return true;
	    }
    	else {
	    		return false;	
    	}
	}
	
	/**
	 * Metodo que permite obtener la receta de un medicamento que esté tomando el paciente
	 * @param medicamentoabuscar Objeto Medicamento con el medicamento a buscar
	 * @return receta Objeto Receta con la receta de ese medicamento para ese paciente
	 */
	public Receta getReceta(Medicamento medicamentoABuscar) {
		for (Receta receta: this.listaRecetas.values()) {
		      if (receta.getMedicamento().getCodigo().equals(medicamentoABuscar.getCodigo())) {
		        return receta;
		      }
	    }
	    return null;
	  }

	
	/**
	 * Método que devuelve la lista completa de cuidados del paciente
	 * @return ArrayList con la lista completa de cuidados del paciente
	 */
	public ArrayList<Cuidado> getListaCuidados() {
		ArrayList<Cuidado> lc = new ArrayList<Cuidado>();
		for (Cuidado cuidado : this.listaCuidados.values())
			lc.add(cuidado);
		return lc;
	}

	/**
	 * Método que transforma a cadena de texto la lista de cuidados del paciente
	 * @return Cadena de texto con los cuidados del paciente
	 */
	public String listaCuidadosToString() {
		String str = "";
		if (this.listaCuidados.size() > 0) { 
			str +=  "Cuidados: " + this.listaCuidados.size() + " \n\n";
			for(Cuidado cuidado : this.listaCuidados.values())
				str += cuidado + " \n";
		}
		else
		{
			str = "Paciente sin cuidados \n";
		}
		return str;
	}
	
	/**
	 * Metodo que permite aconsejar una lista de cuidados al paciente
	 * @param Parametros variables Objetos de tipo Cuidado con los nuevos cuidados del paciente
	 */
	public void aconsejarCuidados(Cuidado ... listaCuidados) {
		if (this.listaCuidados == null)
			this.listaCuidados = new  HashMap<String, Cuidado>();
		for (Cuidado cuidado : listaCuidados) {
			if(!this.listaCuidados.containsKey(cuidado))
					this.listaCuidados.put(cuidado.name(), cuidado);
		}
	}

	/**
	 * Metodo que permite quitar un cuidado al paciente
	 * @param cuidadoAQuitar Objeto Cuidado con el cuidado a quitar
	 */
	public void quitarCuidado(Cuidado cuidadoAQuitar) {
    	this.listaCuidados.remove(cuidadoAQuitar.name());
	}
	
	/**
	 * Metodo que permite leer un objeto tipo Paciente desde un fichero
	 */
	public Paciente leerPacienteDesdeFichero() throws Exception {
		java.io.InputStream is = new java.io.FileInputStream("Paciente_" + this.getDni() + ".dat");
		java.io.ObjectInputStream ois = new java.io.ObjectInputStream( is );
		Paciente paciente = null;
		try {
			paciente = (Paciente) ois.readObject();
		} catch (ClassCastException eCast) {
			System.out.println( "El fichero no tiene pacientes." );
			eCast.printStackTrace();
		} catch (EOFException e) {
			// fin del fichero
			e.printStackTrace();
		} finally {
			if (ois!=null) ois.close();
		}
		return paciente;
	}

	/**
	 * Metodo que permite salvar un objeto tipo Paciente a un fichero
	 */
	public void salvarPacienteEnFichero() throws IOException {
		java.io.OutputStream os = new java.io.FileOutputStream("Paciente_" + this.getDni() + ".dat");
		java.io.ObjectOutputStream oos = new java.io.ObjectOutputStream( os );
		oos.writeObject( this );
		oos.close();
	}

	/**
	 * Constructor por defecto de la clase;
	 */
	public Paciente() {
		super();
		this.numeroSeguridadSocial = "";
		this.listaEnfermedades = new  HashMap<String, Enfermedad>();
		this.listaRecetas = new  HashMap<String, Receta>();
		this.listaCuidados = new  HashMap<String, Cuidado>();
	}
	
	/**
	 * Constructor de la clase con parámetros
	 * @param numerosocial número de Seguridad Social
	 * @param nombre Cadena de texto con el nombre
	 * @param apellido Cadena de texto con el apellido
	 * @param dni Cadena de texto con el dni
	 * @param sexo Elemento de la enumeración de tipo Sexo
	 * @param fechanacimiento Date con la fecha de nacimiento
	 */
	public Paciente(String numeroSeguridadSocial, String nombre, String apellido1, String apellido2, String dni, Sexo sexo, Date fechaNacimiento, HashMap<String, Enfermedad> listaEnfermedades, HashMap<String, Receta> listaRecetas, HashMap<String, Cuidado> listaCuidados){
		super(nombre, apellido1, apellido2, dni, sexo, fechaNacimiento);
		this.numeroSeguridadSocial = numeroSeguridadSocial;
		this.listaEnfermedades = listaEnfermedades;
		this.listaRecetas = listaRecetas;
		this.listaCuidados = listaCuidados;
	}

	/**
	 * Metodo que obtiene una cadena de texto con el Paciente
	 * @return Cadena de texto con los datos del Paciente
	 */
	@Override
	public String toString() {
		String str = "";
		/*
		str += super.toString();
		str += "Número Seguridad Social: " + this.numeroSeguridadSocial + " \n";
		*/
		str =  super.getApellido1() + " " + super.getApellido2() + " " + super.getNombre() + " / DNI: " + super.getDni() + " / Número SS: " + this.numeroSeguridadSocial + " \n";
		return str;
	}
	
	/**
	 * Metodo que obtiene una cadena de texto con el Paciente y sus enfermedades, recetas y cuidados
	 * @return Cadena de texto con los datos del Paciente  y sus enfermedades, recetas y cuidados
	 */
	public String toStringCompleto() {
		String str = "";
		str += "-------------------------------------------------------------------------- \n";
		str += this.toString();
		str += "-------------------------------------------------------------------------- \n";
		str += this.listaEnfermedadesToString();
		str += "-------------------------------------------------------------------------- \n";
		str += this.listaRecetasToString();
		str += "-------------------------------------------------------------------------- \n";
		str += this.listaCuidadosToString();
		str += "-------------------------------------------------------------------------- \n";
		return str;
	}
	
	/**
	 * Programa principal para realizar las pruebas de la clase Paciente
	 * @param args
	 */
	public static void main(String[] args) {
		// Creamos un objeto
		System.out.println("Creamos un objeto de tipo Paciente y visualizamos sus propiedades");
		System.out.println("--------------------------------------------------------------------------");
		Paciente pacienteDePrueba = new Paciente();
		// Asignamos los datos a las propiedades
		pacienteDePrueba.setNumeroSeguridadSocial("48111111");
		pacienteDePrueba.setDni("44444444Q");
		pacienteDePrueba.setApellido1("ALONSO");
		pacienteDePrueba.setApellido2("GARAY");
		pacienteDePrueba.setNombre("MARTA");
		pacienteDePrueba.setSexo(Sexo.MUJER);
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		pacienteDePrueba.setFechaNacimiento(sdf.parse("19-01-1991", new ParsePosition(0)));
		
		// Los visualizamos por pantalla
		System.out.println(pacienteDePrueba);
		
		// Creamos un objeto de tipo Enfermedad para poder diagnosticarsela
		Enfermedad gripe = new Enfermedad("Gripe",false,true,false,true,false);
		System.out.println("Diagnosticamos la enfermedad " + gripe.getNombre());
		System.out.println("--------------------------------------------------------------------------");
		pacienteDePrueba.diagnosticarEnfermedad(gripe);
		System.out.println(pacienteDePrueba.listaEnfermedadesToString());
		
		// Creamos dos objetos de tipo Receta para poder recetarlos 
		Medicamento aspirina = new Medicamento("712786", "Aspirina 500 mg comprimidos", null, "Bayer Hispania, S.L.", false, false, Presentacion.COMPRIMIDO, 20);
		aspirina.anyadirPrincipioActivo(new PrincipioActivo("Ácido acetilsalicílico","500 mg"));
		Receta receta1 = new Receta(aspirina, new Date(), 3, 1, 1, 1);
		
		Medicamento fluimucil = new Medicamento("660287.4", "Fluimucil Complex", null, "Zambon", false, false, Presentacion.COMPRIMIDO_EFERVESCENTE, 16);
		fluimucil.anyadirPrincipioActivo(new PrincipioActivo("Paracetamol","500 mg"));
		fluimucil.anyadirPrincipioActivo(new PrincipioActivo("Acetilcisteína","200 mg"));
		Receta receta2 = new Receta(fluimucil, new Date(),5,1,0,1);
		
		// Recetamos los medicamentos con una única llamada al módulo porque este admite un número de parámetros variable.
		System.out.println("Recetamos los medicamentos " + aspirina.getNombre() + " y " + fluimucil.getNombre());
		System.out.println("--------------------------------------------------------------------------");
		pacienteDePrueba.recetarMedicamentos(receta1, receta2);

		// Visualizamos las recetas por pantalla
		System.out.println(pacienteDePrueba.listaRecetasToString());
		
		// Aconsejamos los cuidados
		pacienteDePrueba.aconsejarCuidados(Cuidado.REPOSO, Cuidado.CALOR);
		System.out.println("Aconsejamos los cuidados " + Cuidado.REPOSO + " y " + Cuidado.CALOR);
		System.out.println("--------------------------------------------------------------------------");
		System.out.println(pacienteDePrueba.listaCuidadosToString());
				
		System.out.println("Salvamos al paciente en disco con las dos recetas");
		System.out.println("--------------------------------------------------------------------------");
		try {
			pacienteDePrueba.salvarPacienteEnFichero();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Quitamos la receta del medicamento " + aspirina.getNombre());
		System.out.println("--------------------------------------------------------------------------");
		pacienteDePrueba.quitarMedicamento(aspirina);
		
		// Visualizamos la receta que queda por pantalla
		System.out.println(pacienteDePrueba.listaRecetasToString());
		
		Paciente pacienteDeFichero = new Paciente();
		System.out.println("Recuperamos el paciente salvado en disco con las dos recetas y visualizamos sus propiedades");
		System.out.println("--------------------------------------------------------------------------");
		try {
			pacienteDeFichero = pacienteDePrueba.leerPacienteDesdeFichero();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Visualizamos el paciente salvado en disco
		System.out.println(pacienteDePrueba);
		System.out.println(pacienteDePrueba.listaEnfermedadesToString());
		System.out.println(pacienteDeFichero.listaRecetasToString());
		System.out.println(pacienteDePrueba.listaCuidadosToString());
		
		// Polimorfismo. pacientedeprueba2 se define de tipo Persona pero se le asigna un objeto Paciente y utiliza el método getNombreCompleto de la clase Paciente
		// Persona pacientedeprueba2 = new Paciente();
		// pacientedeprueba2.setApellido1("ALONSO");
		// pacientedeprueba2.setNombre("MARTA");
		// System.out.println(pacientedeprueba2.getNombreCompleto());
		// System.out.println(pacientedeprueba2 instanceof Paciente);
				
	}
	
}
