package entity;

public class Outsourcing {
	private int outsourcing_number;
	private String part_name;
	private String company_name;
	private int price;
	private String worker;
	private String exp_date;
	private String start_date;
	private String end_date;
	private int quantity;
	private String reg_date;
	
	public Outsourcing() {
		
	}

	public Outsourcing(String part_name, String company_name, int quantity, int price, String exp_date, String start_date, String end_date, String worker) {
		this.part_name = part_name;
		this.company_name = company_name;
		this.quantity = quantity;
		this.price = price;
		this.exp_date = exp_date;
		this.start_date = start_date;
		this.end_date = end_date;
		this.worker = worker;
	}
	
	public Outsourcing(int outsourcing_number,String exp_date, String start_date, String end_date) {
		this.outsourcing_number = outsourcing_number;
		this.exp_date = exp_date;
		this.start_date = start_date;
		this.end_date = end_date;
	}
	
	public int getOutsourcing_number() {
		return outsourcing_number;
	}

	public void setOutsourcing_number(int outsourcing_number) {
		this.outsourcing_number = outsourcing_number;
	}

	public String getPart_name() {
		return part_name;
	}

	public void setPart_name(String part_name) {
		this.part_name = part_name;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getWorker() {
		return worker;
	}

	public void setWorker(String worker) {
		this.worker = worker;
	}

	public String getExp_date() {
		return exp_date;
	}

	public void setExp_date(String exp_date) {
		this.exp_date = exp_date;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getReg_date() {
		return reg_date;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	
	
}
