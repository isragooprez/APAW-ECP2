package apawapi.apirest.dto;

public class ProviderDto {
	private int id;
	private String company;
	private String adress;

	public ProviderDto(int id, String company, String adress) {
		super();
		this.id = id;
		this.company = company;
		this.adress = adress;
	}

	public ProviderDto(int id, String company) {
		super();
		this.id = id;
		this.company = company;
	}

	public ProviderDto() {
		this(0, "");
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
