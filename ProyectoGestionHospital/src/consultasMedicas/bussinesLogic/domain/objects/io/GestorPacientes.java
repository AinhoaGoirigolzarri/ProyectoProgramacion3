package consultasMedicas.bussinesLogic.domain.objects.io;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import consultasMedicas.baseDatos.BaseDeDatos;
import consultasMedicas.bussinesLogic.domain.objects.Paciente;
import consultasMedicas.bussinesLogic.domain.utilities.Sexo;

/**
 * Clase que permite realizar el alamcenamiento y recuperación desde Base de Datos de los pacientes
 *
 */
public class GestorPacientes {
	
	public static List<Paciente> leerListaPacientesBaseDatos() {
		List<Paciente> lista = new ArrayList<Paciente>();
		Paciente paci;
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			try {
				
				ResultSet rs = BaseDeDatos.getStatement().executeQuery("SELECT NUMEROSS, DNI, NOMBRE, APELLIDO1, APELLIDO2, SEXO, FECHA_NAC " + 
																			"FROM PACIENTES " + 
																			"ORDER BY APELLIDO1, APELLIDO2, NOMBRE");
				while (rs.next()) {
					paci = new Paciente();
					paci.setNumeroSeguridadSocial(rs.getString("NUMEROSS"));
					paci.setDni(rs.getString("DNI"));
					paci.setNombre(rs.getString("NOMBRE"));
					paci.setApellido1(rs.getString("APELLIDO1"));
					paci.setApellido2(rs.getString("APELLIDO2"));
					//paci.setSexo((Sexo)(rs.getString("SEXO")));
					try {
						paci.setFechaNacimiento(sdf.parse(rs.getString("FECHA_NAC")));
					} catch (ParseException e) {
						//e.printStackTrace();
					}
					
					lista.add(paci);
				}
				rs.close();
			} catch (SQLException e1) {
				System.out.println("SQL Exception: " + e1.getMessage());
				e1.printStackTrace(System.out);
			} 
		
		return lista;
	}
	
	public static Paciente leerPacienteBaseDatos(String numeroSS) {

		Paciente paci = new Paciente();
	
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			try {
				
				ResultSet rs = BaseDeDatos.getStatement().executeQuery("SELECT NUMEROSS, DNI, NOMBRE, APELLIDO1, APELLIDO2, SEXO, FECHA_NAC " + 
																			"FROM PACIENTES " + 
																			"WHERE NUMEROSS = " + numeroSS);
				if (rs.next()) {
					paci.setNumeroSeguridadSocial(rs.getString("NUMEROSS"));
					paci.setDni(rs.getString("DNI"));
					paci.setNombre(rs.getString("NOMBRE"));
					paci.setApellido1(rs.getString("APELLIDO1"));
					paci.setApellido2(rs.getString("APELLIDO2"));
					System.out.println(rs.getString("APELLIDO2"));
					//paci.setSexo((Sexo)(rs.getString("SEXO")));
					try {
						paci.setFechaNacimiento(sdf.parse(rs.getString("FECHA_NAC")));
					} catch (ParseException e) {
						//e.printStackTrace();
					}
				}
				rs.close();
			} catch (SQLException e1) {
				System.out.println("SQL Exception: " + e1.getMessage());
				e1.printStackTrace(System.out);
			} 
		return paci;
	
	}
	
	
	public static Boolean grabarPacienteBaseDatos(Paciente paciente) {

		try {
			// Crea la tabla PACIENTES si no existe
			// otros tipos de datos TEXT, INTEGER, REAL, NULL, BLOB
			crearTablaPacientesBD();
			// Existe el paciente en la BD?
			ResultSet rs = BaseDeDatos.getStatement().executeQuery("SELECT * FROM PACIENTES WHERE NUMEROSS = '" + paciente.getNumeroSeguridadSocial() + "'" );
				if (rs.next()) {  // El componente ya existe: UPDATE
					BaseDeDatos.getStatement().executeUpdate( "UPDATE PACIENTES SET " + 
								"DNI = " + "'" + paciente.getDni() + "', " +
								"NOMBRE = " + "'" + paciente.getNombre() + "', " +
								"APELLIDO1 = " + "'" + paciente.getApellido1() + "', " +
								"APELLIDO2 = " + "'" + paciente.getApellido2() + "', " +
								"SEXO = " + "'" + paciente.getSexo() + "', " +
								"FECHA_NAC = " + "'" + paciente.getFechaNacimiento() + "' " +
							"WHERE NUMEROSS='" + paciente.getNumeroSeguridadSocial() + "'" );
				} else {  // El componente no existe: INSERT
					BaseDeDatos.getStatement().executeUpdate( "INSERT INTO PACIENTES (" + 
							"NUMEROSS, DNI, NOMBRE, APELLIDO1, APELLIDO2, SEXO, FECHA_NAC) VALUES (" +
							"'" + paciente.getNumeroSeguridadSocial() + "', " +
							"'" + paciente.getDni() + "', " +
							"'" + paciente.getNombre() + "', " +
							"'" + paciente.getApellido1() + "', " +
							"'" + paciente.getApellido2() + "', " +
							"'" + paciente.getSexo() + "', " +
							"'" + paciente.getFechaNacimiento() + "')" );
				}
				rs.close();
				return true;
			}
		catch (SQLException e) {
			System.out.println("SQL Exception: " + e.getMessage());
			e.printStackTrace(System.out);
			return false;
		}
		
	}
	
