package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Employee;
import beans.LoginCredentials;
import service.AuthenticateLogin;
import utilPackage.UtilEmployee;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	
	AuthenticateLogin authLogin = new AuthenticateLogin();
	/**
	 * 
	 */
	private static final long serialVersionUID = -7432700501449176526L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("welcomePage.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		System.out.println("handling request...");
		//because logically no session will exist at this point and we aren't overloading with
		//false, a new session will be made when null is returned.
		HttpSession session = request.getSession(); 
		response.setContentType("text/html");
		LoginCredentials login= new LoginCredentials(request.getParameter("username"),request.getParameter("password"));
		Employee e= authLogin.isValidUser(login);
		if(e!=null)
		{
			session.setAttribute("employeeId", e.getEmployeeId());
			session.setAttribute("firstName", e.getFirstName());
			session.setAttribute("lastName", e.getLastName());
			session.setAttribute("reportsTo", e.getReportsTo());
			session.setAttribute("isManager", e.getManager());
			session.setAttribute("jobTitle", e.getJobTitle());
			session.setAttribute("accountBalance", e.getAccountBalance());
			session.setAttribute("logInUsername", e.getLogInUsername());
			session.setAttribute("logInPassword", e.getLogInPassword());
			//user is sent to the homepage with these  attributes now stored in the session
			response.sendRedirect("homePage");
		}
		else {
			//if authentication fails because none of the username/passwords combinations match,
			//redirect right back to the login page 
			session.setAttribute("problem", "invalid credentials");
			
			response.sendRedirect("login");
		}
	}

}
