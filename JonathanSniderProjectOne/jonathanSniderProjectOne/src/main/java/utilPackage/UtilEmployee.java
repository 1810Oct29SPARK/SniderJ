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
			String sql= "INSERT INTO EMPLOYEE(FIRST_NAME,LAST_NAME,REPORTS_TO,IS_MANAGER,JOB_TITLE,ACCOUNT_BALANCE,LOGIN_USERNAME,LOGIN_PASSWORD) VALUES(?,?,?,?,?,?,?,?)";
		    PreparedStatement pstmt =con.prepareStatement(sql);
		    pstmt.setString(1, firstName);
		    pstmt.setString(2, lastName);
		    pstmt.setInt(3, reportsTo);
		    if(isManager==true)
		    {
		    	pstmt.setInt(4, 1);
		    }
		    else
		    {
		    	pstmt.setInt(4, 0);
		    }
			pstmt.setString(5, jobTitle);
			pstmt.setDouble(6, accountBalance);
			pstmt.setString(7, logInUsername);
			pstmt.setString(8, logInPassword);
			pstmt.executeUpdate();
			System.out.println("insertion succesful!");
			
			
		} 
		
		
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void removeEmployee(int id) {
		try(Connection con = UtilConnection.getConnection()){
			System.out.println(con);
			String sql= "DELETE FROM EMPLOYEE WHERE EMPLOYEE_ID=?";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} 
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Removal Successful!");
		
	}
	
	public void updateEmployee(Employee employee)
	{
		try(Connection con = UtilConnection.getConnection()){
			System.out.println(con);
			String sql= "UPDATE EMPLOYEE SET FIRST_NAME=?,LAST_NAME=?,REPORTS_TO=?,IS_MANAGER=?,JOB_TITLE=?,ACCOUNT_BALANCE=?,LOGIN_USERNAME=?,LOGIN_PASSWORD=? WHERE EMPLOYEE_ID=?";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1, employee.getFirstName());
			pstmt.setString(2, employee.getLastName());
			pstmt.setInt(3, employee.getReportsTo());
		    if(employee.getManager()==true)
		    {
		    	pstmt.setInt(4, 1);
		    }
		    else
		    {
		    	pstmt.setInt(4, 0);
		    }
			pstmt.setString(5, employee.getJobTitle());
			pstmt.setDouble(6, employee.getAccountBalance());
			pstmt.setString(7, employee.getLogInUsername());
			pstmt.setString(8, employee.getLogInPassword());
			pstmt.setInt(9, employee.getEmployeeId());
			pstmt.executeUpdate();
			System.out.println("employee updated!");
		} 
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

}
}
