package test.java;

import org.junit.Before;
import org.junit.Test;

import main.java.controller.MainController;
import main.java.model.CallCenter;
import main.java.model.Customer;
import main.java.model.Employee;

public class CallCenterMainTest {

	private Employee o1, o2, o3, o4, o5, o6, o7, o8, o9, s1, s2, d1;
	private Customer c1, c2, c3, c4, c5, c6, c7, c8, c9, c10;
	private MainController<Employee> mc;
	private CallCenter<Employee> callCenter;
	
	@Before
	public void setUp() throws Exception {
		s1 = new Employee("Laurent", "supervisor");
		d1 = new Employee("Rolph", "director");
		o1 = new Employee("Celeste", "operator");
		s2 = new Employee("Laurent", "supervisor");
		o2 = new Employee("Rolph", "operator");
		o3 = new Employee("Ramon", "operator");
		o4 = new Employee("Cecil", "operator");
		o5 = new Employee("Keith", "operator");
		o6 = new Employee("Ramiro", "operator");
		o7 = new Employee("Charles", "operator");
		o8 = new Employee("Robert", "operator");
		o9 = new Employee("Zoe", "operator");
		// create customers
		c1 = new Customer("Claude");
		c2 = new Customer("John");
		c3 = new Customer("Peter");
		c4 = new Customer("Alex");
		c5 = new Customer("Ismael");
		c6 = new Customer("Tommy");
		c7 = new Customer("Bruce");
		c8 = new Customer("Niko");
		c9 = new Customer("Dave");
		c10 = new Customer("Danilo");
		// Add employees to call center
		callCenter = new CallCenter<Employee>();
		callCenter.addEmployeeToShift(s1);
		callCenter.addEmployeeToShift(d1);
		callCenter.addEmployeeToShift(o1);
		callCenter.addEmployeeToShift(o2);
		callCenter.addEmployeeToShift(o3);
		callCenter.addEmployeeToShift(o4);
		callCenter.addEmployeeToShift(o5);
		callCenter.addEmployeeToShift(o6);
		callCenter.addEmployeeToShift(s2);
		callCenter.addEmployeeToShift(o7);
		callCenter.addEmployeeToShift(o8);
		callCenter.addEmployeeToShift(o9);
		// Create a main controller
		mc = new MainController<Employee>(callCenter);

	}

	@Test
	public void runCalls() throws InterruptedException {
		mc.getDispatcher().dispatchCall(1, c1);
		mc.getDispatcher().dispatchCall(2, c2);
		mc.getDispatcher().dispatchCall(3, c3);
		mc.getDispatcher().dispatchCall(4, c4);
		mc.getDispatcher().dispatchCall(5, c5);
		mc.getDispatcher().dispatchCall(6, c6);
		mc.getDispatcher().dispatchCall(7, c7);
		mc.getDispatcher().dispatchCall(8, c8);
		mc.getDispatcher().dispatchCall(9, c9);
		mc.getDispatcher().dispatchCall(10, c10);
	}

}
