package main.java.model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;

/**
 * Represent a call of random duration between 5 and 10 seconds. A call starts
 * with run(), is simulated with a thread sleep and when the call finishes, the
 * employee status is set back to "available" to be able to accept further
 * calls.
 * 
 * @author Jorge
 *
 */
public class Call implements Runnable {
	private long id;
	private Employee employee;
	private Customer customer;

	public Call(long l, Customer c, Employee e) {
		id = l;
		employee = e;
		customer = c;
	}

	@Override
	public void run() {
		int threadDuration = getRandomDuration(5, 11) * 1000;
		System.out.println("Call started #" + id + " -Duration= " + threadDuration + " -StartTime= "
				+ LocalDateTime.now() + " -Customer= " + customer.getName() + " -Employee= " + employee.getName());
		try {
			Thread.sleep(threadDuration);
			System.out.println("Call ended #" + id + " -EndTime= " + LocalDateTime.now());
			employee.setStatus("available");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Employee getEmployee() {
		return employee;
	}

	private int getRandomDuration(int min, int max) {
		Random r = new Random();
		return r.nextInt(max - min) + min;
	}
}
