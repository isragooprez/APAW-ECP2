package apawapi.apirest.entity;

public class Article {

	private int id;
	private String reference;
	private long stock;
	private boolean discontinued;
	private Provider provider;

	public Article(String reference, Provider provider) {
		this.reference = reference;
		this.provider = provider;
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

	public long getStock() {
		return stock;
	}

	public void setStock(long stock) {
		this.stock = stock;
	}

	public boolean isDiscontinued() {
		return discontinued;
	}

	public void setDiscontinued(boolean discontinued) {
		this.discontinued = discontinued;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	@Override
	public String toString() {
		return String.format("Article [id=%s, reference=%s, stock=%s, discontinued=%s, provider=%s]", id, reference,
				stock, discontinued, provider);
	}

	

}
