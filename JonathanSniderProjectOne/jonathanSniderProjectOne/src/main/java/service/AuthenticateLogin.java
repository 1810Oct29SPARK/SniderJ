package service;

import java.util.List;

import beans.Employee;
import beans.LoginCredentials;
import beans.Reimbursement;
import utilPackage.UtilEmployee;

public class AuthenticateLogin {
	public AuthenticateLogin() {
	}
	
	public Employee isValidUser(LoginCredentials credentials) {
		Employee e = null;
		UtilEmployee ue = new UtilEmployee();
		String username = credentials.getUsername();
		String password = credentials.getPassword();
		//this is AUTHENTICATION (does the user exist in the system?)
		//now AUTHORIZATION (what can the user access within the system?) (user roles)
		//take credentials and return the User to which they belong if it exists
		if (username != null && password != null) {
			List<Employee> employeeList= ue.getEmployees();
			for(Employee emp : employeeList)
			{
				
				if(username.equals(emp.getLogInUsername()) && password.equals(emp.getLogInPassword()))
				{
					System.out.println("nothing wrong here, chief");
					e=emp;
				}
			}
			}
		return e;
		}
	

	}
