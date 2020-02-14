package com.manager.recipe.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BackLogout
 * 
 *Raccoglie una richiesta da una pagina jsp di logout e lo 
 *fa invaidando la sessione che manteneva attivao il login
 */
@WebServlet(description = "logaut servlet for backend administration area", urlPatterns = { "/BackLogout" })
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		  HttpSession session=request.getSession();  
          session.invalidate(); 
          request.getRequestDispatcher("WEB-INF/jsp/dashboard/login.jsp").forward(request, response);
	}

}
