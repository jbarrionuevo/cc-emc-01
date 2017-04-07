package test;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import controller.Dispatcher;

public class DispatcherTest {
	Dispatcher d;
	int numberOfCalls;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		d = new Dispatcher();
		numberOfCalls = 100;
	}

	@Test
	public void runCalls() throws InterruptedException {
		// simulates numberOfCalls consecutive calls
		for (int customerCallId = 1; customerCallId <= numberOfCalls; customerCallId++) {
			// calls the dispatcher to route the call
			d.dispatch(customerCallId);
		}
		d.terminateDispatch();
		// assertEquals("Different employees");
	}

}
