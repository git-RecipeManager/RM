package com.manager.recipe.controller;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DashManagmentServlet
 */
@WebServlet("/DashManagmentServlet")
public class DashManagmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	
	// utility gets a file and return a string data which serve to set up for
	//  request.setAttibute(dash_view, data") method.
	// That serve to customize the view of the back-end area on bases of the get request that was been done
	private String readFile(String filename) throws IOException {
        // get a servlet context obj for call getResourseAsStream(path) method
		ServletContext context = getServletContext();
		
		// make a obj  for manipulate long string by string part
        StringBuilder content = new StringBuilder();
        // string part --> html line
        String html;
        // make an inputStream  from a resource then  we read on it
        InputStream is = context.getResourceAsStream(filename);
        if (is != null) {
        	// patterm decorattion
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader reader = new BufferedReader(isr);
            // We read the file line by line and append each one of it to prev
            while ((html = reader.readLine()) != null) {
                content.append(html);
                content.append("\n");
            }
        }
        return content.toString();
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//when get request contain add_product parameter show add_product.html view
		if(request.getParameter("dashboard") != null && request.getParameter("dashboard").equals("add_product"))
		{
			
			String html = this.readFile("/WEB-INF/jsp/dashboard/add_product.html");
			request.setAttribute("dash_view",html);
			request.setAttribute("maskDescription","Maschera per l'inserimento di un prodotto nel database");
			request.getRequestDispatcher("WEB-INF/jsp/dashboard/backend.jsp").forward(request, response);
		}
		if(request.getParameter("dashboard") != null && request.getParameter("dashboard").equals("add_category"))
		{
			
			String html = this.readFile("/WEB-INF/jsp/dashboard/addCategoryForm.html");
			request.setAttribute("dash_view",html);
			request.setAttribute("maskDescription","Maschera per l'inserimento di una categoria nel database");
			request.getRequestDispatcher("WEB-INF/jsp/dashboard/backend.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("WEB-INF/jsp/dashboard/backend.jsp").forward(request, response);

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.getRequestDispatcher("WEB-INF/jsp/dashboard/backend.jsp").forward(request, response);
	}

}
