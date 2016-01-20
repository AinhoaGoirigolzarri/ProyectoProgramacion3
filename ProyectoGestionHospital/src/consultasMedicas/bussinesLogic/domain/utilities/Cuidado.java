package consultasMedicas.bussinesLogic.domain.utilities;

/**
 * Enumeración con los tipos de cuidados posibles.
 * 
 * @author Ainhoa Goirigolzarri
 *
 */
public enum Cuidado {

	CALOR,
	CURAS,
	DIETA_BLANDA,
	EJERCICIO,
	HIELO,
	MASAJE,
	REPOSO,
	VENDAJE;

	
	/**
	 * Metodo que permite visualizar el texto asociado a cada tipo de Cuidado
	 * @return Cadena de texto con el texto asociado a cada tipo de Cuidado
	 */
	@Override
	public String toString() {
		switch(this) {
		case REPOSO:
			return "Reposo";
		case DIETA_BLANDA:
			return "Dieta blanda";
		case HIELO:
			return "Hielo";
		case CALOR:
			return "Calor";
		case CURAS:
			return "Curas";
		case VENDAJE:
			return "Vendaje";
		case MASAJE:
			return "Masaje";
		case EJERCICIO:
			return "Ejercicio";
		default:
			return "";
		}
	}
	
	/**
	 * Programa main para realizar las pruebas de la clase Cuidado
	 * @param args
	 */
	public static void main(String[] args) {
		// Mostramos los tipos de preparación posibles de los medicamentos.
		System.out.println("Cuidados almacenados:");
		System.out.println("---------------------");
		for(Cuidado cuidado : Cuidado.values()){
			System.out.println(cuidado.toString());
		}		
	}
	
	
}
