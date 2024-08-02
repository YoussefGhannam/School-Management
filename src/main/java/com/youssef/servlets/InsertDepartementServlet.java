package com.youssef.servlets;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.youssef.bdd.JDBCConnection;
import com.youssef.beans.DepartementBean;
import com.youssef.beans.FiliereBean;

@WebServlet("/insert_departement")
public class InsertDepartementServlet extends HttpServlet {
	
	JDBCConnection conn;
	int statut;
	
    
	/**
	
	/**
	 * 
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InsertDepartementServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		this.getServletContext().getRequestDispatcher("/WEB-INF/departement/InsertDepart.html" ).forward( request, response );
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nom = request.getParameter("nom");
			
		try {
	        conn = new JDBCConnection();

			
			

			PreparedStatement preparedStatement = conn.connexion.prepareStatement( 
					"INSERT INTO departement (nom) VALUES(?);" );
					
					/* Remplissage des paramètres de la requête grâce aux méthodes setXXX() mises à disposition
					par l'objet PreparedStatement. */
					preparedStatement.setString( 1, nom );

					/* Exécution de la requête */
					statut = preparedStatement.executeUpdate();

	
		} catch (SQLException e) {
			
			request.setAttribute("error", e.getMessage());
			e.printStackTrace();
		}

        request.setAttribute("message", statut);

		
        
        // Set message as request attribute to pass to the JSP page
        
		
		
		
		
        request.getRequestDispatcher("/WEB-INF/departement/InsertDepart.jsp").forward(request, response);

		
		
		
	}
	
	
        
        
        
        
        // Perform search operation based on  the student ID
        // For demonstration, let's assume the search result is a String
        
        // Set the search result in request attribute
        
        // Forward the request to a JSP page to display search results
    
	
   
	

}
