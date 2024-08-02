package com.youssef.servlets;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.youssef.bdd.JDBCConnection;
import com.youssef.beans.DepartementBean;
import com.youssef.beans.FiliereBean;

@WebServlet("/insert_filiere")
public class InsertFiliereServlet extends HttpServlet {
	
	JDBCConnection conn;
	int statut;
	
    
	/**
	
	/**
	 * 
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InsertFiliereServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		this.getServletContext().getRequestDispatcher("/WEB-INF/filiere/InsertFiliere.html" ).forward( request, response );
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nom = request.getParameter("nom");
		DepartementBean bean2 = new DepartementBean();
		String departement = request.getParameter("departement");
			
		try {
	        conn = new JDBCConnection();
	        Statement statement = conn.connexion.createStatement();
	        ResultSet rs2 = statement.executeQuery("SELECT id_departement FROM departement WHERE  nom = " + "\"" + departement + "\"");
			while(rs2.next()) {
				bean2.setId(rs2.getInt("id_departement"));
			}
	        

			
			

			PreparedStatement preparedStatement = conn.connexion.prepareStatement( 
					"INSERT INTO filiere (id_departement, nom) VALUES(?, ?);" );
					
					/* Remplissage des paramètres de la requête grâce aux méthodes setXXX() mises à disposition
					par l'objet PreparedStatement. */
					preparedStatement.setInt( 1, bean2.getId() );
					preparedStatement.setString( 2, nom );



					/* Exécution de la requête */
					statut = preparedStatement.executeUpdate();

	
		} catch (SQLException e) {
			
			request.setAttribute("error", e.getMessage());
			e.printStackTrace();
		}

        request.setAttribute("message", statut);

		
        
        // Set message as request attribute to pass to the JSP page
        
		
		
		
		
        request.getRequestDispatcher("/WEB-INF/filiere/InsertFiliere.jsp").forward(request, response);

		
		
		
	}
	
	
        
        
        
        
        // Perform search operation based on  the student ID
        // For demonstration, let's assume the search result is a String
        
        // Set the search result in request attribute
        
        // Forward the request to a JSP page to display search results
    
	
   
	

}
