package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Credentials;
import beans.User;
import service.AuthenticationService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	AuthenticationService authService= new AuthenticationService();
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8552683134862056264L;


	//return login page for get request
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
	{
		req.getRequestDispatcher("LoginPage.html").forward(req,resp);
	}

	
	//handle POST request from form on Login page
	//or anywhere else
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
	{
		System.out.println("hey baby");
		//checks whether a session exists, otherwise creates a new one
		//overloaded version takes a boolean where false returns null if no
		//session exists for current request
		HttpSession session=req.getSession();
		
		resp.setContentType("text/html");
		//grab paramater from request
		//these are the names from the forms on the login page HTML
		Credentials cred= new Credentials(req.getParameter("username"), req.getParameter("password"));
		//attampt to authenticate user
		//keep in mind isvalid user returns null if it fails to find a matching username/password
		User u= authService.isValidUser(cred);
		if(u!=null)
			//set user information as session attributes
		{
			session.setAttribute("userId", u.getId());
			session.setAttribute("username", u.getUsername());
			session.setAttribute("firstname", u.getFirstname());
			session.setAttribute("lastname", u.getLastname());
			session.setAttribute("email", u.getEmail());
			session.setAttribute("problem", null);
			//redirect user to profile page if authenticated
			resp.sendRedirect("profile");
		}
		else
		{
			session.setAttribute("problem", "invalid credentials");
			resp.sendRedirect("login");
			//redirect back to login page 
			
		}
		
	
	}
	
}


