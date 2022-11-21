package entity;

public class Facility {
	private String facility_name;
	private String status;
	private int minute_cost;
	
	public Facility() {
		
	}
	public Facility(String facility_name, String status, int minute_cost) {
		this.facility_name = facility_name;
		this.status = status;
		this.minute_cost = minute_cost;
	}
	public String getFacility_name() {
		return facility_name;
	}
	public void setFacility_name(String facility_name) {
		this.facility_name = facility_name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getMinute_cost() {
		return minute_cost;
	}
	public void setMinute_cost(int minute_cost) {
		this.minute_cost = minute_cost;
	}
	
	
}
