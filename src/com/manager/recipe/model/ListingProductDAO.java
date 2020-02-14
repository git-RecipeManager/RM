package com.manager.recipe.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ListingProductDAO {

	public ArrayList<ListingProductBean> retriveProduct(ListingProductBean bean) {
		Connection con = null;
	    PreparedStatement ps = null;
	    ResultSet rs  = null;
	    ArrayList<ListingProductBean> beanList = new ArrayList<ListingProductBean>();
	   
	    try{  
	    	
	        con=DBManager.getConnection(); 
	        String sql ="SELECT * FROM prodotto";
	        ps=con.prepareStatement(sql);  
	        rs=ps.executeQuery();
	        while(rs.next()){
	        		System.out.println(rs.getRow());
		        	bean.setIdProdotto(rs.getInt("idProdotto"));
		        	bean.setNomeProdotto(rs.getString("nomeProdotto"));
		        	bean.setDescrizioneBreveProdotto(rs.getString("descrizioneBreveProdotto"));
		        	bean.setDescrizioneDettagliataProdotto(rs.getString("descrizioneDettagliataProdotto"));
		        	bean.setImgThumbProdotto(rs.getString("imgThumbProdotto"));
		        	bean.setImgFullProdotto(rs.getString("imgFullProdotto"));
		        	bean.setPrezzoProdotto(rs.getDouble("prezzoProdotto"));
		        	bean.setCategoria_idCategoria(rs.getInt("Categoria_idCategoria"));
		        	bean.setUnita_misura(rs.getString("unita_misura"));
		        	bean.setValore_misurato(rs.getInt("valore_misurato"));
		        	
		        	beanList.add(bean);
		        	 
	        	}
	       
	        
	    }catch(Exception ex) {
	    	System.out.println(ex);
	    }
		return beanList;
	}

}
