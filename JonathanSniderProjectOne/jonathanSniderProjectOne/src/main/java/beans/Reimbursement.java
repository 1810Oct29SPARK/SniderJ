package beans;

public class Reimbursement {
	public Reimbursement(int reimbursementId, Employee employee, String reimbursementName, double reimbursementAmount,
			Boolean reimbursementApproved, int decidingManagerId) {
		super();
		this.reimbursementId = reimbursementId;
		this.employee = employee;
		this.reimbursementName = reimbursementName;
		this.reimbursementAmount = reimbursementAmount;
		this.reimbursementApproved = reimbursementApproved;
		this.decidingManagerId = decidingManagerId;
	}
	private int reimbursementId;
	private Employee employee;
	private String reimbursementName;
	private double reimbursementAmount;
	private Boolean reimbursementApproved;
	private int decidingManagerId;
	public int getReimbursementId() {
		return reimbursementId;
	}
	public void setReimbursementId(int reimbursementId) {
		this.reimbursementId = reimbursementId;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public String getReimbursementName() {
		return reimbursementName;
	}
	public void setReimbursementName(String reimbursementName) {
		this.reimbursementName = reimbursementName;
	}
	public double getReimbursementAmount() {
		return reimbursementAmount;
	}
	public void setReimbursementAmount(double reimbursementAmount) {
		this.reimbursementAmount = reimbursementAmount;
	}
	public Boolean getReimbursementApproved() {
		return reimbursementApproved;
	}
	public void setReimbursementApproved(Boolean reimbursementApproved) {
		this.reimbursementApproved = reimbursementApproved;
	}
	public int getDecidingManagerId() {
		return decidingManagerId;
	}
	public void setDecidingManagerId(int decidingManagerId) {
		this.decidingManagerId = decidingManagerId;
	}
	@Override
	public String toString() {
		return "Reimbursement [reimbursementId=" + reimbursementId + ", employee=" + employee + ", reimbursementName="
				+ reimbursementName + ", reimbursementAmount=" + reimbursementAmount + ", reimbursementApproved="
				+ reimbursementApproved + ", decidingManagerId=" + decidingManagerId + "]";
	}
}
