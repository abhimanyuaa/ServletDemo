package com.beans;

public class PersonModel {
	private String username;
	private String password;
	private String gender;
	private String subject;
	private String[] hobbies;
	
	public String[] getHobbies() {
		return hobbies;
	}
	public void setHobbies(String[] hobbies2) {
		this.hobbies = hobbies2;
	}
	public PersonModel() {
		
		
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	@Override
	public String toString() {
		return "PersonModel [username=" + username + ", password=" + password + ", gender=" + gender + ", subject="
				+ subject + "]";
	}
	
	
}