	public static Boolean borrarPacienteBaseDatos(String numeroSS) {

		try {
			
			BaseDeDatos.getStatement().executeUpdate("DELETE FROM PACIENTES WHERE NUMEROSS = '" + numeroSS + "'" );
			return true;
			}
		catch (SQLException e) {
			System.out.println("SQL Exception: " + e.getMessage());
			e.printStackTrace(System.out);
			return false;
		}
		
	}
	
	/** Crea una tabla de pacientes en una base de datos, si no existía ya.
	 * Debe haberse inicializado la conexión correctamente.
	 */
	public static void crearTablaPacientesBD() {
		try {
			//BaseDeDatos.getStatement().executeUpdate("DROP TABLE PACIENTES");
			BaseDeDatos.getStatement().executeUpdate("CREATE TABLE IF NOT EXISTS PACIENTES (" +
									"NUMEROSS TEXT, " + 
									"DNI TEXT, " + 
									"NOMBRE TEXT, " +
									"APELLIDO1 TEXT, " +
									"APELLIDO2 TEXT, " +
									"SEXO TEXT, " +
									"FECHA_NAC TEXT)");
		} catch (SQLException e) {
			// Si hay excepción es que la tabla ya existía (lo cual es correcto)
			// e.printStackTrace();  
		}
	}
	
	
	/**
	 * Programa principal para realizar las pruebas de almacenamiento de información y recuperación
	 * @param args
	 */
	public static void main(String[] args) {
		List<Paciente> lista = new ArrayList<Paciente>();
		Paciente pacientedeprueba1 = new Paciente();
		pacientedeprueba1.setNumeroSeguridadSocial("481111111");
		pacientedeprueba1.setDni("11111111Z");
		pacientedeprueba1.setApellido1("MADARIAGA");
		pacientedeprueba1.setApellido2("GOITIA");
		pacientedeprueba1.setNombre("UDANE");
		pacientedeprueba1.setSexo(Sexo.MUJER);
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		pacientedeprueba1.setFechaNacimiento(sdf.parse("11-08-1970", new ParsePosition(0)));
		lista.add(pacientedeprueba1);
		
		Paciente pacientedeprueba2 = new Paciente();
		pacientedeprueba2.setNumeroSeguridadSocial("482222222");
		pacientedeprueba2.setDni("22222222Z");
		pacientedeprueba2.setApellido1("ALONSO");
		pacientedeprueba2.setApellido2("URIA");
		pacientedeprueba2.setNombre("LEIRE");
		pacientedeprueba2.setSexo(Sexo.MUJER);
		pacientedeprueba2.setFechaNacimiento(sdf.parse("11-08-1970", new ParsePosition(0)));
		lista.add(pacientedeprueba2);
		
		GestorPacientes.grabarPacienteBaseDatos(pacientedeprueba1);
		GestorPacientes.grabarPacienteBaseDatos(pacientedeprueba1);

		
		List<Paciente> listaLeida = null ;
		listaLeida = GestorPacientes.leerListaPacientesBaseDatos();
		System.out.println(listaLeida);
		
	}
	
	
}
