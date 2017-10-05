package apawapi.apirest.resources.exceptions;

public class ArticleIdNotFoundExeption extends Exception {

	/**
	 * Serie Version AutoGenerado
	 */
	private static final long serialVersionUID = -5374833017394111630L;
	public  static final String DESCRIPCION = "El id del Article no existe";


	public ArticleIdNotFoundExeption(String detail) {
		super(DESCRIPCION + "." + detail);
	}

	public ArticleIdNotFoundExeption() {
		this("");
	}

}
