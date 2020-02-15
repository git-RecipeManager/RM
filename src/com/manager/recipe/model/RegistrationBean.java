package com.manager.recipe.model;

import java.io.Serializable;
import java.time.LocalDate;

public class RegistrationBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5512877533713379543L;
	private String userName;
	private String email;
	private String password;
	private LocalDate dataDiNascita;
	private String cellulare;
	private int ruolo_idRuolo;
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
public LocalDate getDataDiNascita() {
	return dataDiNascita;
}
public void setDataDiNascita(LocalDate dataDiNascita) {
	this.dataDiNascita = dataDiNascita;
}
public String getCellulare() {
	return cellulare;
}
public void setCellulare(String cellulare) {
	this.cellulare = cellulare;
}
public int getRuolo_idRuolo() {
	return ruolo_idRuolo;
}
public void setRuolo_idRuolo(int ruolo_idRuolo) {
	this.ruolo_idRuolo = ruolo_idRuolo;
}
public static long getSerialversionuid() {
	return serialVersionUID;
}


}
