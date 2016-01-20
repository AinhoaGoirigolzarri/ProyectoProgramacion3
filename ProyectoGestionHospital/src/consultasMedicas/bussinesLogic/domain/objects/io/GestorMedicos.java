package consultasMedicas.bussinesLogic.domain.objects.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import consultasMedicas.bussinesLogic.domain.objects.Medico;
import consultasMedicas.bussinesLogic.domain.utilities.Especialidad;
import consultasMedicas.bussinesLogic.domain.utilities.Sexo;

/**
 * Clase que permite realizar el alamcenamiento y recuperación desde fichero de los médicos
 *
 */
public class GestorMedicos {

	/**
	 * MŽtodo que permite obtener la lista de los médicos almacenada en el fichero
	 * @param rutaFichero Ruta en la que se encuentra el fichero
	 * @return Lista de los médicos
	 * @throws ClassNotFoundException Problemas de la creación de la clase al leerla de fichero
	 * @throws IOException Problemas  de acceso a disco
	 */
	@SuppressWarnings("unchecked")
	public static List<Medico> leerMedicos(String rutaFichero) throws ClassNotFoundException, IOException{
		List<Medico> lista = null;
		ObjectInputStream ois = null;
	
		FileInputStream fin;
		try {
			fin = new FileInputStream(rutaFichero);
			ois = new ObjectInputStream(fin);
			lista = (List<Medico>) ois.readObject();	
		} catch (FileNotFoundException e) {
			throw e;
		} catch (ClassNotFoundException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		}
		finally{
			if(ois != null)
				try {
					ois.close();
				} catch (IOException e) {
					throw e;
				}
		}
		
		return lista;
	}
	
	/**
	 * MŽtodo que permite realizar el almacenamiento de los médicos en un fichero
	 * @param grupos Lista de los médicos
	 * @param rutaFichero Ruta en la que se encuentra el fichero
	 * @throws IOException Exepciones producidasp or el acceso a disco
	 */
	public static void escribirMedicos(List<Medico> grupos, String rutaFichero) throws IOException{
		FileOutputStream fout = null;
		ObjectOutputStream oos = null;
		try {
			fout = new FileOutputStream(rutaFichero);
			oos = new ObjectOutputStream(fout);
			oos.writeObject( grupos );
			
		} catch (FileNotFoundException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		} finally {
			if(oos != null)
				oos.close();
		}
	}
	
	
	/**
	 * Programa principal para realizar las pruebas de almacenamiento de información y recuperación
	 * @param args
	 */
	public static void main(String[] args) {
		List<Medico> lista = new ArrayList<Medico>();
		Medico medicodeprueba1 = new Medico();
		medicodeprueba1.setCodmedico("11111");
		medicodeprueba1.setEspecialidad(Especialidad.CARDIOLOGIA);
		medicodeprueba1.setDni("11111111Z");
		medicodeprueba1.setApellido1("OLEAGA");
		medicodeprueba1.setApellido2("GOMEZ");
		medicodeprueba1.setNombre("LEIRE");
		medicodeprueba1.setSexo(Sexo.MUJER);
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		medicodeprueba1.setFechaNacimiento(sdf.parse("11-08-1970", new ParsePosition(0)));
		lista.add(medicodeprueba1);
		
		Medico medicodeprueba2 = new Medico();
		medicodeprueba2.setCodmedico("22222");
		medicodeprueba2.setEspecialidad(Especialidad.DERMATOLOGIA);
		medicodeprueba2.setDni("22222222Z");
		medicodeprueba2.setApellido1("URIARTE");
		medicodeprueba2.setApellido2("RAMOS");
		medicodeprueba2.setNombre("AITOR");
		medicodeprueba2.setSexo(Sexo.HOMBRE);
		medicodeprueba2.setFechaNacimiento(sdf.parse("11-08-1970", new ParsePosition(0)));
		lista.add(medicodeprueba2);
		
		try {
			GestorMedicos.escribirMedicos(lista, "./files/medicos.dat");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		List<Medico> listaLeida = null ;
		try {
			listaLeida = GestorMedicos.leerMedicos("./files/medicos.dat");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(listaLeida);
		
	}
	
	
}
