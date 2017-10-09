package apawapi.apirest.resources.exceptions;

public class ProviderIdNotFoundException extends Exception {

	private static final long serialVersionUID = -5920356115047434600L;
	public static final String msnError = "El id del provider no existe";

	public ProviderIdNotFoundException(String exeption) {
		super(msnError + ". " + exeption);
	}

	public ProviderIdNotFoundException() {
		this("");
	}

}
