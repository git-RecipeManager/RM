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




@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Step 1:  Set content type header response
		response.setContentType("text/html");
		ServletContext app = getServletContext();
		//	Step 2: Retrieve post parameter and initialize some variable
		String login = request.getParameter("user");
		String password = null;
		LoginBean sb = new LoginBean();
		LoginDAO sldao = new LoginDAO();
		try {
				if(request.getParameter("password")!=null) {
					password = EIC.encrypt(request.getParameter("password"));
				}
			
		}catch(NoSuchAlgorithmException ex) {
			
		}
		// Step 3:  Set Bean
		if(login.contains("@"))
		sb.setEmail(login);
		else sb.setUsername(login);
		sb.setPassword(password);
		// Step 4:  Validate data filled from user customer or admin
		sb=sldao.validateUser(sb);
		// login fallito da parte dell'amministratore
		if(sb == null) {
				app.setAttribute("message", "user o password errata");
				request.getRequestDispatcher("index.jsp").forward(request, response);

			}else {
				HttpSession session = request.getSession(true);
				session.setAttribute("customerBean", sb);
				if(sb.getUsername()!=null && sb.getUsername()!="")
				session.setAttribute("message","Benvenuto "+sb.getUsername()+"!");
				else session.setAttribute("message","Benvenuto "+sb.getEmail().split("@")[0]+"!");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		
		
	}

}
