package entity;

public class Order {
	private int order_number;
	private String order_name;
	private String company_name;
	private String part_name;
	private int quantity;
	private String order_date;
	private int order_price;
	private String exp_date;
	private String end_date;
	private String note;
	
	public Order() {
		
	}
	
	public Order(int order_number, String order_name, String company_name, String part_name, int quantity, String order_date, int order_price, String exp_date, String end_date, String note) {
		
		this.order_number = order_number;
		this.order_name = order_name;
		this.company_name = company_name;
		this.part_name = part_name;
		this.quantity = quantity;
		this.order_date = order_date;
		this.order_price = order_price;
		this.exp_date = exp_date;
		this.end_date = end_date;
		this.note = note;
	}
	
	public Order(String order_name, String company_name, String part_name, int quantity, int order_price, String exp_date, String end_date, String note) {
		this.order_name = order_name;
		this.company_name = company_name;
		this.part_name = part_name;
		this.quantity = quantity;
		this.order_price = order_price;
		this.exp_date = exp_date;
		this.end_date = end_date;
		this.note = note;
	}

	public int getOrder_number() {
		return order_number;
	}

	public void setOrder_number(int order_number) {
		this.order_number = order_number;
	}

	public String getOrder_name() {
		return order_name;
	}

	public void setOrder_name(String order_name) {
		this.order_name = order_name;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getPart_name() {
		return part_name;
	}

	public void setPart_name(String part_name) {
		this.part_name = part_name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getOrder_date() {
		return order_date;
	}

	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}

	public int getOrder_price() {
		return order_price;
	}

	public void setOrder_price(int order_price) {
		this.order_price = order_price;
	}

	public String getExp_date() {
		return exp_date;
	}

	public void setExp_date(String exp_date) {
		this.exp_date = exp_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
}
