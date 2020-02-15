package com.manager.recipe.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAO {

	// Retrieve user data 
	/*public LoginBean getUser(String email, String password) {
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
		
	}*/
	
	public LoginBean validateUser(LoginBean sb) {
		Connection con = null;
	    PreparedStatement ps = null;
	    ResultSet rs  = null;
	    String email = sb.getEmail();
	    String username=sb.getUsername();
	    String password = sb.getPassword();
	    try{  
	    	
	        con=DBManager.getConnection(); 
	        String sql="";
	        if(email!=null && email!="") {
	        sql ="SELECT * FROM Utente WHERE email = ?";
	        ps=con.prepareStatement(sql);  
	        ps.setString(1, sb.getEmail());
	        }
	        else if(username!=null && username!=""){
	        	sql ="SELECT * FROM Utente WHERE username = ?";
	        	ps=con.prepareStatement(sql);  
		        ps.setString(1, sb.getUsername());
	        }else throw new Exception("Eccezioneee");
	        rs=ps.executeQuery();
	        if(rs.next()){
	        	System.out.println(rs.getString("password"));
	        	System.out.println(password);
	        	System.out.println(rs.getString("email"));
	        	System.out.println(email);
	        	if(rs.getString("password").equals(password)) {
	        		if(rs.getString("email").equals(email)||rs.getString("username").equals(username)) {
	        		System.out.println(rs.getInt("idUtente"));
		        	System.out.println(rs.getString("fullName"));
		        	System.out.println(rs.getString("Ruolo_idRuolo"));
		        	System.out.println(rs.getString("password"));
		        	sb.setIdUser(rs.getInt("idUtente"));
		        	sb.setFullName(rs.getString("fullName"));
		        	sb.setEmail(rs.getString("email"));
		        	sb.setPassword(rs.getString("password"));
		        	if(rs.getDate("dataDiNascita")!=null)
		        	sb.setDataDiNascita(rs.getDate("dataDiNascita"));
		        	if(rs.getDate("cellulare")!=null)
		        	sb.setCellulare(rs.getString("cellulare"));
		        	sb.setRole(rs.getInt("Ruolo_idRuolo"));
		        	return sb;
	        	}
	        	
	        	}
	        }
	    }catch(Exception ex) {
	    	ex.printStackTrace();
	    }
		return null;
	}
}
