package controller;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

import model.CallCenter;
import model.Employee;
import model.EmployeeTypeTable;

public class EmployeeController {

	CallCenter<Employee> callCenter;
	Map<String, Deque<Employee>> shiftEmployees;

	public EmployeeController(CallCenter<Employee> cc) {
		callCenter = cc;
		shiftEmployees = cc.getAllEmployeesInShift();
	}

	public Employee getNextAvailableEmployee() {
		Employee e = null;
		boolean found = false;
		// traverse until found
		int typeEmployeeIndex = 0;
		// traverse employee map
		while (typeEmployeeIndex < shiftEmployees.size() && found == false) {
			int y = 0;
			// traverse the employee type deque
			Deque<Employee> employeesOfType = shiftEmployees.get(EmployeeTypeTable.employeeTypes[typeEmployeeIndex]);
			while (y < employeesOfType.size()) {
				e = employeesOfType.peek();
				// if available, removes head and points to last
				if (e.getStatus().equals("available")) {
					e = employeesOfType.poll();
					employeesOfType.offer(e);
					found = true;
					//TODO remove next line, the employee status changes when call starts and end
					e.setStatus("busy");
					break;
				} else {
					e = null;
					y++;
				}

			}
			typeEmployeeIndex++;
		}
		return e;
	}

}
