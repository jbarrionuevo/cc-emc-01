package test;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import controller.Dispatcher;
import model.Customer;
import model.Employee;

public class DispatcherTest {
	Dispatcher d;
	int numberOfCalls;
	Customer c1;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		d = new Dispatcher();
		numberOfCalls = 100;
		c1 = new Customer("Claude");
	}

	@Test
	public void runCalls() throws InterruptedException {
		// simulates numberOfCalls consecutive calls
		//TODO change test so calls are done by different customers
		for (int customerCallId = 1; customerCallId <= numberOfCalls; customerCallId++) {
			// calls the dispatcher to route the call
			d.dispatchCall(customerCallId, c1);
		}
		d.terminateDispatch();
		// assertEquals("Different employees");
	}

}
