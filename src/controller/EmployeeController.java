package controller;

import java.util.Deque;

import model.CallCenter;
import model.Employee;

public class EmployeeController {

	CallCenter<Employee> callCenter;
	Deque<Employee> shiftEmployees = callCenter.getAllEmployeesInShift();

	public EmployeeController() {
		// TODO implement singleton
		// callCenter=CallCenter.getInstance();
	}

	//TODO Finish employee asignation
	//Should be concurrent?
	public Employee getNextAvailableEmployee(String t) {
		Deque<Employee> shiftEmployees = callCenter.getAllEmployeesInShift();
		// TODO intelligence to get by priority
		Employee e = shiftEmployees.getFirst();

		return e;
	}
	
	//TODO Finish employee asignation
	//Should be concurrent?
	private Employee getNextAvailableEmployeeByType(String type) {
		Deque<Employee> shiftEmployees = callCenter.getAllEmployeesInShift();
		Employee e = null;
		int i = 0;
		while (i < shiftEmployees.size()) {
			// retrieves and removes the head of the list
			e = shiftEmployees.poll();
			// if employee type is expected and is available
			if (e.getType().equals(type) && e.getStatus().equals("available")) {
				e.setStatus("unavailable");
				// send employee to the tail
				shiftEmployees.offer(e);
				break;
			} else {
				// not found, then send to bottom and keep searching
				shiftEmployees.offer(shiftEmployees.poll());
			}
			i++;
		}
		return e;
	}
}
