package com.manager.recipe.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CostumerLogout
 */
@WebServlet("/CostumerLogout")
public class CostumerLogout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
  
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		  HttpSession session=request.getSession();  
        session.invalidate(); 
        request.getRequestDispatcher("WEB-INF/jsp/site/index.jsp").forward(request, response);
	}

	

}
