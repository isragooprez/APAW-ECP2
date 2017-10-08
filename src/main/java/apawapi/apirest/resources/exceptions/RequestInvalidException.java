package apawapi.apirest.resources.exceptions;

public class RequestInvalidException extends Exception {

	private static final long serialVersionUID = -6707412002243320103L;
	public static final String msnError = "Petición no implementada";

	public RequestInvalidException(String exption) {
		super(msnError + ". " + exption);
	}

	public RequestInvalidException() {
		this("");
	}

}
