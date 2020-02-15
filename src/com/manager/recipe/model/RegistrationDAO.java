package com.manager.recipe.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RegistrationDAO {
	
	public RegistrationBean storeUser(RegistrationBean rb) {
		int result=0;
	  	Connection con = null;
	    PreparedStatement ps = null;
	    ResultSet rs  = null;
	    try{  
	        con=DBManager.getConnection();  
	        ps=con.prepareStatement("INSERT INTO Utente(username,email,password,Ruolo_idRuolo) VALUES (?,?,?,?)");  
	        ps.setString(1, rb.getUserName());
	        ps.setString(2, rb.getEmail());
	        ps.setString(3, rb.getPassword());
	        ps.setInt(4, rb.getRuolo_idRuolo());
	        result=ps.executeUpdate();
	      }catch(Exception ex) {
	    	  System.out.println(ex);
	      }
	    
	    if(result!=0) return rb;
	    else return null;
	
}
}
