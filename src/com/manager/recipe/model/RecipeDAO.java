package com.manager.recipe.model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RecipeDAO {

	public Boolean insertRecipe(RecipeBean bean, LoginBean utente) {
		
	Connection con = null;
    PreparedStatement ps = null;
    int isInserted = 0;
    Boolean flag = true;
    try{  
        con=DBManager.getConnection();  
        String sqlInsert=" INSERT INTO Ricetta (immagine, titolo, descrizione, Utente_idUtente) VALUES (?, ?, ?, ?)";
        ps=con.prepareStatement(sqlInsert);  
        ps.setString(1, bean.getImmagine());
        ps.setString(2, bean.getTitolo());
        ps.setString(3, bean.getDescrizione());
        ps.setInt(4, utente.getIdUser());
        isInserted = ps.executeUpdate();
        con.close();
        if(isInserted == 0)
        	flag = false;
       
      }catch(SQLException ex) {
    	  System.out.println(ex);
      }
    
    
return flag;
	}
	
	public int findRecipeIdByTitle(String title) {
		
		Connection con = null;
	    PreparedStatement ps = null;
	    int id = 0;
	    Boolean flag = true;
	    try{  
	        con=DBManager.getConnection();  
	        String sqlFind=" SELECT * from Ricetta where ricetta.titolo=?";
	        ps=con.prepareStatement(sqlFind);  
	        ps.setString(1, title);
	       	ResultSet rs = ps.executeQuery();
	       	if(rs.next())
	        id=rs.getInt("idRicetta");
	       
	      }catch(SQLException ex) {
	    	  System.out.println(ex);
	      }
	    
	    
	return id;
		}
	
public ArrayList<RecipeBean> findAllRecipes() {
		
		Connection con = null;
	    PreparedStatement ps = null;
	    int id = 0;
	    Boolean flag = true;
	    RecipeBean rb;
	    ArrayList<RecipeBean> lista=new ArrayList<RecipeBean>();
	    try{  
	        con=DBManager.getConnection();  
	        String sqlFind=" SELECT * from Ricetta";
	        ps=con.prepareStatement(sqlFind);  
	       	ResultSet rs = ps.executeQuery();
	       	while(rs.next())
	        {
	       		rb=new RecipeBean();
	       		rb.setIdRicetta(rs.getInt("idRicetta"));
	       		rb.setTitolo(rs.getString("titolo"));
	       		rb.setDescrizione(rs.getString("descrizione"));
	       		rb.setImmagine(rs.getString("immagine"));
	       		rb.setIdUtente(rs.getInt("Utente_idUtente"));
	       		lista.add(rb);
	        }
	      }catch(SQLException ex) {
	    	  System.out.println(ex);
	      }
	    return lista;
}
}
