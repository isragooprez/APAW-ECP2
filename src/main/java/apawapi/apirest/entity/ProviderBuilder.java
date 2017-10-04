package apawapi.apirest.entity;

public class ProviderBuilder {

	private int id;
	private String company;
	private String adress;

	private Provider provider;

	private ProviderBuilder(int id, String company) {
		this.id = id;
		this.company = company;
	}

	public ProviderBuilder() {
		this(0, "");
		provider = new Provider();
	}

	public ProviderBuilder id(int id) {
		provider.setId(id);
		return this;
	}

	public ProviderBuilder company(String company) {
		provider.setCompany(company);
		return this;
	}

	public ProviderBuilder adress(String adress) {
		provider.setAdress(adress);
		return this;
	}

	public Provider Build() {
		return this.provider;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

}
