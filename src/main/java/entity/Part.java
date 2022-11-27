package entity;

public class Part {
	private String part_name;
	private int price;
	private int quantity;
	private int safety_quantity;
	
	public Part() {
		
	}
	
	public Part(String part_name, int price, int quantity, int safety_quantity) {
		this.part_name = part_name;
		this.price=price;
		this.quantity = quantity;
		this.safety_quantity = quantity;
	}

	public String getPart_name() {
		return part_name;
	}

	public void setPart_name(String part_name) {
		this.part_name = part_name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getSafety_quantity() {
		return safety_quantity;
	}

	public void setSafety_quantity(int safety_quantity) {
		this.safety_quantity = safety_quantity;
	}
	
}
