package com.manager.recipe.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.manager.recipe.model.CategoryBean;
import com.manager.recipe.model.CategoryDAO;
import com.manager.recipe.model.LoginBean;
import com.manager.recipe.model.LoginDAO;

/**
 * Servlet implementation class Category
 */
@WebServlet("/Category")
@MultipartConfig
public class Category extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Step 1:  Set content type header response
				response.setContentType("text/html");
				PrintWriter pw =  response.getWriter();
				Boolean flag = true;
	    // Step 2: get parameter
		 Part filePart = request.getPart("nomeCategoria"); // Retrieves <input type="file" name="nomeCategoria">
		 String iconaCategoria = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
		 String nomeCategoria = request.getParameter("nomeCategoria");
		 String descrizioneCategoria = request.getParameter("descrizioneCategoria");
		 
		 // Step 3:  Instansio bean e dao class
		 CategoryBean bean = new CategoryBean();
			CategoryDAO dao = new CategoryDAO();
			
			
			// Step 4:  Set Bean
			bean.setDescrizioneCategoria(descrizioneCategoria);
			bean.setIconaCategoria(iconaCategoria);
			bean.setNomeCategoria(nomeCategoria);
			
			// Step 4: addCategory
			flag=dao.insertCategory(bean);
			if(flag)
				pw.print("<p id='categoryMessage'>Inserimento avvenuto con successo</p>");
			else
				pw.print("<p id='categoryMessage'>Errore operazione di inserimento avvenuto con successo</p>");

				
			
	}

}
 