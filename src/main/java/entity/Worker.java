package entity;

public class Worker {
	private String ID;
	private String PW;
	private String name;
	private String position;
	private String phone_number;
	
	public Worker(String id, String pw, String name, String position, String phone_number) {
		this.ID = id;
		this.PW = pw;
		this.name = name;
		this.position = position;
		this.phone_number = phone_number;
	}
	public Worker() {
		
	}
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getPW() {
		return PW;
	}
	public void setPW(String pW) {
		PW = pW;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	
}
