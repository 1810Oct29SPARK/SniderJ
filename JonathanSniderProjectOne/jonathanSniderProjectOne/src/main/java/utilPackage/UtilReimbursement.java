package utilPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Employee;
import beans.Reimbursement;
import dao.ReimbursementDAO;

public class UtilReimbursement implements ReimbursementDAO {

	@Override
	public List<Reimbursement> getReimbursements() {
		List<Reimbursement> reimbursementList= new ArrayList<Reimbursement>();
		Reimbursement r=null;
		UtilEmployee util=new UtilEmployee();
		try(Connection con = UtilConnection.getConnection()){
			System.out.println(con);
			String sql="SELECT * "+"FROM REIMBURSEMENT";
			PreparedStatement pstmt=con.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				int ReimbursementId= rs.getInt("REIMBURSEMENT_ID");
				int EmployeeId=rs.getInt("EMPLOYEE_ID");
				Employee assignedEmployee= util.getEmployeeById(EmployeeId);
				String reimbursementName = rs.getString("REIMBURSEMENT_NAME");
				double reimbursementAmount=rs.getDouble("REIMBURSEMENT_AMOUNT");
				boolean reimbursementApproved=rs.getBoolean("REIMBURSEMENT_APPROVED");
				int decidingManagerId= rs.getInt("DECIDING_MANAGER_ID");
				r= new Reimbursement(ReimbursementId,assignedEmployee,reimbursementName,reimbursementAmount,reimbursementApproved,decidingManagerId);
				reimbursementList.add(r);
			}
			
		} 
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Reimbursement re:reimbursementList)
		{
			System.out.println(re.toString());
		}
		return reimbursementList;
	}

	@Override
	public Reimbursement getReimbursementById(int id) {
		Reimbursement r=null;
		UtilEmployee util=new UtilEmployee();
		try(Connection con = UtilConnection.getConnection()){
			System.out.println(con);
			String sql= "SELECT * "+"FROM REIMBURSEMENT R "+
			"WHERE R.REIMBURSEMENT_ID= ? ";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next())
			{
				int ReimbursementId= rs.getInt("REIMBURSEMENT_ID");
				int EmployeeId=rs.getInt("EMPLOYEE_ID");
				Employee assignedEmployee= util.getEmployeeById(EmployeeId);
				String reimbursementName = rs.getString("REIMBURSEMENT_NAME");
				double reimbursementAmount=rs.getDouble("REIMBURSEMENT_AMOUNT");
				boolean reimbursementApproved=rs.getBoolean("REIMBURSEMENT_APPROVED");
				int decidingManagerId= rs.getInt("DECIDING_MANAGER_ID");
				r= new Reimbursement(ReimbursementId,assignedEmployee,reimbursementName,reimbursementAmount,reimbursementApproved,decidingManagerId);
			}
		} 
		
		
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(r.toString());
		return r;
	}

	@Override
	public void insertReimbursement(Employee employee, String reimbursementName, double reimbursementAmount,
			Boolean reimbursementApproved, int decidingManagerId) {
		try(Connection con = UtilConnection.getConnection()){
			System.out.println(con);
			String sql= "INSERT INTO REIMBURSEMENT(EMPLOYEE_ID,REIMBURSEMENT_NAME,REIMBURSEMENT_AMOUNT,REIMBURSEMENT_APPROVED,DECIDING_MANAGER_ID) VALUES(?,?,?,?,?)";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, employee.getEmployeeId());
			pstmt.setString(2,reimbursementName);
			pstmt.setDouble(3, reimbursementAmount);
			if(reimbursementApproved==true)
			{
				pstmt.setInt(4, 1);
			}
			else
			{
				pstmt.setInt(4, 0);
			}
			pstmt.setInt(5, decidingManagerId);
			pstmt.executeQuery();
			System.out.println("insert succesful!");
			
	} 
		catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}

	@Override
	public void removeReimbursement(int id) {
		try(Connection con = UtilConnection.getConnection()){
			System.out.println(con);
			String sql= "DELETE FROM REIMBURSEMENT WHERE REIMBURSEMENT_ID=?";
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
	
	public void updateReimbursement(Reimbursement reimbursement)
	{
		try(Connection con = UtilConnection.getConnection()){
			System.out.println(con);
			String sql= "UPDATE REIMBURSEMENT SET EMPLOYEE_ID=?, REIMBURSEMENT_NAME=?, REIMBURSEMENT_AMOUNT=?, REIMBURSEMENT_APPROVED=?, DECIDING_MANAGER_ID=? WHERE REIMBURSEMENT_ID=?";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, reimbursement.getEmployee().getEmployeeId());
			pstmt.setString(2, reimbursement.getReimbursementName());
			pstmt.setDouble(2, reimbursement.getReimbursementAmount());
			if(reimbursement.getReimbursementApproved()==true)
			{
				pstmt.setDouble(3, 1);
			}
			else
			{
				pstmt.setDouble(3, 0);
			}
			pstmt.setInt(4, reimbursement.getDecidingManagerId());
			pstmt.setInt(5, reimbursement.getReimbursementId());
			
			
			
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Reimbursement> getReimbursementsById(int id)
	{
		List<Reimbursement> reimbursementList=new ArrayList<Reimbursement>();
		Reimbursement r=null;
		UtilEmployee util=new UtilEmployee();
		try(Connection con = UtilConnection.getConnection()){
			System.out.println(con);
			String sql= "SELECT * FROM REIMBURSEMENT WHERE EMPLOYEE_ID=?";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				int ReimbursementId= rs.getInt("REIMBURSEMENT_ID");
				int EmployeeId=rs.getInt("EMPLOYEE_ID");
				Employee assignedEmployee= util.getEmployeeById(EmployeeId);
				String reimbursementName = rs.getString("REIMBURSEMENT_NAME");
				double reimbursementAmount=rs.getDouble("REIMBURSEMENT_AMOUNT");
				boolean reimbursementApproved=rs.getBoolean("REIMBURSEMENT_APPROVED");
				int decidingManagerId= rs.getInt("DECIDING_MANAGER_ID");
				r= new Reimbursement(ReimbursementId,assignedEmployee,reimbursementName,reimbursementAmount,reimbursementApproved,decidingManagerId);
				reimbursementList.add(r);
			}
		} 
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reimbursementList;
	}
	public List<Reimbursement> getReimbursementsByManagerId(int id)
	{
		List<Reimbursement> reimbursementList=new ArrayList<Reimbursement>();
		Reimbursement r=null;
		UtilEmployee util=new UtilEmployee();
		try(Connection con = UtilConnection.getConnection()){
			System.out.println(con);
			String sql= "SELECT * FROM REIMBURSEMENT WHERE EMPLOYEE_ID>?";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				int ReimbursementId= rs.getInt("REIMBURSEMENT_ID");
				int EmployeeId=rs.getInt("EMPLOYEE_ID");
				Employee assignedEmployee= util.getEmployeeById(EmployeeId);
				String reimbursementName = rs.getString("REIMBURSEMENT_NAME");
				double reimbursementAmount=rs.getDouble("REIMBURSEMENT_AMOUNT");
				boolean reimbursementApproved=rs.getBoolean("REIMBURSEMENT_APPROVED");
				int decidingManagerId= rs.getInt("DECIDING_MANAGER_ID");
				r= new Reimbursement(ReimbursementId,assignedEmployee,reimbursementName,reimbursementAmount,reimbursementApproved,decidingManagerId);
				reimbursementList.add(r);
			}
		} 
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reimbursementList;
	}
		
	}

