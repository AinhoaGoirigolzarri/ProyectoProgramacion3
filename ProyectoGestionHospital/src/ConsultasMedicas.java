import java.awt.EventQueue;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;

import consultasMedicas.bussinesLogic.domain.objects.*;
import consultasMedicas.bussinesLogic.domain.objects.containers.Cita;
import consultasMedicas.bussinesLogic.domain.objects.containers.Consulta;
import consultasMedicas.bussinesLogic.domain.objects.containers.Receta;
import consultasMedicas.bussinesLogic.domain.utilities.Cuidado;
import consultasMedicas.bussinesLogic.domain.utilities.Especialidad;
import consultasMedicas.bussinesLogic.domain.utilities.Presentacion;
import consultasMedicas.bussinesLogic.domain.utilities.Sexo;
import consultasMedicas.windows.frames.JMainWindow;
/**
 * /**
 * Clase independiente que permite probar todos los objetos del proyecto ConsultasMedicas.
 *
 * @author Ainhoa Goirigolzarri
 *
 */
public class ConsultasMedicas {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JMainWindow frame = new JMainWindow();
					frame.setLocationRelativeTo(null);
				    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
	
	/**
	 * @param args
	 */
	public static void mainTexto(String[] args) {

		System.out.println("============================================================================================================");
		System.out.println("# Creamos un objeto de tipo Enfermedad para poder diagnosticarla mas adelante y visualizamos sus propiedades");
		System.out.println("============================================================================================================");
		
		// Creamos el objeto de tipo Enfermedad
		Enfermedad gripe = new Enfermedad("Gripe",false,true,false,true,false);
		// Visualizamos sus propiedades por pantalla
		System.out.println(gripe.toStringLargo());
		
		System.out.println("===========================================================================================================");
		System.out.println("# Creamos dos objetos de tipo Medicamento para poder recetarlos mas adelante y visualizamos sus propiedades");
		System.out.println("===========================================================================================================");
				
		// Creamos dos objetos de tipo Receta para poder recetarlos 
		Medicamento aspirina = new Medicamento("712786", "Aspirina 500 mg comprimidos", null, "Bayer Hispania, S.L.", false, false, Presentacion.COMPRIMIDO, 20);
		aspirina.anyadirPrincipioActivo(new PrincipioActivo("Ácido acetilsalicílico","500 mg"));
		System.out.println(aspirina.toStringLargo());
		
		Medicamento fluimucil = new Medicamento("660287.4", "Fluimucil Complex", null, "Zambon", false, false, Presentacion.COMPRIMIDO_EFERVESCENTE, 16);
		fluimucil.anyadirPrincipioActivo(new PrincipioActivo("Paracetamol","500 mg"));
		fluimucil.anyadirPrincipioActivo(new PrincipioActivo("Acetilcisteína","200 mg"));
		System.out.println(fluimucil.toStringLargo());

		System.out.println("==========================================================================");
		System.out.println("# Creamos un objeto de tipo Medico y visualizamos sus propiedades");
		System.out.println("==========================================================================");
		
		// Creamos el objeto de tipo Medico
		Medico medicoDePrueba = new Medico();
		
		// Asignamos los datos a las propiedades
		medicoDePrueba.setCodmedico("11111");
		medicoDePrueba.setEspecialidad(Especialidad.CARDIOLOGIA);
		medicoDePrueba.setDni("22222222Z");
		medicoDePrueba.setApellido1("OLEAGA");
		medicoDePrueba.setApellido2("GOMEZ");
		medicoDePrueba.setNombre("LEIRE");
		medicoDePrueba.setSexo(Sexo.MUJER);
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		medicoDePrueba.setFechaNacimiento(sdf.parse("11-08-1970 00:00", new ParsePosition(0)));
		
		// Visualizamos sus propiedades por pantalla
		System.out.println(medicoDePrueba);
		
		// Creamos un objeto de tipo Paciente
		System.out.println("==========================================================================");
		System.out.println("# Creamos un objeto de tipo Paciente y visualizamos todas sus propiedades");
		System.out.println("==========================================================================");
		Paciente pacienteDePrueba = new Paciente();
		// Asignamos los datos a las propiedades
		pacienteDePrueba.setNumeroSeguridadSocial("48111111");
		pacienteDePrueba.setDni("44444444Q");
		pacienteDePrueba.setApellido1("ALONSO");
		pacienteDePrueba.setApellido2("GARAY");
		pacienteDePrueba.setNombre("MARTA");
		pacienteDePrueba.setSexo(Sexo.MUJER);
		pacienteDePrueba.setFechaNacimiento(sdf.parse("19-01-1991 00:00", new ParsePosition(0)));
		
		// Visualizamos sus propiedades por pantalla
		System.out.println(pacienteDePrueba.toStringCompleto());
		
		System.out.println("======================================================================================================");
		System.out.println("# Creamos un objeto de tipo Cita para el día 19-05-2014 con el médico y paciente y la visualizamos");
		System.out.println("======================================================================================================");
		// Creamos un objeto de tipo Cita
		Cita citaDePrueba = new Cita();
		citaDePrueba.setFecha(sdf.parse("19-05-2014 10:30", new ParsePosition(0)));
		citaDePrueba.setMedico(medicoDePrueba);
		citaDePrueba.setPaciente(pacienteDePrueba);

		System.out.println(citaDePrueba);
		
		System.out.println("======================================================================================================");
		System.out.println("El día 19-05-2014 el paciente acude a la cita generándose un objeto de tipo Consulta y visualizamos sus propiedades");
		System.out.println("======================================================================================================");
		
		// Creamos un objeto de tipo Consulta
		Consulta consultaDePrueba = new Consulta();
		consultaDePrueba.setCita(citaDePrueba);
		consultaDePrueba.setSintomas("Dolor de cabeza y fiebre");
		consultaDePrueba.setDiagnostico("El paciente tiene gripe");

		System.out.println(consultaDePrueba);
	
		System.out.println("======================================================================================================");
		System.out.println("# El médico diagnostica la enfermedad " + gripe.getNombre() + " al paciente");
		System.out.println("======================================================================================================");
		
		pacienteDePrueba.diagnosticarEnfermedad(gripe);
		//System.out.println(pacienteDePrueba.listaEnfermedadesToString());
				
		
		// Recetamos los medicamentos con una única llamada al módulo porque este admite un número de parámetros variable.
		System.out.println("======================================================================================================");
		System.out.println("# Creamos dos objetos de tipo Receta y recetamos con ellos los medicamentos al paciente");
		System.out.println("======================================================================================================");
		Receta receta1 = new Receta(aspirina, new Date(), 3, 1, 1, 1);
		Receta receta2 = new Receta(fluimucil, new Date(),5,1,0,1);
		pacienteDePrueba.recetarMedicamentos(receta1, receta2);

		// Visualizamos las recetas por pantalla
		//System.out.println(pacienteDePrueba.listaRecetasToString());
		
		System.out.println("======================================================================================================");
		System.out.println("# Aconsejamos los cuidados " + Cuidado.REPOSO + " y " + Cuidado.CALOR + " al paciente");
		System.out.println("======================================================================================================");
		
		pacienteDePrueba.aconsejarCuidados(Cuidado.REPOSO, Cuidado.CALOR);
		//System.out.println(pacienteDePrueba.listaCuidadosToString());
		
		System.out.println("==========================================================================");
		System.out.println("# Visualizamos todas sus propiedades del paciente despues de la consulta");
		System.out.println("==========================================================================");
				
		System.out.println(pacienteDePrueba.toStringCompleto());
		
		System.out.println("======================================================================================================");
		System.out.println("Salvamos en disco el estado actual del paciente despues de la consulta con las dos recetas");
		System.out.println("======================================================================================================");
		try {
			pacienteDePrueba.salvarPacienteEnFichero();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("");
		System.out.println("######################################################################################################");
		System.out.println("");
		
		System.out.println("======================================================================================================");
		System.out.println("# Una vez curado el paciente pide otra cita con el médico para que se lo asegure generándose un nuevo objeto de tipo Cita");
		System.out.println("======================================================================================================");
		// Creamos un objeto de tipo Cita
		Cita citaDePrueba2 = new Cita();
		citaDePrueba2.setFecha(sdf.parse("26-05-2014 10:30", new ParsePosition(0)));
		citaDePrueba2.setMedico(medicoDePrueba);
		citaDePrueba2.setPaciente(pacienteDePrueba);

		System.out.println(citaDePrueba2);
		
		System.out.println("======================================================================================================");
		System.out.println("# El paciente acude a la cita y el medico recuperara el estado del paciente salvado en el fichero de la primera consulta");
		System.out.println("======================================================================================================");
		
		Paciente pacienteDeFichero = new Paciente();
		try {
			pacienteDeFichero = pacienteDePrueba.leerPacienteDesdeFichero();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// reemplazamos el paciente leido del fichero en la cita y en el paciente de prueba
		citaDePrueba2.setPaciente(pacienteDeFichero);
		pacienteDePrueba = pacienteDeFichero;
		
		System.out.println("======================================================================================================");
		System.out.println("# Se generándose un nuevo objeto de tipo Consulta");
		System.out.println("======================================================================================================");
		
		// Creamos un objeto de tipo Consulta
		Consulta consultaDePrueba2 = new Consulta();
		consultaDePrueba2.setCita(citaDePrueba2);
		consultaDePrueba2.setSintomas("Ninguno");
		consultaDePrueba2.setDiagnostico("El paciente está curado.");

		System.out.println(consultaDePrueba2);
		
		System.out.println("======================================================================================================");
		System.out.println("# El médico diagnostica que le paciente se ha curado de la gripe");
		System.out.println("======================================================================================================");
		
		pacienteDePrueba.diagnosticarCuracion(gripe);
		
		System.out.println("======================================================================================================");
		System.out.println("# El médico quita al paciente los medicamentos recetados");
		System.out.println("======================================================================================================");
		
		for (Medicamento medicamento : pacienteDePrueba.getListaMedicamentos())
			pacienteDePrueba.quitarMedicamento(medicamento);
		
		System.out.println("======================================================================================================");
		System.out.println("# El médico quita al paciente los cuidados aconsejados");
		System.out.println("======================================================================================================");
		
		for (Cuidado cuidado : pacienteDePrueba.getListaCuidados())
			pacienteDePrueba.quitarCuidado(cuidado);
		
		System.out.println("======================================================================================================");
		System.out.println("# Visualizamos todas las propiedades del paciente ya sano despues de la segunda consulta");
		System.out.println("======================================================================================================");
				
		System.out.println(pacienteDePrueba.toStringCompleto());
		
		System.out.println("======================================================================================================");
		System.out.println("Salvamos en disco el estado actual del paciente sano despues de la segunda consulta para posteriores consultas");
		System.out.println("======================================================================================================");
		try {
			pacienteDePrueba.salvarPacienteEnFichero();
		} catch (Exception e) {
			e.printStackTrace();
		}

	

	}

}
