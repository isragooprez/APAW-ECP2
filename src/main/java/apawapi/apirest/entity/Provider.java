package apawapi.apirest.entity;

public class Provider {

	private int id;
	private String company;
	private String adress;

	private Provider(int id, String company) {
		this.id = id;
		this.company = company;
	}

	public Provider() {
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
		return "Provider [id=" + id + ", company=" + company + ", adress=" + adress + "]";
	}

}
