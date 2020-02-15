package com.manager.recipe.model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IngredientDAO {

	public Boolean insertIngredient(IngredientBean bean) {
		
	Connection con = null;
    PreparedStatement ps = null;
    int isInserted = 0;
    Boolean flag = true;
    try{  
        con=DBManager.getConnection();  
        String sqlInsert=" INSERT INTO ingrediente (nome, metrica, quantita) VALUES (?, ?, ?)";
        ps=con.prepareStatement(sqlInsert); 
        ps.setString(1, bean.getNome());
        ps.setString(2, bean.getMetrica());
        ps.setInt(3, bean.getQuantità());
        isInserted = ps.executeUpdate();
        con.close();
        if(isInserted == 0)
        	flag = false;
        
      }catch(SQLException ex) {
    	  System.out.println(ex);
      }

return flag;
	}
public int findIngredientIdByName(String name) {
		
		Connection con = null;
	    PreparedStatement ps = null;
	    int id = 0;
	    Boolean flag = true;
	    try{  
	        con=DBManager.getConnection();  
	        String sqlFind=" SELECT * from Ingrediente where ingrediente.nome=?";
	        ps=con.prepareStatement(sqlFind);  
	        ps.setString(1, name);
	       	ResultSet rs = ps.executeQuery();
	       	if(rs.next());
	        id=rs.getInt("idIngrediente");
	       
	      }catch(SQLException ex) {
	    	  System.out.println(ex);
	      }
	    
	    
	return id;
		}
}
