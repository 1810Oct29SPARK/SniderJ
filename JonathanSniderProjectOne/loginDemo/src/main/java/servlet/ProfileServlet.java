package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/profile")
public class ProfileServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1344565538616036012L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException,ServletException
	{
		//check whether session exists for incoming request
		//adding false simply checks if a session exists rather than create one
		HttpSession session= req.getSession(false);
		if(session !=null && session.getAttribute("username") !=null)
		{
			req.getRequestDispatcher("profile.html").forward(req, resp);
		}
		else
		{
			resp.sendRedirect("login");
		}
	}
	

}
