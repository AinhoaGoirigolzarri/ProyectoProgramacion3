package consultasMedicas.bussinesLogic.domain.objects.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import consultasMedicas.bussinesLogic.domain.objects.Medicamento;
import consultasMedicas.bussinesLogic.domain.objects.PrincipioActivo;
import consultasMedicas.bussinesLogic.domain.utilities.Presentacion;


/**
 * Clase que permite realizar el alamcenamiento y recuperación desde fichero de los Medicamentos
 *
 */
public class GestorMedicamentos {

	/**
	 * MŽtodo que permite obtener la lista de los medicamentos almacenada en el fichero
	 * @param rutaFichero Ruta en la que se encuentra el fichero
	 * @return Lista de los medicamentos
	 * @throws ClassNotFoundException Problemas de la creación de la clase al leerla de fichero
	 * @throws IOException Problemas  de acceso a disco
	 */
	@SuppressWarnings("unchecked")
	public static List<Medicamento> leerMedicamentos(String rutaFichero) throws ClassNotFoundException, IOException{
		List<Medicamento> lista = null;
		ObjectInputStream ois = null;
	
		FileInputStream fin;
		try {
			fin = new FileInputStream(rutaFichero);
			ois = new ObjectInputStream(fin);
			lista = (List<Medicamento>) ois.readObject();	
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
	 * MŽtodo que permite realizar el almacenamiento de las medicamentos en un fichero
	 * @param grupos Lista de las medicamentos
	 * @param rutaFichero Ruta en la que se encuentra el fichero
	 * @throws IOException Exepciones producidasp or el acceso a disco
	 */
	public static void escribirMedicamentos(List<Medicamento> grupos, String rutaFichero) throws IOException{
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
		List<Medicamento> lista = new ArrayList<Medicamento>();
		
		// Creamos dos objetos de tipo Receta para poder recetarlos 
		Medicamento aspirina = new Medicamento("712786", "ASPIRINA 500 mg COMPRIMIDOS", null, "BAYER HISPANIA, S.L.", false, false, Presentacion.COMPRIMIDO, 20);
		aspirina.anyadirPrincipioActivo(new PrincipioActivo("Ácido acetilsalicílico","500 mg"));
		
		Medicamento fluimucil = new Medicamento("660287.4", "FLUIMUCIL COMPLEX", null, "ZAMBON", false, false, Presentacion.COMPRIMIDO_EFERVESCENTE, 16);
		fluimucil.anyadirPrincipioActivo(new PrincipioActivo("Paracetamol","500 mg"));
		fluimucil.anyadirPrincipioActivo(new PrincipioActivo("Acetilcisteína","200 mg"));
		
		lista.add(aspirina);
		lista.add(fluimucil);
			
		
		try {
			GestorMedicamentos.escribirMedicamentos(lista, "./files/medicamentos.dat");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		List<Medicamento> listaLeida = null ;
		try {
			listaLeida = GestorMedicamentos.leerMedicamentos("./files/medicamentos.dat");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(listaLeida);
		
	}

}
