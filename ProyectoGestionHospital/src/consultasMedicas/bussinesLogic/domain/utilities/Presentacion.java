package consultasMedicas.bussinesLogic.domain.utilities;
/**
 * 
 */

/**
 * Enumeraci�n con los tipos de preparaci�n posibles de los medicamentos.
 * 
 * @author Ainhoa Goirigolzarri
 *
 */
public enum Presentacion {

	SOBRE,
	COMPRIMIDO,
	COMPRIMIDO_EFERVESCENTE,
	INYECCION,
	JARABE,
	POMADA,
	AMPOLLA,
	CAPSULA;
	
	/**
	 * Metodo que permite visualizar el texto asociado a cada tipo de preparaci�n
	 * @return Cadena de texto con el texto asociado a cada tipo de preparaci�n
	 */
	@Override
	public String toString() {
		switch(this) {
		case SOBRE:
			return "Sobres";
		case COMPRIMIDO:
			return "Comprimidos";
		case COMPRIMIDO_EFERVESCENTE:
			return "Comprimidos efervescentes";
		case INYECCION:
			return "Inyecciones";
		case JARABE:
			return "Jarabe";
		case POMADA:
			return "Pomada";
		case AMPOLLA:
			return "Ampollas";
		case CAPSULA:
			return "C�psulas";
		default:
			return "";
		}
	}
	
	/**
	 * Programa main para realizar las pruebas de la clase Preparacion
	 * @param args
	 */
	public static void main(String[] args) {
		// Mostramos los tipos de preparaci�n posibles de los medicamentos.
		System.out.println("Presentaciones de los medicamentos almacenadas:");
		System.out.println("----------------------------------------------");
		for(Presentacion presentacion : Presentacion.values()){
			System.out.println(presentacion.toString());
		}		
	}
}
