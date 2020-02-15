package com.manager.recipe.model;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

public class LoginBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8334674121358969002L;
	
public LoginBean() {}
public int getIdUser() {
	return idUser;
}
public void setIdUser(int idUser) {
	this.idUser = idUser;
}
public String getFullName() {
	return fullName;
}
public void setFullName(String fullName) {
	this.fullName = fullName;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public int getRole() {
	return role;
}
public void setRole(int role) {
	this.role = role;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public LocalDate getDataDiNascita() {
	return dataDiNascita;
}
public void setDataDiNascita(Date dataDiNascita) {
	this.dataDiNascita = dataDiNascita.toLocalDate();
}
public void setCellulare(String cellulare) {	
	this.cellulare = cellulare;
}
public String getCellulare() {	
	return this.cellulare;
}

private int idUser;
private String fullName;
private String username;
private String email;
private String password;
private String cellulare;
private LocalDate dataDiNascita;
private int role;
}
