package com.manager.recipe.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manager.recipe.model.DBManager;

/**
 * Servlet implementation class Province
 */
@WebServlet("/Province")
public class Province extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Province() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		Connection con = null;
	    PreparedStatement ps = null;
	    ResultSet rs  = null;
	    String prov = request.getParameter("provincia");
	    if(prov == null) {
		    System.out.println("non sono entrato");

	    	request.getRequestDispatcher("WEB-INF/jsp/site/comuni.jsp").forward(request, response);
	    }
	    PrintWriter out = response.getWriter();
	    try{  
		    System.out.println(" sono entrato");

	        con=DBManager.getConnection();  
	        ps=con.prepareStatement("select comune from citta where provincia=?");  
	        ps.setString(1, prov);
	        rs=ps.executeQuery();
	        while(rs.next()){
	        	out.println("<option>"+rs.getString("comune")+"</option>\n");
	        
	        }

	      }catch(Exception ex) {
	    	  System.out.println(ex);
	      }
	    
	}

}
