package apawapi.apirest.resources.exceptions;

public class ArticleInvalidException extends Exception {
	private static final long serialVersionUID = -5201931897901985314L;

	public static final String msnError = "El valor del voto debe estar entre 0 y 10";

	public ArticleInvalidException(String exeption) {
		super(msnError + "." + exeption);
	}

	public ArticleInvalidException() {
		this("");
	}
}
