package main.java.model;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class CallCenter<E> {
	// employees can be more than 10
	private Map<String, Deque<Employee>> employeesInShift;

	public CallCenter() {
		employeesInShift = new HashMap<String, Deque<Employee>>();
		employeesInShift.put(EmployeeTypeTable.employeeTypes[0], new LinkedList<Employee>());//0 = operator
		employeesInShift.put(EmployeeTypeTable.employeeTypes[1], new LinkedList<Employee>());//1 = supervisor
		employeesInShift.put(EmployeeTypeTable.employeeTypes[2], new LinkedList<Employee>());//2 = director
	}

	public void addEmployeeToShift(Employee e) {
		e.setStatus("available");
		employeesInShift.get(e.getType()).push(e);
	}

	public Map<String, Deque<Employee>> getAllEmployeesInShift() {
		return employeesInShift;
	}

}