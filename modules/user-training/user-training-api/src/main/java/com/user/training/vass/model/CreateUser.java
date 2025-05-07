package com.user.training.vass.model;

public class CreateUser {
	
	private String name;
	private String email;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @param name
	 * @param email
	 */
	public CreateUser(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}
	/**
	 * 
	 */
	public CreateUser() {
		super();
	}
	
	

}
