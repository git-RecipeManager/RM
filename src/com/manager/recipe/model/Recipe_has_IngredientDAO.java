package com.manager.recipe.model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Recipe_has_IngredientDAO {

	public Boolean insert(int idRicetta, int idIngrediente) {
		
	Connection con = null;
    PreparedStatement ps = null;
    int isInserted = 0;
    Boolean flag = true;
    try{  
        con=DBManager.getConnection();  
        String sql=" INSERT INTO Ricetta_has_Ingrediente VALUES (?, ?)";
        ps=con.prepareStatement(sql); 
        ps.setInt(1, idRicetta);
        ps.setInt(2, idIngrediente);
        isInserted = ps.executeUpdate();
        con.close();
        if(isInserted == 0)
        	flag = false;
       
      }catch(SQLException ex) {
    	  System.out.println(ex);
      }
    
    
return flag;
	}
}
