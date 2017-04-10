package test.java;

import org.junit.Before;
import org.junit.Test;

import main.java.controller.MainController;
import main.java.model.CallCenter;
import main.java.model.Customer;
import main.java.model.Employee;

/**
 * Main test case that runs 10 calls with a MainController.
 * 
 * @author Jorge
 *
 * @param <E>
 */
public class CallCenterTest<E> {
	private MainController<Employee> mainController;

	@Before
	public void setUp() throws Exception {
		// create employees
		Employee s1 = new Employee("Laurent", "supervisor");
		Employee s2 = new Employee("Laurent", "supervisor");
		Employee d1 = new Employee("Rolph", "director");
		Employee o1 = new Employee("Celeste", "operator");
		Employee o2 = new Employee("Rolph", "operator");
		Employee o3 = new Employee("Ramon", "operator");
		Employee o4 = new Employee("Cecil", "operator");
		Employee o5 = new Employee("Keith", "operator");
		Employee o6 = new Employee("Ramiro", "operator");
		Employee o7 = new Employee("Charles", "operator");
		Employee o8 = new Employee("Robert", "operator");
		Employee o9 = new Employee("Zoe", "operator");
		// create a callcenter and add employees
		CallCenter<Employee> callCenter = new CallCenter<Employee>();
		callCenter.addEmployeeToShift(s1);
		callCenter.addEmployeeToShift(s2);
		callCenter.addEmployeeToShift(d1);
		callCenter.addEmployeeToShift(o1);
		callCenter.addEmployeeToShift(o2);
		callCenter.addEmployeeToShift(o3);
		callCenter.addEmployeeToShift(o4);
		callCenter.addEmployeeToShift(o5);
		callCenter.addEmployeeToShift(o6);
		callCenter.addEmployeeToShift(o7);
		callCenter.addEmployeeToShift(o8);
		callCenter.addEmployeeToShift(o9);
		// create customers
		Customer c1 = new Customer("Claude");
		Customer c2 = new Customer("John");
		Customer c3 = new Customer("Peter");
		Customer c4 = new Customer("Alex");
		Customer c5 = new Customer("Ismael");
		Customer c6 = new Customer("Tommy");
		Customer c7 = new Customer("Bruce");
		Customer c8 = new Customer("Niko");
		Customer c9 = new Customer("Dave");
		Customer c10 = new Customer("Danilo");
		// add customers to call center
		callCenter.addCustomer(c1);
		callCenter.addCustomer(c2);
		callCenter.addCustomer(c3);
		callCenter.addCustomer(c4);
		callCenter.addCustomer(c5);
		callCenter.addCustomer(c6);
		callCenter.addCustomer(c7);
		callCenter.addCustomer(c8);
		callCenter.addCustomer(c9);
		callCenter.addCustomer(c10);
		// create a main controller
		mainController = new MainController<>(callCenter);
	}

	@Test
	public void runTenCalls() throws InterruptedException {
		// run eleven calls to show behavior
		mainController.runCallCenter();
	}

}
