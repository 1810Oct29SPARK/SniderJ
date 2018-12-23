package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import beans.Reimbursement;
import utilPackage.UtilReimbursement;

/**
 * Servlet implementation class ManagerFunctions
 */
public class ManagerFunctions extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerFunctions() {
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
		UtilReimbursement ue=new UtilReimbursement();
		int employeeId=Integer.parseInt(session.getAttribute("employeeId").toString());
		List<Reimbursement> reimbursements= ue.getReimbursementsByManagerId(employeeId);
		response.getWriter().write((new ObjectMapper()).writeValueAsString(reimbursements));
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
