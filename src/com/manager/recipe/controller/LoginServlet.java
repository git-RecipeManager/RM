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




@WebServlet("/Secured")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Step 1:  Set content type header response
		response.setContentType("text/html");
		PrintWriter pw =  response.getWriter();
		//	Step 2: Retrieve post parameter and initialize some variable
		String userName = request.getParameter("user");
		String email = request.getParameter("user");
		String password = null;
		String role = request.getParameter("role");
		LoginBean sb = new LoginBean();
		LoginDAO sldao = new LoginDAO();
		Prompt pp = new Prompt();
		try {
				if(request.getParameter("password")!=null) {
					password = EIC.encrypt(request.getParameter("password"));
				}
			
		}catch(NoSuchAlgorithmException ex) {
			
		}
		// Step 3:  Set Bean
		sb.setEmail(email);
		sb.setPassword(password);
		sb.setUserName(userName);
		// Step 4:  Validate data filled from user customer or admin
		sb=sldao.validateUser(sb);
		// login fallito da parte dell'amministratore
		if(sb == null) {
			
			pp.setMessage("Passwor o Username errati");
			request.setAttribute("prompt", pp);
			request.getRequestDispatcher("WEB-INF/jsp/dashboard/login.jsp").forward(request, response);
			
			//response.sendRedirect("/extraordinary-italy.com/secured/login.jsp");
		}
		else {
			pp.setMessage("You are accessed your  private area successfully");
			HttpSession session = request.getSession(true);
			session.setAttribute("prompt", pp);
			session.setAttribute("securedBean", sb);
			session.setMaxInactiveInterval(3600);
			request.getRequestDispatcher("WEB-INF/jsp/dashboard/backend.jsp").forward(request, response);
			//response.sendRedirect("/extraordinary-italy.com/secured/backend.jsp");
		}
		
		
		
		
	}

}
