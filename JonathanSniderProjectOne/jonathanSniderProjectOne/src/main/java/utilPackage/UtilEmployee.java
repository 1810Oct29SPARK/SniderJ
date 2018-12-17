package utilPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Employee;
import dao.EmployeeDAO;

public class UtilEmployee implements EmployeeDAO {

	@Override
	public List<Employee> getEmployees() {
		List<Employee> employeeList=new ArrayList<Employee>();
		Employee e=null;
		try(Connection con = UtilConnection.getConnection()){
			System.out.println(con);
			String sql= "SELECT * "+"FROM EMPLOYEE";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			while (rs.next())	{
				int employeeId= rs.getInt("EMPLOYEE_ID");
				String firstName=rs.getString("FIRST_NAME");
				String lastName=rs.getString("LAST_NAME");
				int reportsTo=rs.getInt("REPORTS_TO");
				boolean isManager=rs.getBoolean("IS_MANAGER");
				String jobTitle=rs.getString("JOB_TITLE");
				double accountBalance=rs.getDouble("ACCOUNT_BALANCE");
				String logInUsername=rs.getString("LOGIN_USERNAME");
				String logInPassword=rs.getString("LOGIN_PASSWORD");
				e= new Employee(employeeId,firstName,lastName,reportsTo,isManager,jobTitle,accountBalance,logInUsername,logInPassword);
				employeeList.add(e);
			}
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}
		for(Employee emp: employeeList)
		{
			System.out.println(emp.toString());
		}
		return employeeList;
	}

	@Override
	public Employee getEmployeeById(int id) {
		Employee e=null;
		try(Connection con = UtilConnection.getConnection()){
			System.out.println(con);
			String sql= "SELECT * "+"FROM EMPLOYEE E "+
			"WHERE E.EMPLOYEE_ID= ? ";

			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs= pstmt.executeQuery();
			if (rs.next())	{
				int employeeId= rs.getInt("EMPLOYEE_ID");
				String firstName=rs.getString("FIRST_NAME");
				String lastName=rs.getString("LAST_NAME");
				int reportsTo=rs.getInt("REPORTS_TO");
				boolean isManager=rs.getBoolean("IS_MANAGER");
				String jobTitle=rs.getString("JOB_TITLE");
				double accountBalance=rs.getDouble("ACCOUNT_BALANCE");
				String logInUsername=rs.getString("LOGIN_USERNAME");
				String logInPassword=rs.getString("LOGIN_PASSWORD");
				e= new Employee(employeeId,firstName,lastName,reportsTo,isManager,jobTitle,accountBalance,logInUsername,logInPassword);

				//a = new Account(accountId, accountNum, userId, accountName, accountBalance);
				
				
				
				
			}
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}
		System.out.println(e.toString());
		return e;
		
	}

	@Override
	public void insertEmployee(String firstName, String lastName, int reportsTo, boolean isManager, String jobTitle,
			double accountBalance, String logInUsername, String logInPassword) {
		try(Connection con = UtilConnection.getConnection()){
			System.out.println(con);
			
		} 
		
		
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
