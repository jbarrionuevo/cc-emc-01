package controller;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import model.Call;

public class Dispatcher<E> {
	private static final int MAX_NUMBER_SIM_CALLS = 10;
	private ExecutorService executor;
	EmployeeController employeeController;
	
	public Dispatcher() {
		executor = Executors.newFixedThreadPool(MAX_NUMBER_SIM_CALLS);
		
		//TODO Fix this to be able to validate employee avail
		//employeeController = new EmployeeController();
	}

	// a new customer calls
	public void dispatch(long customerCallId) {
		Runnable call = new Call(customerCallId);
		executor.execute(call);
	}

	public void terminateDispatch() throws InterruptedException {
		executor.shutdown();
		executor.awaitTermination(11, TimeUnit.SECONDS);
		System.out.println("Finished all threads");
	}

}
