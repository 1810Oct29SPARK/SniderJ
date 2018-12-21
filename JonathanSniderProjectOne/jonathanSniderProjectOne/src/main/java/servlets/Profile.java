package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Profile
 */
public class Profile extends HttpServlet {
	
       
    /**
	 * 
	 */
	private static final long serialVersionUID = 1921801819225175967L;

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
		//Check whether as session exists for the incoming request
				HttpSession session = request.getSession(false);
				if (session != null && session.getAttribute("logInUsername") != null) {
					request.getRequestDispatcher("employeeProfile.html").forward(request, response);
				} 
				else 
				{
					System.out.println("for some reason I'm doing this");
					response.sendRedirect("login");
				}
	}


}
