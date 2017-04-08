package main.java.controller;

import main.java.model.CallCenter;
import main.java.model.Customer;
import main.java.model.Employee;

public class MainController<E> {
	private EmployeeController employeeController;
	private Dispatcher<E> dispatcher;
	private CallCenter<Employee> callCenter;

	public MainController(CallCenter<Employee> cc) {
		callCenter = cc;
		employeeController = new EmployeeController(callCenter);
		dispatcher = new Dispatcher<E>(employeeController);
	}

	public static void main(String[] args) throws InterruptedException {
		//create Employees
		Employee s1 = new Employee("Laurent", "supervisor");
		Employee d1 = new Employee("Rolph", "director");
		Employee o1 = new Employee("Celeste", "operator");
		Employee s2 = new Employee("Laurent", "supervisor");
		Employee o2 = new Employee("Rolph", "operator");
		Employee o3 = new Employee("Ramon", "operator");
		Employee o4 = new Employee("Cecil", "operator");
		Employee o5 = new Employee("Keith", "operator");
		Employee o6 = new Employee("Ramiro", "operator");
		Employee o7 = new Employee("Charles", "operator");
		Employee o8 = new Employee("Robert", "operator");
		Employee o9 = new Employee("Zoe", "operator");
		//Create Call Center
		CallCenter<Employee> callCenter = new CallCenter<Employee>();
		//Add employees to call center
		callCenter.addEmployeeToShift(s1);
		callCenter.addEmployeeToShift(d1);
		callCenter.addEmployeeToShift(o1);
		callCenter.addEmployeeToShift(o2);
		callCenter.addEmployeeToShift(o3);
		callCenter.addEmployeeToShift(o4);
		callCenter.addEmployeeToShift(o5);
		callCenter.addEmployeeToShift(o6);
		callCenter.addEmployeeToShift(o7);
		callCenter.addEmployeeToShift(o8);
		callCenter.addEmployeeToShift(o9);
		//Create a main controller
		MainController<Employee> mc = new MainController<>(callCenter);
		//create customers
		Customer c1 = new Customer("Claude");
		Customer c2 = new Customer("John");
		//run calls
		mc.dispatcher.dispatchCall(1, c1);
		mc.dispatcher.dispatchCall(1, c2);
		mc.dispatcher.terminateDispatch();
		
	}
	
	public Dispatcher<E> getDispatcher() {
		return dispatcher;
	}
}
