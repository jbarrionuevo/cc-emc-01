package main.java.controller;

import java.util.Collection;
import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.jsoup.select.Collector;

import main.java.model.CallCenter;
import main.java.model.Employee;
import main.java.model.EmployeeTypeTable;

/**
 * This class will provide the functionality to manipulate employees in the
 * model.
 * 
 * @author Jorge
 *
 */
public class EmployeeController {

	CallCenter<Employee> callCenter;
	Map<String, Deque<Employee>> shiftEmployees;

	public EmployeeController(CallCenter<Employee> cc) {
		callCenter = cc;
		shiftEmployees = cc.getAllEmployeesInShift();
	}

	/**
	 * @return the next available employee whose status is available. The first
	 *         iteraton will look for the employee list that contain the
	 *         employees by type (operator, supervisor and director
	 *         respectively). The second iteration will looked into a linked
	 *         list of a type of employee and retrieve the next employee
	 *         available and will reassign it to the end of the list)
	 */
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
				// e = employeesOfType.peek();
				e = employeesOfType.poll();
				employeesOfType.offer(e);
				// if available, removes head and points to last
				if (e.getStatus().equals("available")) {
					found = true;
					// TODO remove next line, the employee status changes when
					// call starts and end
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

	public List<Employee> getEmployeesByStatus(String status) {
		List<Employee> r = null;

		r = shiftEmployees.values().stream().flatMap(Collection::stream).filter(x -> status.equals(x.getStatus()))
				.collect(Collectors.toList());

		return r;
	}

}
