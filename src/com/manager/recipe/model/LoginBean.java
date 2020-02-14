package com.manager.recipe.model;

import java.io.Serializable;

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
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getSurname() {
	return surname;
}
public void setSurname(String surname) {
	this.surname = surname;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public void setTelefono1(String telefono1) {	
	this.telefono1 = telefono1;
}
public String getTelefono1() {	
	return this.telefono1;
}
public void setTelefono2(String telefono2) {	
	this.telefono2 = telefono2;
}
public String getTelefono2() {	
	return this.telefono2;
}
public void setIndirizzo(String indirizzo) {	
	this.indirizzo = indirizzo;
}
public String getIndirizzo() {	
	return this.indirizzo;
}
public String getCittaIstat() {
	return cittaIstat;
}
public void setCittaIstat(String cittaIstat) {
	this.cittaIstat = cittaIstat;
}
private int idUser;
private String name;
private String surname;
private String email;
private String role;
private String password;
private String userName;
private String telefono1;
private String telefono2;
private String indirizzo;
private String cittaIstat;


}
