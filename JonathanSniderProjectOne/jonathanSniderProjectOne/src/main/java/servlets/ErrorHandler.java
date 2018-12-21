package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ErrorHandler extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1063301009802007393L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException
	{
		PrintWriter pw =resp.getWriter();
		pw.write("there was an oops");
	}

}
