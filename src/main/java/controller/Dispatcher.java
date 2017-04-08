package main.java.controller;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import main.java.model.Call;
import main.java.model.Customer;
import main.java.model.Employee;

public class Dispatcher<E> {
	private static final int MAX_NUMBER_SIM_CALLS = 10;
	private ExecutorService executor;
	private EmployeeController employeeController;
	// private CallCenter callCenter;

	public Dispatcher(EmployeeController ec) {
		employeeController = ec;
		executor = Executors.newFixedThreadPool(MAX_NUMBER_SIM_CALLS);

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
