package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
	{
		resp.setContentType("text/html");
		PrintWriter pw=resp.getWriter();
		req.getRequestDispatcher("base.html").include(req, resp);
		HttpSession session= req.getSession(false);
		//required because trying to invalidate a null session will throw a null pointer exception
		if(session != null)
		{
			session.invalidate();
		}
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
	{
	}
}
