package com.manager.recipe.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.manager.recipe.model.CategoryBean;
import com.manager.recipe.model.CategoryDAO;
import com.manager.recipe.model.IngredientBean;
import com.manager.recipe.model.IngredientDAO;
import com.manager.recipe.model.LoginBean;
import com.manager.recipe.model.RecipeBean;
import com.manager.recipe.model.RecipeDAO;
import com.manager.recipe.model.Recipe_has_IngredientDAO;


@WebServlet("/RecipeServlet")
@MultipartConfig
public class RecipeServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Step 1:  Set content type header response
				response.setContentType("text/html");
				PrintWriter pw =  response.getWriter();
				Boolean flag=true,flag2 = true,flag3=true;
				HttpSession session = request.getSession(true);
				session.setAttribute("message", null);
				request.setAttribute("messaggio", null);
	    // Step 2: get parameter
		 Part filePart = request.getPart("imgFullRicetta"); // Retrieves <input type="file" name="nomeRicetta">
		 String iconaRicetta = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
		 String nomeRicetta = request.getParameter("titoloRicetta");
		 String descrizioneRicetta = request.getParameter("descrizioneRicetta");
		 LoginBean utente=new LoginBean();
		 utente.setIdUser(1);
		 String categoria=request.getParameter("categoriaRicetta");
		 String unita_misura=request.getParameter("unita_misura");
		 String valore_misurato=request.getParameter("valore_misurato");
		 String nomeIngrediente=request.getParameter("nomeIngrediente");
		 //DA MODIFICAREEEEEEEE!!!!!!!!!!!!!!!!!!!!
		 // Step 3:  Instansio bean e dao class
		 RecipeBean bean = new RecipeBean();
		 RecipeDAO dao = new RecipeDAO();
		 IngredientBean iBean=new IngredientBean();
		 IngredientDAO iDao=new IngredientDAO();
		 Recipe_has_IngredientDAO rhiDao=new Recipe_has_IngredientDAO();
			
			// Step 4:  Set Bean
			bean.setDescrizione(descrizioneRicetta);
			bean.setImmagine(iconaRicetta);
			bean.setTitolo(nomeRicetta);
			iBean.setNome(nomeIngrediente);
			iBean.setMetrica(unita_misura);
			iBean.setQuantità(Integer.parseInt(valore_misurato));
			
			
			// Step 4: addCategory
			flag=dao.insertRecipe(bean,utente);
			flag2=iDao.insertIngredient(iBean);
			if(flag && flag2)
				flag3=rhiDao.insert(dao.findRecipeIdByTitle(bean.getTitolo()), iDao.findIngredientIdByName(iBean.getNome()));
			if(flag3) {
				session.setAttribute("message", "Ricetta inserita con successo");
				request.getRequestDispatcher("profile.jsp").forward(request, response);
				}
			else
			{
				session.setAttribute("message", "Qualcosa è andato storto! Ricetta non inserita");
				request.getRequestDispatcher("profile.jsp").forward(request, response);
			}
			
	}
}
