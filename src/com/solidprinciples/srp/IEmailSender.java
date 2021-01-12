package com.solidprinciples.srp;

public interface IEmailSender {
	public void sendEmail(Employee employee, IEmailContent content);
}
