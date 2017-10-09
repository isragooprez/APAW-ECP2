package apawapi.apirest.dto;

import apawapi.apirest.entity.Provider;

public class ProviderDto {
	private int id;
	private String company;
	private String adress;

	public ProviderDto() {
	}

	public ProviderDto(Provider provider) {
		id = provider.getId();
		company = provider.getCompany();
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

	@Override
	public String toString() {
		return "ProviderDto [id=" + id + ", company=" + company + ", adress=" + adress + "]";
	}

}
