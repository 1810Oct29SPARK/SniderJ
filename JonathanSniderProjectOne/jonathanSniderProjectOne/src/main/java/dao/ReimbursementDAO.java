package dao;

import java.util.List;

import beans.Employee;
import beans.Reimbursement;

public interface ReimbursementDAO {
public List<Reimbursement> getReimbursements();
public Reimbursement getReimbursementById(int id);
public void insertReimbursement(Employee employee, String reimbursementName,double reimbursementAmount,Boolean reimbursementApproved, int decidingManagerId);
}
