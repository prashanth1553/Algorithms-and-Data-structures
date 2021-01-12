package com.solidprinciples.srp;

public class EmployeeStore implements IEmployeeStore {
	// inject in runtime
	private IEmailSender emailSender;

	@Override
	public Employee getEmployeeById(Long id) {
		return null;
	}

	@Override
	public void addEmployee(Employee employee) {
	}

	@Override
	public void sendEmail(Employee employee, String content) {
		// TODO Auto-generated method stub

	}
}