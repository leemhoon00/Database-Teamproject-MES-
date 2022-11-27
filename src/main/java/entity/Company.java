package entity;

public class Company {
	private String company_name;
	private String client_company;
	private String outsourcing_company;
	
	public Company() {
		
	}
	public Company(String company_name, String client_company, String outsourcing_company) {
		this.company_name = company_name;
		this.client_company = client_company;
		this.outsourcing_company = outsourcing_company;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getClient_company() {
		return client_company;
	}
	public void setClient_company(String client_company) {
		this.client_company = client_company;
	}
	public String getOutsourcing_company() {
		return outsourcing_company;
	}
	public void setOutsourcing_company(String outsourcing_company) {
		this.outsourcing_company = outsourcing_company;
	}
	
	
}
