package com.manager.recipe.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CustomerLoginDAO {

	
	public LoginBean validateCustomer(LoginBean sb) {
		Connection con = null;
	    PreparedStatement ps = null;
	    ResultSet rs  = null;
	    String password = sb.getPassword();
	    try{  
	    	
	        con=DBManager.getConnection(); 
	        String sql ="SELECT * FROM Cliente INNER JOIN datianagrafici ON  cliente.email = ?";
	        ps=con.prepareStatement(sql);  
	        ps.setString(1, sb.getEmail());
	        rs=ps.executeQuery();
	        while(rs.next()) {
	        	if(password.equals(rs.getString("password"))) {
	        		
	        		sb.setRole(rs.getString("ruolo"));
	        		sb.setUserName(rs.getString("userName"));
	        		sb.setEmail(rs.getString("email"));
	        		sb.setName(rs.getString("nome"));
	        		sb.setSurname(rs.getString("cognome"));
	        		sb.setIdUser(rs.getInt("idCliente"));
	        		sb.setTelefono1(rs.getString("telefono1"));
	        		sb.setTelefono2(rs.getString("telefono2"));
	        		sb.setCittaIstat(rs.getString("Citta_istat"));
	        		return sb;
	        	}
	        }
	    }catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}
