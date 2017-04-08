package main.java.controller;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import main.java.model.Call;
import main.java.model.CallCenter;
import main.java.model.Customer;
import main.java.model.Employee;

public class Dispatcher<E> {
	private static final int MAX_NUMBER_SIM_CALLS = 10;
	private ExecutorService executor;
	EmployeeController employeeController;

	public Dispatcher() {
		executor = Executors.newFixedThreadPool(MAX_NUMBER_SIM_CALLS);
		// TODO fix this new CallCenter<Employee>() and remove extra employees

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

		CallCenter<Employee> callCenter = new CallCenter<Employee>();

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

		employeeController = new EmployeeController(callCenter);
		// TODO Fix this to be able to validate employee avail
	}

	// a new customer calls
	public void dispatchCall(long customerCallId, Customer customer) {
		// if there is an employee available then starts a call
		Employee nextAvailableEmployee = employeeController.getNextAvailableEmployee();
		if (nextAvailableEmployee != null) {
			Runnable call = new Call(customerCallId, customer, nextAvailableEmployee);
			executor.execute(call);
		}
	}

	public void terminateDispatch() throws InterruptedException {
		executor.shutdown();
		executor.awaitTermination(11, TimeUnit.SECONDS);
		System.out.println("Finished all threads");
	}

}
