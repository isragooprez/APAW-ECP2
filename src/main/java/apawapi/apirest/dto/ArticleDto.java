package apawapi.apirest.dto;

public class ArticleDto {

	private int id;
	private String reference;
	private long stock;
	private boolean discotinued;
	

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

	public long getStock() {
		return stock;
	}

	public void setStock(long stock) {
		this.stock = stock;
	}

	public boolean isDiscotinued() {
		return discotinued;
	}

	public void setDiscotinued(boolean discotinued) {
		this.discotinued = discotinued;
	}

	@Override
	public String toString() {
		return "ArticleDto [id=" + id + ", reference=" + reference + ", stock=" + stock + ", discotinued=" + discotinued
				+ "]";
	}
	
	

}
