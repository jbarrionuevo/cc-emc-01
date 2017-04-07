package model;

import java.util.Random;

public class Call implements Runnable {
	private long id;
	private Employee employee;

	public Call(long l) {
		id = l;
	}

	public void assignEmployee(Employee e) {
		synchronized (this) {
			employee = e;
		}

	}

	@Override
	public void run() {
		int threadDuration = getRandomDuration(5, 10) * 1000;
		System.out.println("Call executed #" + id + " ---Duration= " + threadDuration);
		try {
			Thread.sleep(threadDuration);
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
