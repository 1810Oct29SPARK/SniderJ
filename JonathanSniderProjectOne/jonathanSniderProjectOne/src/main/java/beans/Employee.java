package beans;

public class Employee {
	public Employee(int employeeId, String firstName, String lastName, int reportsTo, boolean isManager,
			String jobTitle, double accountBalance, String logInUsername, String logInPassword) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.reportsTo = reportsTo;
		this.isManager = isManager;
		this.jobTitle = jobTitle;
		this.accountBalance = accountBalance;
		this.logInUsername = logInUsername;
		this.logInPassword = logInPassword;
	}
private int employeeId;
private String firstName;
private String lastName;
private int reportsTo;
private boolean isManager;
private String jobTitle;
private double accountBalance;
private String logInUsername;
private String logInPassword;
@Override
public String toString() {
	return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
			+ ", reportsTo=" + reportsTo + ", isManager=" + isManager + ", jobTitle=" + jobTitle + ", accountBalance="
			+ accountBalance + ", logInUsername=" + logInUsername + ", logInPassword=" + logInPassword + "]";
}
public int getEmployeeId() {
	return employeeId;
}
public void setEmployeeId(int employeeId) {
	this.employeeId = employeeId;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public int getReportsTo() {
	return reportsTo;
}
public void setReportsTo(int reportsTo) {
	this.reportsTo = reportsTo;
}
public boolean isManager() {
	return isManager;
}
public void setManager(boolean isManager) {
	this.isManager = isManager;
}
public String getJobTitle() {
	return jobTitle;
}
public void setJobTitle(String jobTitle) {
	this.jobTitle = jobTitle;
}
public double getAccountBalance() {
	return accountBalance;
}
public void setAccountBalance(double accountBalance) {
	this.accountBalance = accountBalance;
}
public String getLogInUsername() {
	return logInUsername;
}
public void setLogInUsername(String logInUsername) {
	this.logInUsername = logInUsername;
}
public String getLogInPassword() {
	return logInPassword;
}
public void setLogInPassword(String logInPassword) {
	this.logInPassword = logInPassword;
}
}

