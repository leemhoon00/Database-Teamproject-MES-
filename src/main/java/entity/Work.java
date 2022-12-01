package entity;

public class Work {
	private int work_number;
	private String part_name;
	private String facility_name;
	private int quantity;
	private String start_time;
	private String end_time;
	private String faulty;
	private String worker;
	
	public Work() {
		
	}
	
	public Work(String part_name, String facility_name, int quantity, String start_time, String end_time, String faulty, String worker) {
		this.part_name = part_name;
		this.facility_name = facility_name;
		this.quantity = quantity;
		this.start_time = start_time;
		this.faulty = faulty;
		this.worker = worker;
		this.end_time = end_time;
	}
	
	public Work(int work_number, String start_time, String end_time, String faulty) {
		this.work_number = work_number;
		this.start_time = start_time;
		this.end_time = end_time;
		this.faulty = faulty;
	}

	public int getWork_number() {
		return work_number;
	}
	public void setWork_number(int work_number) {
		this.work_number = work_number;
	}
	public String getPart_name() {
		return part_name;
	}

	public void setPart_name(String part_name) {
		this.part_name = part_name;
	}

	public String getFacility_name() {
		return facility_name;
	}

	public void setFacility_name(String facility_name) {
		this.facility_name = facility_name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	public String getFaulty() {
		return faulty;
	}

	public void setFaulty(String faulty) {
		this.faulty = faulty;
	}
	
	public String getWorker() {
		return worker;
	}
	
	public void setWorker(String worker) {
		this.worker = worker;
	}
	
}
