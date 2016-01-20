package consultasMedicas.bussinesLogic.domain.facade;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import consultasMedicas.bussinesLogic.domain.objects.Medico;
import consultasMedicas.bussinesLogic.domain.objects.Paciente;
import consultasMedicas.bussinesLogic.domain.objects.Enfermedad;
import consultasMedicas.bussinesLogic.domain.objects.Medicamento;
import consultasMedicas.bussinesLogic.domain.objects.io.GestorMedicos;
import consultasMedicas.bussinesLogic.domain.objects.io.GestorPacientes;
import consultasMedicas.bussinesLogic.domain.objects.io.GestorEnfermedades;
import consultasMedicas.bussinesLogic.domain.objects.io.GestorMedicamentos;

public class ConsultasMedicasFacade {
	
	
	/**
	 * Atributo que almacena los medicos
	 */
	private static List<Medico> listaMedicos = new ArrayList<Medico>();

	/**
	 * Atributo que almacena los pacientes
	 */
	private static List<Paciente> listaPacientes = new ArrayList<Paciente>();

	/**
	 * Atributo que almacena las enfermedades
	 */
	private static List<Enfermedad> listaEnfermedades = new ArrayList<Enfermedad>();
	
	/**
	 * Atributo que almacena los medicamentos
	 */
	private static List<Medicamento> listaMedicamentos = new ArrayList<Medicamento>();
	
	public static boolean inicializar(){
		// Llamamos a la lectura desde los ficheros de los medicos, pacientes, etc
		try {
			listaMedicos = GestorMedicos.leerMedicos("./files/medicos.dat");
			//listaPacientes = GestorPacientes.leerPacientes("./files/pacientes.dat");
			listaPacientes = GestorPacientes.leerListaPacientesBaseDatos();
			listaEnfermedades = GestorEnfermedades.leerEnfermedades("./files/enfermedades.dat");
			listaMedicamentos = GestorMedicamentos.leerMedicamentos("./files/medicamentos.dat");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public static boolean finalizar(){
		
		// Guardamos los medicos, pacientes, etc
		try {
			GestorMedicos.escribirMedicos(listaMedicos, "./files/medicos.dat");
			//GestorPacientes.escribirPacientes(listaPacientes, "./files/pacientes.dat");
			GestorEnfermedades.escribirEnfermedades(listaEnfermedades, "./files/enfermedades.dat");
			GestorMedicamentos.escribirMedicamentos(listaMedicamentos, "./files/medicamentos.dat");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}
	

	/**
	 * MŽtodo que permite obtener la lista de medicos
	 * @return Lista de medicos
	 */
	public static List<Medico> getListaMedicos(){
		return listaMedicos;
	}
	
	/**
	 * MŽtodo que permite cambiar la lista de medicos
	 * @return Lista de medicos
	 */
	public static void setListaMedicos(List<Medico> listMed){
		listaMedicos=listMed;
	}
	
	/**
	 * MŽtodo que permite obtener la lista de pacientes
	 * @return Lista de pacientes
	 */
	public static List<Paciente> getListaPacientes(){
		return listaPacientes;
	}
	
	/**
	 * MŽtodo que permite cambiar la lista de pacientes
	 * @return Lista de pacientes
	 */
	public static void setListaPacientes(List<Paciente> listPac){
		listaPacientes=listPac;
	}
	
	/**
	 * MŽtodo que permite obtener la lista de pacientes
	 * @return Lista de pacientes
	 */
	public static List<Enfermedad> getListaEnfermedades(){
		return listaEnfermedades;
	}
	
	/**
	 * MŽtodo que permite cambiar la lista de pacientes
	 * @return Lista de pacientes
	 */
	public static void setListaEnfermedades(List<Enfermedad> listEnfer){
		listaEnfermedades=listEnfer;
	}
	
	/**
	 * MŽtodo que permite obtener la lista de Medicamentos
	 * @return Lista de Medicamentos
	 */
	public static List<Medicamento> getListaMedicamentos(){
		return listaMedicamentos;
	}
	
	/**
	 * MŽtodo que permite cambiar la lista de Medicamentos
	 * @return Lista de Medicamentos
	 */
	public static void setListaMedicamentos(List<Medicamento> listMedicamen){
		listaMedicamentos=listMedicamen;
	}
}
