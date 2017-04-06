package model;

import java.util.Deque;
import java.util.LinkedList;

public class CallCenter<E> {
	//employees can be more than 10
	private Deque<Employee> employeesInShift = new LinkedList<Employee>();
	
	public void addEmployeeToShift(Employee e) {
		employeesInShift.add(e);
	}
	
	public Deque<Employee> getAllEmployeesInShift(){
		return employeesInShift;
	} 
	
}
