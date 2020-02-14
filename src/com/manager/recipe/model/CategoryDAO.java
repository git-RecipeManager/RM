package com.manager.recipe.model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CategoryDAO {

	public Boolean insertCategory(CategoryBean bean) {
		
	Connection con = null;
    PreparedStatement ps = null;
    int isInserted = 0;
    Boolean flag = true;
    try{  
        con=DBManager.getConnection();  
        String sqlInsert=" INSERT INTO categoria (idCategoria, iconaCategoria, nomeCategoria, descrizioneCategoria) VALUE (?, ?, ?, ?)";
        ps=con.prepareStatement(sqlInsert);  
        ps.setInt(1, bean.getIdCategoria());
        ps.setString(2, bean.getIconaCategoria());
        ps.setString(3, bean.getNomeCategoria());
        ps.setString(4, bean.getDescrizioneCategoria());
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
