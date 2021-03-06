package com.manager.recipe.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.manager.recipe.controller.EIC;

public class LoginDAO {

	// Retrieve user data 
	public boolean updateUser(String fullName, String cellulare, String indirizzo, int idUtente, String password, String password2) {
		  	Connection con = null;
		    PreparedStatement ps = null;
		    int rs  = 0;
		    if((!fullName.equals("null") || !(fullName.length()<=3) ||
		       !cellulare.equals("null")|| !cellulare.contains("[a-zA-Z]+")||
		       !indirizzo.equals("null")))
		    try{    
		        con=DBManager.getConnection(); 
		        if(password!=null && password!="" && password.equals(password2)) {
		        ps=con.prepareStatement("UPDATE Utente SET fullname=?, password=?, cellulare=?, indirizzo=? where idUtente=?");
		        ps.setString(1, fullName);
		        ps.setString(2, password);
		        ps.setString(3, cellulare);
		        ps.setString(4, indirizzo);
		        ps.setInt(5, idUtente);
		        rs=ps.executeUpdate();
		        }
		        else {
		        	ps=con.prepareStatement("UPDATE Utente SET fullname=?, cellulare=?, indirizzo=? where idUtente=?");
			        ps.setString(1, fullName);
			        ps.setString(2, cellulare);
			        ps.setString(3, indirizzo);
			        ps.setInt(4, idUtente);
			        rs=ps.executeUpdate();
		        }
		        if(rs!=0) return true;

		    }
		      catch(Exception ex) {
		    	  ex.printStackTrace();
		    }
		    return false;
		
	}
	
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
	        };
	        rs=ps.executeQuery();
	        if(rs.next()){
	        	if(rs.getString("password").equals(password)) {
	        		if(rs.getString("email").equals(email)||rs.getString("username").equals(username)) {
		        	sb.setIdUser(rs.getInt("idUtente"));
		        	sb.setFullName(rs.getString("fullName"));
		        	sb.setUsername(rs.getString("username"));
		        	sb.setEmail(rs.getString("email"));
		        	sb.setPassword(rs.getString("password"));
		        	if(rs.getString("indirizzo")!=null)
		        	sb.setIndirizzo(rs.getString("indirizzo"));
		        	if(rs.getString("cellulare")!=null)
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
	
	public boolean checkClone(String username)
	{
		Connection con = null;
	    PreparedStatement ps = null;
	    ResultSet rs  = null;
	    
	    
		try {
			con=DBManager.getConnection();
	        String sql="";
	        sql ="SELECT * FROM Utente WHERE username = ?";
	        ps=con.prepareStatement(sql);  
	        ps.setString(1, username);
	        rs=ps.executeQuery();
	        if(rs.next()) return true;
	        else return false;
		} catch (SQLException e) {
			
			e.printStackTrace();
		} 
		return false;

	}
}
