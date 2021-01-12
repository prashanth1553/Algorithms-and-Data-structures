package com.solidprinciples.srp;

public interface IEmployeeStore {

	public Employee getEmployeeById(Long id);

	public void addEmployee(Employee employee);

	public void sendEmail(Employee employee, String content);
}
