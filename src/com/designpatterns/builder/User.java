package com.designpatterns.builder;

public class User {

	private String firstname;
	private String lastName;

	public User(String firstname) {
		this.firstname = firstname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public static UserBuilder builder() {
		return new UserBuilder();
	}

	@Override
	public String toString() {
		return "User [firstname=" + firstname + ", lastName=" + lastName + "]";
	}

	public static class UserBuilder {
		private String firstname;
		private String lastName;

		public UserBuilder setFirstname(String firstname) {
			this.firstname = firstname;
			return this;
		}

		public UserBuilder setLastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public User build() {
			User user = new User(firstname);
			user.setLastName(lastName);
			return user;
		}
	}

	public static void main(String args[]) {
		System.out.println(User.builder().setFirstname("first").setLastName("last").build().toString());
	}
}
