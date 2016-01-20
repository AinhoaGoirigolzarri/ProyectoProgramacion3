package consultasMedicas.bussinesLogic.domain.utilities;
/**
 * Clase que representa a las especialidades médicas existentes y su representación en texto.
 * 
 * @author Ainhoa Goirigolzarri
 *
 */

public enum Especialidad {
	
	ALERGOLOGIA,
	ANATOMIA_PATOLOGICA,
	ANESTESIOLOGIA,
	APARATO_DIGESTIVO,
	CARDIOLOGIA,
	CIRUGIA_GENERAL,
	CIRUGIA_MAXILOFACIAL,
	CIRUGIA_PLASTICA,
	DERMATOLOGIA,
	ENDOCRINOLOGIA,
	ESTOMATOLOGIA,
	GERIATRIA,
	GINECOLOGIA,
	HEMATOLOGIA,
	INMUNOLOGIA,
	MEDICINA_FAMILIAR,
	MEDICINA_INTERNA,
	NEFROLOGIA,
	NEUMOLOGIA,
	NEUROLOGIA,
	OFTALMOLOGIA,
	OTORRINOLARINGOLOGIA,
	PEDIATRIA,
	PSIQUIATRIA,
	RADIODIAGNOSTICO,
	REHABILITACION,
	REUMATOLOGIA,
	TRAUMATOLOGIA,
	UROLOGIA;


	/**
	 * Método que muestra la cadena de texto asociada a cada elemento de la enumeracón de especialidades médicas
	 * @return Cadena de texto con la cadena de texto asociada a cada especialidad médica
	 */
	@Override
	public String toString() {
		switch(this) {
			case ANATOMIA_PATOLOGICA:
				return "Anatomía patológica";
			case ANESTESIOLOGIA:
				return "Anestesiología";
			case MEDICINA_FAMILIAR:
				return "Medicina familiar";
			case MEDICINA_INTERNA:
				return "Medicina interna";
			case NEUMOLOGIA:
				return "Neumología";
			case NEUROLOGIA:
				return "Neurología";
			case GINECOLOGIA:
				return "Ginecología";
			case OFTALMOLOGIA:
				return "Oftalmología";
			case OTORRINOLARINGOLOGIA:
				return "Otorrinolaringología";
			case PEDIATRIA:
				return "Pediatría";
			case PSIQUIATRIA:
				return "Psiquiatría";
			case TRAUMATOLOGIA:
				return "Traumatología";
			case UROLOGIA:
				return "Urología";
			case ALERGOLOGIA:
				return "Alergología";
			case APARATO_DIGESTIVO:
				return "Aparato digestivo";
			case CARDIOLOGIA:
				return "Cardiología";
			case CIRUGIA_GENERAL:
				return "Cirugía general";
			case CIRUGIA_MAXILOFACIAL:
				return "Cirugía maxilofacial";
			case CIRUGIA_PLASTICA:
				return "Cirugía plástica";
			case DERMATOLOGIA:
				return "Dermatología";
			case ENDOCRINOLOGIA:
				return "Endocrinología";
			case ESTOMATOLOGIA:
				return "Estomatología";
			case GERIATRIA:
				return "Geriatría";
			case HEMATOLOGIA:
				return "Hematología";
			case INMUNOLOGIA:
				return "Inmunología";
			case NEFROLOGIA:
				return "Nefrología";
			case RADIODIAGNOSTICO:
				return "Radiodiagnóstico";
			case REHABILITACION:
				return "Rehabilitación";
			case REUMATOLOGIA:
				return "Reumatología";
			default:
				return "";
		}
	}
	
	/**
	 * Programa main para realizar las pruebas de la clase Especialidad
	 * @param args
	 */
	public static void main(String[] args) {
		// Mostramos las especialidades médicas
		System.out.println("Especialidades médicas almacenadas:");
		System.out.println("-----------------------------------");
		for(Especialidad especialidad : Especialidad.values()){
			System.out.println(especialidad.toString());
		}		
	}
}


	
	


 