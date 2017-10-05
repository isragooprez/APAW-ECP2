package apawapi.apirest.dto;

import apawapi.apirest.entity.Article;

public class ArticleDto {

	private int id;
	private String reference;
	
	public ArticleDto() {

	}

	public ArticleDto(Article article) {
		this.id = article.getId();
		this.reference = article.getReference();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	@Override
	public String toString() {
		return "ArticleDto [id=" + id + ", reference=" + reference + "]";
	}

}
