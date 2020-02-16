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
@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
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
		HttpSession session = request.getSession(true);
		LoginBean lb=(LoginBean)session.getAttribute("customerBean");
		//	Step 2: Retrieve post parameter and initialize some variable
		String fullName = request.getParameter("fullName");
		String username=request.getParameter("username");
		String cellulare = (String)request.getParameter("cellulare");
		String indirizzo = (String) request.getParameter("indirizzo");
		int idUtente=Integer.parseInt((String)request.getParameter("idUtente"));
		LoginDAO srdao = new LoginDAO();
		
		// Step 3:  Update user
		boolean rb=srdao.updateUser(fullName, username, cellulare, indirizzo, idUtente);
		// login fallito da parte dell'amministratore
		if(!rb) {
			
			app.setAttribute("message", "modifica dati non andata a buon fine");
			request.getRequestDispatcher("profile.jsp").forward(request, response);
					}
		else {
			lb.setFullName(fullName);
			lb.setUsername(username);
			lb.setCellulare(cellulare);
			lb.setIndirizzo(indirizzo);
			session.setAttribute("customerBean", lb);
			session.setAttribute("message", "Dati inseriti con successo");
			request.getRequestDispatcher("profile.jsp").forward(request, response);
		}
	}
}
