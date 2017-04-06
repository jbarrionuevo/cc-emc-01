package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.CallCenter;
import model.Employee;

public class EmployeeTest {
	Employee o1, o2, o3, s1, s2, d1;
	CallCenter<Employee> callCenter;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	
	@Before
    public void setUp() throws Exception {
        o1 = new Employee("Celeste", "operador");
        o2 = new Employee("Raul", "operador");
        o3 = new Employee("Raul", "operador");
        s1 = new Employee("Claudia", "supervisor");
        s2 = new Employee("Carlos", "supervisor");
        d1 = new Employee("Matias", "director");
        callCenter = new CallCenter<Employee>();
        callCenter.addEmployeeToShift(o1);
        callCenter.addEmployeeToShift(o2);
        callCenter.addEmployeeToShift(o3);
        callCenter.addEmployeeToShift(s1);
        callCenter.addEmployeeToShift(s2);
        callCenter.addEmployeeToShift(d1);
    }	

	@Test
	public void isSameEmployee() {
		assertEquals("Different employees", o1 , o1);
	}
	@Test
	public void isNotSameEmployee() {
		assertNotEquals("Same employees", o1 , o2);
	}
	@Test
	public void sameEmployeeNumber() {
		assertEquals("Not the right number of employees", callCenter.getAllEmployeesInShift().size(), 6);
	}

}
