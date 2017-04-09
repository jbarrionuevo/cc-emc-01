package test.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import main.java.controller.EmployeeController;
import main.java.model.CallCenter;
import main.java.model.Employee;

public class EmployeeTest {
	Employee o1, o2, o3, s1, s2, d1;
	CallCenter<Employee> callCenter;
	EmployeeController ec;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		o1 = new Employee("Celeste", "operator");
		o2 = new Employee("Octavio", "operator");
		o2.setStatus("busy");
		o3 = new Employee("Raul", "operator");
		o3.setStatus("busy");
		s1 = new Employee("Claudia", "supervisor");
		s2 = new Employee("Carlos", "supervisor");
		s2.setStatus("busy");
		d1 = new Employee("Matias", "director");
		d1.setStatus("busy");
		callCenter = new CallCenter<Employee>();
		callCenter.addEmployeeToShift(o1);
		callCenter.addEmployeeToShift(o2);
		callCenter.addEmployeeToShift(o3);
		callCenter.addEmployeeToShift(s1);
		callCenter.addEmployeeToShift(s2);
		callCenter.addEmployeeToShift(d1);
		ec = new EmployeeController(callCenter);
	}

	@Test
	public void isSameEmployee() {
		assertEquals("Different employees", o1, o1);
	}

	@Test
	public void isNotSameEmployee() {
		assertNotEquals("Same employees", o1, o2);
	}

	@Test
	public void sameOperatorsNumber() {
		assertEquals("Not the right number of operators", callCenter.getAllEmployeesInShift().get("operator").size(),
				3);
	}

	@Test
	public void sameSupervisorsNumber() {
		assertEquals("Not the right number of supervisors",
				callCenter.getAllEmployeesInShift().get("supervisor").size(), 2);
	}

	@Test
	public void sameDirectorsNumber() {
		assertEquals("Not the right number of directors", callCenter.getAllEmployeesInShift().get("director").size(),
				1);
	}

	@Test
	public void getAvailableEmployee() throws InterruptedException {
		assertEquals(ec.getNextAvailableEmployee().getName(), "Celeste");
		assertEquals(ec.getNextAvailableEmployee().getName(), "Claudia");
	}

	/**
	 * Expecting 6 employees busy in the call center shift
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void employeesBusyCount() throws InterruptedException {
		assertEquals(ec.getEmployeesByStatus("busy").size(), 4);
	}

	/**
	 * Expecting 6 employees busy in the call center shift
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void employeesAvailableCount() throws InterruptedException {
		assertEquals(ec.getEmployeesByStatus("available").size(), 2);
	}
}
