package test;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import controller.EmployeeController;
import model.CallCenter;
import model.Employee;

public class EmployeeControllerTest {
	EmployeeController ec;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		ec = new EmployeeController(new CallCenter<Employee>());
	}

	@Test
	public void getAvailableEmployee() throws InterruptedException {
		
	}
}
