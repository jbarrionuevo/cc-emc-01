package test.java;

import org.junit.Before;
import org.junit.Test;

import main.java.controller.Dispatcher;
import main.java.controller.EmployeeController;
import main.java.model.CallCenter;
import main.java.model.Customer;
import main.java.model.Employee;

public class DispatcherTest<E> {
	Dispatcher<E> d;
	int numberOfCalls;
	Customer c1;
	Employee e1;
	CallCenter<Employee> callCenter;

	@Before
	public void setUp() throws Exception {
		numberOfCalls = 100;
		c1 = new Customer("Claude");
		e1 = new Employee("Ramon", "operator");
		callCenter = new CallCenter<Employee>();
		callCenter.addEmployeeToShift(e1);
		d = new Dispatcher<E>(new EmployeeController(callCenter));
	}

	@Test
	public void runCalls() throws InterruptedException {
		// simulates numberOfCalls consecutive calls
		for (int customerCallId = 1; customerCallId <= numberOfCalls; customerCallId++) {
			// calls the dispatcher to route the call
			d.dispatchCall(customerCallId, c1);
		}
		d.terminateDispatch();
	}

}