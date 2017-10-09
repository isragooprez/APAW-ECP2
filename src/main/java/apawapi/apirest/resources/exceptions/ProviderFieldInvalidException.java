package apawapi.apirest.resources.exceptions;

public class ProviderFieldInvalidException extends Exception {

	private static final long serialVersionUID = -1231860783277551573L;
	public static final String msnError = "Nombre del articulo no encontrado";

	public ProviderFieldInvalidException(String exeption) {
		super(msnError + ". " + exeption);
	}

	public ProviderFieldInvalidException() {
		this("");
	}

}
