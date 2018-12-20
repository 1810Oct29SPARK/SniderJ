package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import beans.User;

@WebServlet("/session")
public class SessionServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7471440871806513750L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
	{
		//grab current session if it exists
		resp.setContentType("application/json");
		HttpSession session = req.getSession(false);
		if(session !=null && session.getAttribute("username")!=null)
		{
			
			try {
			int userId=Integer.parseInt(session.getAttribute("id").toString());
			String username=session.getAttribute("username").toString();
			String firstname=session.getAttribute("firstname").toString();
			String lastname=session.getAttribute("lastname").toString();
			String email=session.getAttribute("email").toString();
			
			User u=new User(userId,username,firstname,lastname,email);
			resp.getWriter().write((new ObjectMapper()).writeValueAsString(u));
			}
			catch (Exception e)
			{
				resp.getWriter().write("{\"session\":null}");
			}
		}
		else
		{
			resp.getWriter().write("{\"session\":null}");
		}
		
	}

}

