package apawapi.apirest.resources.exceptions;

public class ArticleIdNoFoundException extends Exception {

	private static final long serialVersionUID = 4739895186030963109L;
	public static final String msnError = "El id del Article no existe";

	public ArticleIdNoFoundException(String exeption) {
		super(msnError + ". " + exeption);
	}

	public ArticleIdNoFoundException() {
		this("");
	}
}
