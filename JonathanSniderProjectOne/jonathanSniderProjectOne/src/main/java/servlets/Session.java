package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import beans.Employee;

/**
 * Servlet implementation class Session
 */
public class Session extends HttpServlet {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 8566476288462282309L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public Session() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json");
		HttpSession session = request.getSession(false);
		if(session !=null && session.getAttribute("logInUsername")!=null)
		{
			try {
				int employeeId=Integer.parseInt(session.getAttribute("employeeId").toString());
				String firstName=session.getAttribute("firstName").toString();
				String lastName= session.getAttribute("lastName").toString();
				int reportsTo= Integer.parseInt(session.getAttribute("reportsTo").toString());
				boolean isManager=Boolean.parseBoolean(session.getAttribute("isManager").toString());
				String jobTitle=session.getAttribute("jobTitle").toString();
				double accountBalance=Double.parseDouble(session.getAttribute("accountBalance").toString());
				String logInUsername=session.getAttribute("logInUsername").toString();
				String logInPassword=session.getAttribute("logInPassword").toString();
				Employee e=new Employee(employeeId,firstName,lastName,reportsTo,isManager,jobTitle,accountBalance,logInUsername,logInPassword);
				response.getWriter().write((new ObjectMapper()).writeValueAsString(e));
			}
			catch (Exception e)
			{
				response.getWriter().write("{\"session\":null}");
			}
		}
	}

}
