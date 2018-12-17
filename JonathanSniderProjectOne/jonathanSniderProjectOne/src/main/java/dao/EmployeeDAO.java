package dao;

import java.util.List;

import beans.Employee;

public interface EmployeeDAO {

	
	public List<Employee> getEmployees();
	public Employee getEmployeeById(int id);
	public void insertEmployee(String firstName,String lastName, int reportsTo, boolean isManager, String jobTitle,double accountBalance,String logInUsername,String logInPassword);
}
