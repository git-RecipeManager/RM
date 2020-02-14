package com.manager.recipe.controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.manager.recipe.model.CustomerLoginDAO;
import com.manager.recipe.model.LoginBean;


/**
 * Servlet implementation class CustomerLoginServlet
 */
@WebServlet("/CustomerLoginServlet")
public class CustomerLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Step 1:  Set content type header response
				response.setContentType("text/html");
				//	Step 2: Retrieve post parameter and initialize some variable
				String email = request.getParameter("email");
				String role = request.getParameter("role");
				String password = null;
				LoginBean sb = new LoginBean();
				CustomerLoginDAO dao = new CustomerLoginDAO();
				ServletContext app = getServletContext();
				try {
						if(request.getParameter("password")!=null) {
							password = EIC.encrypt(request.getParameter("password"));
						}
					
				}catch(NoSuchAlgorithmException ex) {
					
				}
				// Step 3:  Set bean object

				sb.setEmail(email);
				sb.setPassword(password);
				sb.setRole(role);
				// Step 4:  Validate data filled from user customer or admin
				sb=dao.validateCustomer(sb);// in to CustomerLOginDAO class
				if(sb == null) {
					app.setAttribute("message", "user o password errata");
					

				}else {
					HttpSession session = request.getSession(true);
					session.setAttribute("customerBean", sb);
					session.setAttribute("message","Benvenuto "+sb.getEmail().split("@")[0]);
					request.getRequestDispatcher("WEB-INF/jsp/site/index.jsp").forward(request, response);
					
				}
	   }// end post

}
