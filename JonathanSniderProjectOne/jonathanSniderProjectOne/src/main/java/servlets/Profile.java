package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Employee;
import utilPackage.UtilEmployee;
import utilPackage.UtilReimbursement;

/**
 * Servlet implementation class Profile
 */
public class Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Profile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null) {
			//set boss' name here
			request.getRequestDispatcher("employeeProfile.html").forward(request, response);
		} 
		else 
		{
			System.out.println("for some reason I'm doing this");
			response.sendRedirect("login");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UtilEmployee ue=new UtilEmployee();
		response.setContentType("text/html");
		HttpSession session = request.getSession(false);
		int employeeId=Integer.parseInt(session.getAttribute("employeeId").toString());
		String firstName=request.getParameter("firstNameProfileChange");
		session.setAttribute("firstName", firstName);
		String lastName= request.getParameter("lastNameProfileChange");
		session.setAttribute("lastName", lastName);
		int reportsTo= Integer.parseInt(session.getAttribute("reportsTo").toString());
		boolean isManager=Boolean.parseBoolean(session.getAttribute("isManager").toString());
		String jobTitle=session.getAttribute("jobTitle").toString();
		double accountBalance=Double.parseDouble(session.getAttribute("accountBalance").toString());
		String logInUsername=request.getParameter("usernameProfileChange");
		session.setAttribute("logInUsername", logInUsername);
		String logInPassword=request.getParameter("passwordProfileChange");
		session.setAttribute("logInPassword", logInPassword);
		Employee e=new Employee(employeeId,firstName,lastName,reportsTo,isManager,jobTitle,accountBalance,logInUsername,logInPassword);	
		ue.updateEmployee(e);
		request.getRequestDispatcher("employeeProfile.html").forward(request, response);
		
	}

}
