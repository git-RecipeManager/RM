package com.manager.recipe.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Home
 */
@WebServlet("")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
		
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			//when get request contain add_product parameter show add_product.html view
			if(request.getParameter("page") == null )
			{		
				System.out.println("1");
				request.getRequestDispatcher("WEB-INF/jsp/site/index.jsp").forward(request, response);
			}
			else if(request.getParameter("page") != null && request.getParameter("page").equals("profile"))
			{		System.out.println("2");
				request.getRequestDispatcher("WEB-INF/jsp/site/profile.jsp").forward(request, response);
			}else {
				System.out.println("3");
				request.getRequestDispatcher("WEB-INF/jsp/site/index.jsp").forward(request, response);

			}
	}

}
