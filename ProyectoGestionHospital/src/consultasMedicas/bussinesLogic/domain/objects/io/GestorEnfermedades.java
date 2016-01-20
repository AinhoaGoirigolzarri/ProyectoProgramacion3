package consultasMedicas.bussinesLogic.domain.objects.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import consultasMedicas.bussinesLogic.domain.objects.Enfermedad;


/**
 * Clase que permite realizar el alamcenamiento y recuperación desde fichero de las enfermedades
 *
 */
public class GestorEnfermedades {

	/**
	 * MŽtodo que permite obtener la lista de los enfermedades almacenada en el fichero
	 * @param rutaFichero Ruta en la que se encuentra el fichero
	 * @return Lista de los enfermedades
	 * @throws ClassNotFoundException Problemas de la creación de la clase al leerla de fichero
	 * @throws IOException Problemas  de acceso a disco
	 */
	@SuppressWarnings("unchecked")
	public static List<Enfermedad> leerEnfermedades(String rutaFichero) throws ClassNotFoundException, IOException{
		List<Enfermedad> lista = null;
		ObjectInputStream ois = null;
	
		FileInputStream fin;
		try {
			fin = new FileInputStream(rutaFichero);
			ois = new ObjectInputStream(fin);
			lista = (List<Enfermedad>) ois.readObject();	
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
	 * MŽtodo que permite realizar el almacenamiento de las enfermedades en un fichero
	 * @param grupos Lista de las enfermedades
	 * @param rutaFichero Ruta en la que se encuentra el fichero
	 * @throws IOException Exepciones producidasp or el acceso a disco
	 */
	public static void escribirEnfermedades(List<Enfermedad> grupos, String rutaFichero) throws IOException{
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
		List<Enfermedad> lista = new ArrayList<Enfermedad>();
		Enfermedad gripe = new Enfermedad("GRIPE",false,true,false,true,false);
		lista.add(gripe);
		
		Enfermedad diabetes = new Enfermedad("DIABETES",true,false,false,false,false);
		lista.add(diabetes);
		
		try {
			GestorEnfermedades.escribirEnfermedades(lista, "./files/enfermedades.dat");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		List<Enfermedad> listaLeida = null ;
		try {
			listaLeida = GestorEnfermedades.leerEnfermedades("./files/enfermedades.dat");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(listaLeida);
		
	}

}
