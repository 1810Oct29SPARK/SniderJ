package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalculatorServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -756208604967516279L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
	{
		//forward the request (passing on to another request handler)
		RequestDispatcher rd=req.getRequestDispatcher("Calculator.html");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
	{
		// obtain request parameters
		
		//
		
		String paramN1= req.getParameter("n1");
		String paramN2= req.getParameter("n2");
		String paramOperation= req.getParameter("operation");
		

		
		
		Double n1=Double.parseDouble(req.getParameter("n1"));
		Double n2=Double.parseDouble(req.getParameter("n2"));
		String operation= req.getParameter("operation");
		Double answer=0.0;
		
		switch (operation)
		{
		case "add":
			answer=n1+n2;
			break;
		case "subtract":
			answer=n1-n2;
			break;
		case "multiply":
			answer=n1*n2;
			break;
		case "divide":
			answer=n1/n2;
			break;
		}
		
		//include answer in response
		/*
		PrintWriter pw=resp.getWriter();
		
		pw.write("the answer is: "+answer);
		*/
		
		req.setAttribute("answer", answer);
		//pass on this attribute to answer servlet
		//RequestDispatcher rd
		
		
	}

}
