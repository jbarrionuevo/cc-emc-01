package model;

public class Call implements Runnable {
	private int id;
	private Employee employee;
	
	public Call() {
		// TODO Auto-generated constructor stub
	}
	
	public void assignEmployee(Employee e){
		synchronized(this){
			employee = e;
		}
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub

	}
	public Employee getEmployee() {
		return employee;
	}
}
