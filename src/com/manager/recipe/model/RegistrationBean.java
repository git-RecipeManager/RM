package com.manager.recipe.model;

import java.io.Serializable;

public class RegistrationBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5512877533713379543L;
	private String userName;
	private String email;
	private String password;
public RegistrationBean() {}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}


}
