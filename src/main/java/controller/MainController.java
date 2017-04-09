package main.java.controller;

import main.java.model.CallCenter;
import main.java.model.Customer;
import main.java.model.Employee;

public class MainController<E> {
	private EmployeeController employeeController;
	private CustomerController customerController;
	private Dispatcher<E> dispatcher;
	private CallCenter<Employee> callCenter;

	/**
	 * @param callCenter
	 */
	public MainController(CallCenter<Employee> cc) {
		callCenter = cc;
		employeeController = new EmployeeController(callCenter);
		customerController = new CustomerController(callCenter);
		dispatcher = new Dispatcher<E>(employeeController, customerController);
	}

	public void runCallCenter() {
		int callId = 0;
		Customer tempCustomer = customerController.getNextCustomer();
		while (tempCustomer != null) {
			getDispatcher().dispatchCall(callId, tempCustomer);
			callId++;
		}
	}

	public static void main(String[] args) throws InterruptedException {
		// create Employees
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
		// Create Call Center
		CallCenter<Employee> callCenter = new CallCenter<Employee>();
		// Add employees to call center
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
		callCenter.addEmployeeToShift(s2);
		// Create a main controller
		MainController<Employee> mainController = new MainController<>(callCenter);
		// create customers
		Customer c1 = new Customer("Claude");
		Customer c2 = new Customer("John");
		// run calls
		mainController.getDispatcher().dispatchCall(1, c1);
		mainController.getDispatcher().dispatchCall(2, c2);
		mainController.getDispatcher().dispatchCall(3, c1);
		mainController.getDispatcher().dispatchCall(4, c2);
		mainController.getDispatcher().dispatchCall(5, c1);
		mainController.getDispatcher().dispatchCall(6, c2);
		mainController.getDispatcher().dispatchCall(7, c1);
		mainController.getDispatcher().dispatchCall(8, c2);
		mainController.getDispatcher().dispatchCall(9, c1);
		mainController.getDispatcher().dispatchCall(10, c2);
		mainController.getDispatcher().dispatchCall(11, c1);
		mainController.getDispatcher().dispatchCall(12, c2);
		mainController.getDispatcher().dispatchCall(13, c1);
		mainController.getDispatcher().dispatchCall(14, c2);
		mainController.getDispatcher().dispatchCall(15, c1);
		mainController.getDispatcher().dispatchCall(16, c2);
		mainController.getDispatcher().terminateDispatch();

	}

	public Dispatcher<E> getDispatcher() {
		return dispatcher;
	}
}
