package com.manager.recipe.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.manager.recipe.model.LoginBean;
import com.manager.recipe.model.LoginDAO;
import com.manager.recipe.model.RegistrationBean;
import com.manager.recipe.model.RegistrationDAO;

/**
 * Servlet implementation class SignUpControlServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Step 1:  Set content type header response
		response.setContentType("text/html");
		ServletContext app = getServletContext();
		//	Step 2: Retrieve post parameter and initialize some variable
		String userName = request.getParameter("username");
		String email = request.getParameter("email");
		String password = null;
		RegistrationBean rb = new RegistrationBean();
		RegistrationDAO srdao = new RegistrationDAO();
		try {
				if(request.getParameter("password").equals(request.getParameter("password2")) && request.getParameter("password")!=null) {
					password = EIC.encrypt(request.getParameter("password"));
				}
			
		}catch(NoSuchAlgorithmException ex) {
			
		}
		// Step 3:  Set Bean
		rb.setEmail(email);
		rb.setPassword(password);
		rb.setUserName(userName);
		rb.setRuolo_idRuolo(1);
		// Step 4:  Validate data filled from user customer or admin
		rb=srdao.storeUser(rb);
		// login fallito da parte dell'amministratore
		if(rb == null) {
			
			app.setAttribute("message", "registrazione non andata a buon fine");
			request.getRequestDispatcher("index.jsp").forward(request, response);
					}
		else {
			HttpSession session = request.getSession(true);
			response.sendRedirect("LogoutServlet");
		}
	}
}
