package com.hyend.logical.interview.questions.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * An amazon interview question
 * 
 * Q: Find a common manager between two empIds from a list of Employees.
 * 	  4500->null
 * 	  5000->4500
 * 	  5001->4501
 * 	  4501->4500
 * 
 * Solution : A Di-Graphical solution. Map the adjacent manager node for each
 * 			   employee node and recursively iterate through from the mapping (DFS). 
 * 
 * @author gopi_karmakar
 */
public class FindCommonManager {
	
	// To hold the organization's structure
	HashMap<String, String> map;
	
	public FindCommonManager() {
		map = new HashMap<>();
	}

	/**
	 * Test data class
	 * 
	 * @author gopi_karmakar
	 *
	 */
	public class Employee {
		
		String empId;
		String mgrId;
		
		public Employee(String empId, String mgrId) {
			this.empId = empId;
			this.mgrId = mgrId;
		}
	}
	
	/**
	 * Map the adjacent manager for each employee.
	 * 
	 * @param list
	 */
	public void empToMgrMapping(List<Employee> list) {
		
		for(Employee emp : list) {
			map.put(emp.empId, emp.mgrId);
		}
	}
		
	public String findCommonManager(String emp1, String emp2) {
		
		String mgr1 = find(emp1, "");
		System.out.println("MGR-1 = " + mgr1);	
		String mgr2 = find(emp2, "");
		System.out.println("MGR-2 = " + mgr2);
		return (mgr1.equals(mgr2)) ? mgr2 : null;	
	}
	
	/**
	 * Recursive method to find the employee manager map chaining.
	 * @param emp
	 * @param mgr
	 * @return
	 */
	private String find(String emp, String mgr) {
		
		if(emp == null)
			return mgr;
		
		return find(map.get(emp), emp);
	}
	
	/**
	 * Creation of testing data.
	 * @return
	 */
	public List<Employee> createSampleData() {
		
		Employee emp1 = new Employee("4500", null);
		Employee emp2 = new Employee("5000", "4500");
		Employee emp3 = new Employee("5001", "4501");
		Employee emp4 = new Employee("4501", "4500");
		List<Employee> list = new ArrayList<>();
		list.add(emp1);
		list.add(emp2);
		list.add(emp3);
		list.add(emp4);
		
		return list;
	}
}