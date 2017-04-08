package test.java;

import org.junit.Before;
import org.junit.Test;

import main.java.controller.MainController;
import main.java.model.CallCenter;
import main.java.model.Customer;
import main.java.model.Employee;

public class CallCenterTest<E> {
	MainController<Employee> mainController;
	private Customer c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11;

	@Before
	public void setUp() throws Exception {
		//create employees
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
		//create a callcenter and add employees
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
		c11 = new Customer("Dany");
		//create a mein controller
		mainController= new MainController<>(callCenter);
	}

	@Test
	public void runElevenCalls() throws InterruptedException {
		//run eleven calls to show behavior
		mainController.getDispatcher().dispatchCall(1, c1);
		mainController.getDispatcher().dispatchCall(2, c2);
		mainController.getDispatcher().dispatchCall(3, c3);
		mainController.getDispatcher().dispatchCall(4, c4);
		mainController.getDispatcher().dispatchCall(5, c5);
		mainController.getDispatcher().dispatchCall(6, c6);
		mainController.getDispatcher().dispatchCall(7, c7);
		mainController.getDispatcher().dispatchCall(8, c8);
		mainController.getDispatcher().dispatchCall(9, c9);
		mainController.getDispatcher().dispatchCall(10, c10);
		mainController.getDispatcher().dispatchCall(11, c11);
		mainController.getDispatcher().terminateDispatch();
	}

}
