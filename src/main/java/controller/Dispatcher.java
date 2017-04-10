package main.java.controller;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import main.java.model.Call;
import main.java.model.Customer;
import main.java.model.Employee;

/**
 * Manages incoming calls. A thread per call is created and a max of 10 threads
 * is limited in MAX_NUMBER_SIM_CALLS, that will determine the thread pool size.
 * 
 * @author Jorge
 *
 * @param <E>
 */
public class Dispatcher<E> {
	private static final int MAX_NUMBER_SIM_CALLS = 10;
	private ExecutorService executor;
	private EmployeeController employeeController;
	private CustomerController customerController;

	public Dispatcher(EmployeeController ec, CustomerController cc) {
		employeeController = ec;
		customerController = cc;
		executor = Executors.newFixedThreadPool(MAX_NUMBER_SIM_CALLS);
	}

	/**
	 * Runs a call in a new thread if there is an employee available. If there
	 * is an employee available then starts a call. Otherwise, if no employee is
	 * available, returns the customer to its container and call will be routed
	 * again until there is an employee who can attend the call.
	 * 
	 * @param customerCallId
	 * @param customer
	 */
	public void dispatchCall(long customerCallId, Customer customer) {
		//
		Employee nextAvailableEmployee = employeeController.getNextAvailableEmployee();
		if (nextAvailableEmployee != null) {
			Runnable call = new Call(customerCallId, customer, nextAvailableEmployee);
			executor.execute(call);
		}

		else {
			System.out.println("No employee available, please wait. -callID= " + customerCallId + " -customer = "
					+ customer.getName() + " number_employees_available= "
					+ employeeController.getEmployeesByStatus("available").size());
			customerController.addNextCustomer(customer);
		}
		System.out.println("***End dispatchCall -Customer= " + customer.getName() + " Number_employees_available= "
				+ employeeController.getEmployeesByStatus("available").size());
	}

	public void terminateDispatch() throws InterruptedException {
		executor.shutdown();
		executor.awaitTermination(11, TimeUnit.SECONDS);
		System.out.println("Finished all threads");
	}

}
