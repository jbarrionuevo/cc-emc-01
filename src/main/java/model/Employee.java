package main.java.model;

public class Employee extends Person {
	private String status;
	private String type;

	public Employee(String n, String t) {
		name = n;
		type = t;
		status = "available";
	}

	// an employee can be available or busy
	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public String getType() {
		return type;
	}
}
