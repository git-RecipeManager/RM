package com.manager.recipe.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manager.recipe.model.ListingProductBean;
import com.manager.recipe.model.ListingProductDAO;

/**
 * Servlet implementation class ListingProduct
 */
@WebServlet("/ListingProduct")
public class ListingProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Step 1:  Set content type header response
				response.setContentType("text/html");
				PrintWriter pw =  response.getWriter();
				//	Step 2: Retrieve post parameter 
				String listBy = request.getParameter("listBy");
				ListingProductBean  bean = new ListingProductBean();
				ListingProductDAO  dao = new ListingProductDAO();
				ArrayList<ListingProductBean> beanList = new ArrayList<ListingProductBean>();
				beanList = dao.retriveProduct(bean);
				request.setAttribute("beanList", beanList);
				request.getServletContext().setAttribute("beanList", beanList);
				
				request.getRequestDispatcher("WEB-INF/jsp/site/lista-prodotti.jsp").forward(request, response);
				
				
				
	}

	

}
