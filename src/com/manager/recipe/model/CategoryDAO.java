package com.manager.recipe.model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {

	public Boolean insertCategory(CategoryBean bean) {
		
	Connection con = null;
    PreparedStatement ps = null;
    int isInserted = 0;
    Boolean flag = true;
    try{  
        con=DBManager.getConnection();  
        String sqlInsert=" INSERT INTO categoria (idCategoria, nomeCategoria, descrizioneCategoria) VALUE (?, ?, ?)";
        ps=con.prepareStatement(sqlInsert);  
        ps.setInt(1, bean.getIdCategoria());
        ps.setString(2, bean.getNomeCategoria());
        ps.setString(3, bean.getDescrizioneCategoria());
        isInserted = ps.executeUpdate();
        con.close();
        if(isInserted == 0)
        	flag = false;
       
      }catch(SQLException ex) {
    	  System.out.println(ex);
      }
    
    
return flag;
	}
	
	public ArrayList<CategoryBean> findAllCategories() {
		
		Connection con = null;
	    PreparedStatement ps = null;
	    Boolean flag = true;
	    ArrayList<CategoryBean> lista=new ArrayList();
	    CategoryBean cb=new CategoryBean();
	    ResultSet rs;
	    try{  
	        con=DBManager.getConnection();  
	        String sqlFind="SELECT * FROM Categoria";
	        ps=con.prepareStatement(sqlFind);  
	        rs=ps.executeQuery();
	        con.close();
	        while(rs.next()) {
	        	cb=new CategoryBean();
	        	cb.setIdCategoria(rs.getInt("idCategoria"));
		        cb.setNomeCategoria(rs.getString("nomeCategoria"));
		        cb.setDescrizioneCategoria(rs.getString("descrizioneCategoria"));
		        lista.add(cb);
		       }
	       
	      }catch(SQLException ex) {
	    	  System.out.println(ex);
	      }
	    
	return lista;
		}
}
