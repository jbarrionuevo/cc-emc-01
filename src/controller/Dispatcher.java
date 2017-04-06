package controller;

import java.util.ArrayList;

public class Dispatcher<E> implements Runnable {
	private ArrayList<E> employees = new ArrayList<E>();

	public Dispatcher() {
		/*
		 * Employee e1 = new Employee("Juan"); Employee e2 = new
		 * Employee("Ramon"); Employee e3 = new Employee("Luis"); for (E e :
		 * employees) { employees.add(e); }
		 */
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	public void dispatch() {

		for (E e : employees) {
			// queue.add(e);
		}

	}

	/*
	 * public static void main(String[] args) { final BlockingQueue<> queue =
	 * new ArrayBlockingQueue<E>(1000); Dispatcher d = new Dispatcher();
	 * d.dispatch(); ExecutorService threadPool =
	 * Executors.newFixedThreadPool(10);
	 * 
	 * threadPool.execute(d);
	 * 
	 * 
	 * }
	 */
}
