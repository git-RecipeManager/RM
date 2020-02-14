package com.manager.recipe.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAO {

	// Retrieve user data 
	public LoginBean getUser(String email, String password) {
		  	Connection con = null;
		    PreparedStatement ps = null;
		    ResultSet rs  = null;
		    LoginBean sb= new LoginBean();
		    try{  
		        con=DBManager.getConnection();  
		        ps=con.prepareStatement("SELECT * FROM cliente, datianagrafici where email=? and password=?");  
		        ps.setString(1, email);
		        ps.setString(2, password);
		        rs=ps.executeQuery();
		        while(rs.next()){
		        	sb.setIdUser(Integer.parseInt(rs.getString("idCliente")));
		        	sb.setName(rs.getString("nome"));
		        	sb.setSurname(rs.getString("cognome"));
		        	sb.setEmail(rs.getString("email"));
		        	sb.setRole(rs.getString("ruolo"));
		        	sb.setUserName(rs.getString("username"));
		        	sb.setPassword(rs.getString("password"));
		        
		        }
		      }catch(Exception ex) {
		    	  System.out.println(ex);
		      }
		    
		    
		return sb;
		
	}
	
	public LoginBean validateUser(LoginBean sb) {
		Connection con = null;
	    PreparedStatement ps = null;
	    ResultSet rs  = null;
	    String email = sb.getEmail();
	    String password = sb.getPassword();
	    String userName = sb.getUserName();
	    String role = sb.getRole();
	    String nome = sb.getName();
	    String cognome = sb.getSurname();
	    try{  
	    	
	        con=DBManager.getConnection(); 
	        String sql ="SELECT * FROM Cliente INNER JOIN datianagrafici ON  cliente.email = ?";
	        ps=con.prepareStatement(sql);  
	        ps.setString(1, sb.getEmail());
	        rs=ps.executeQuery();
	        if(rs.next()){
	        	System.out.println(rs.getString("password"));
	        	System.out.println(password);
	        	System.out.println(rs.getString("email"));
	        	System.out.println(email);
	        	if((rs.getString("password").equals(password) &&rs.getString("email").equals(email)) ) {
	        		System.out.println(rs.getInt("idCliente"));
		        	System.out.println(rs.getString("nome"));
		        	System.out.println(rs.getString("cognome"));
		        	System.out.println(rs.getString("ruolo"));
		        	System.out.println(rs.getString("userName"));
		        	System.out.println(rs.getString("password"));
		        	sb.setIdUser(rs.getInt("idCliente"));
		        	sb.setName(rs.getString("nome"));
		        	sb.setSurname(rs.getString("cognome"));
		        	sb.setRole(rs.getString("ruolo"));
		        	sb.setUserName(rs.getString("userName"));
		        	sb.setPassword(rs.getString("password"));
		        	sb.setTelefono1(rs.getString("telefono1"));
		        	sb.setTelefono2(rs.getString("telefono2"));
		        	sb.setIndirizzo(rs.getString("indirizzo"));
		        	 return sb;
	        	}
	        	
	        	  	
	        }
	       
	       
		
	    }catch(Exception ex) {
	    	System.out.println(ex);
	    }
		return null;
	}
}
