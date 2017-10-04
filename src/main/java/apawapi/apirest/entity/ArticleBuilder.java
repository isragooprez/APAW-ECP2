package apawapi.apirest.entity;

public class ArticleBuilder {

	private Article article;

	private int id;

	public ArticleBuilder(int id) {
		this.id = id;
		article = new Article(id);
	}

	public ArticleBuilder() {
		this(0);
	}

	public ArticleBuilder id(int id) {
		article.setId(id);
		return this;
	}

	public ArticleBuilder reference(String reference) {
		article.setReference(reference);
		return this;
	}

	public ArticleBuilder stock(long stock) {
		article.setStock(stock);
		return this;
	}

	public ArticleBuilder discontinued(boolean discontinued) {
		article.setDiscontinued(discontinued);
		return this;
	}

	public ArticleBuilder provider(Provider provider) {
		article.setProvider(provider);
		return this;
	}

	public Article Build() {
		return this.article;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
