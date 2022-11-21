package entity;

public class Company {
	private String company_name;
	private Boolean client_company;
	private Boolean outsourcing_company;
	
	public Company() {
		
	}
	public Company(String company_name, Boolean client_company, Boolean outsourcing_company) {
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
	public Boolean getClient_company() {
		return client_company;
	}
	public void setClient_company(Boolean client_company) {
		this.client_company = client_company;
	}
	public Boolean getOutsourcing_company() {
		return outsourcing_company;
	}
	public void setOutsourcing_company(Boolean outsourcing_company) {
		this.outsourcing_company = outsourcing_company;
	}
	
	
}
