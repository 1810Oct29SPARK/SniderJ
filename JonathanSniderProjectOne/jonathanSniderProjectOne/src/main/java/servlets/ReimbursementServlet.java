package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import beans.Employee;
import beans.Reimbursement;
import utilPackage.UtilReimbursement;

/**
 * Servlet implementation class ReimbursementServlet
 */
public class ReimbursementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReimbursementServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null) {
			request.getRequestDispatcher("reimbursement.html").forward(request, response);
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
		response.setContentType("text/html");
		UtilReimbursement ur=new UtilReimbursement();
		HttpSession session = request.getSession(false);
		int employeeId=Integer.parseInt(session.getAttribute("employeeId").toString());
		String firstName=session.getAttribute("firstName").toString();
		String lastName= session.getAttribute("lastName").toString();
		int reportsTo= Integer.parseInt(session.getAttribute("reportsTo").toString());
		boolean isManager=Boolean.parseBoolean(session.getAttribute("isManager").toString());
		String jobTitle=session.getAttribute("jobTitle").toString();
		double accountBalance=Double.parseDouble(session.getAttribute("accountBalance").toString());
		String logInUsername=session.getAttribute("logInUsername").toString();
		String logInPassword=session.getAttribute("logInPassword").toString();
		String reimbursementName=request.getParameter("newReimbursementReason");
		double reimbursementAmount=Double.parseDouble(request.getParameter("newReimbursementAmount"));
		Employee e=new Employee(employeeId,firstName,lastName,reportsTo,isManager,jobTitle,accountBalance,logInUsername,logInPassword);	
		ur.insertReimbursement(e, reimbursementName, reimbursementAmount, false, 0);
		request.getRequestDispatcher("reimbursement.html").forward(request, response);
	}

}
