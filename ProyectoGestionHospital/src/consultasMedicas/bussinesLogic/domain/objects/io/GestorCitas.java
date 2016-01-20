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
import consultasMedicas.bussinesLogic.domain.objects.containers.Cita;

public class GestorCitas {

	
	public static Boolean grabarCitaBaseDatos(Cita cita) {

		try {
			// Crea la tabla CITAS si no existe
			// otros tipos de datos TEXT, INTEGER, REAL, NULL, BLOB
			crearTablaCitasBD();
			// Existe la cita en la BD?
			ResultSet rs = BaseDeDatos.getStatement().executeQuery("SELECT * FROM CITAS " + 
																		"WHERE CODMEDICO = '" + cita.getMedico().getcodmedico() + "'" +
																		" AND DIA = '" + cita.getFecha() + "'" +
																		" AND HORA = '" + cita.getFecha() + "'");
				if (rs.next()) {  // El componente ya existe: UPDATE
					BaseDeDatos.getStatement().executeUpdate( "UPDATE CITAS SET " + 
								" NUMEROSS = " + "'" + cita.getPaciente().getNumeroSeguridadSocial() + "'" +
								" WHERE CODMEDICO = '" + cita.getMedico().getcodmedico() + "'" +
								" AND DIA = '" + cita.getFecha() + "'" +
								" AND HORA = '" + cita.getFecha() + "'");
				} else {  // El componente no existe: INSERT
					BaseDeDatos.getStatement().executeUpdate( "INSERT INTO CITAS (" + 
							"CODMEDICO, DIA, HORA, NUMEROSS) VALUES (" +
							"'" + cita.getMedico().getcodmedico() + "', " +
							"'" + cita.getFecha() + "', " +
							"'" + cita.getFecha() + "', " +
							"'" + cita.getPaciente().getNumeroSeguridadSocial() + "')" );
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
	
	
	/** Crea una tabla de pacientes en una base de datos, si no existía ya.
	 * Debe haberse inicializado la conexión correctamente.
	 */
	public static void crearTablaCitasBD() {
		try {
			//statement.executeUpdate("DROP TABLE CITAS");
			BaseDeDatos.getStatement().executeUpdate("CREATE TABLE IF NOT EXISTS CITAS (" +
									"CODMEDICO TEXT, " + 
									"DIA TEXT, " +
									"HORA TEXT, " +
									"NUMEROSS TEXT)");
		} catch (SQLException e) {
			// Si hay excepción es que la tabla ya existía (lo cual es correcto)
			// e.printStackTrace();  
		}
	}

}


