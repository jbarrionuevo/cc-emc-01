package model;

import java.util.Deque;
import java.util.LinkedList;

//TODO implement singleton
public class CallCenter<E> {
	// employees can be more than 10
	private Deque<Employee> employeesInShift;

	public CallCenter() {
		// Exists only to defeat instantiation.
		employeesInShift = new LinkedList<Employee>();
	}

	public void addEmployeeToShift(Employee e) {
		employeesInShift.add(e);
	}

	public Deque<Employee> getAllEmployeesInShift() {
		return employeesInShift;
	}

}
