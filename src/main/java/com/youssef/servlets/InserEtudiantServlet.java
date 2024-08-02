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

@WebServlet("/insert_etudiant")
public class InserEtudiantServlet extends HttpServlet {
	
	JDBCConnection conn;
	int statut;
	DepartementBean bean1 = new DepartementBean();
	DepartementBean bean2 = new DepartementBean();
    
	/**
	
	/**
	 * 
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InserEtudiantServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		try {
	        conn = new JDBCConnection();
			Statement statement = conn.connexion.createStatement();
			ResultSet rs1 = statement.executeQuery("SELECT * FROM departement");
			while(rs1.next()) {
				bean1.setNom(rs1.getString("nom"));
			} 
			ResultSet rs2 = statement.executeQuery("SELECT * FROM filiere");
			while(rs2.next()) {
				bean2.setNom(rs2.getString("nom"));
			}
			conn.connexion.close();
	
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("nom_dep", bean1.getNom());
		request.setAttribute("nom_filiere", bean2.getNom());
		


		
		this.getServletContext().getRequestDispatcher( "/WEB-INF/etudiant/InsertEtudiant.html" ).forward( request, response );
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cne = request.getParameter("cne");
		String dep = request.getParameter("dep");
		String filiere = request.getParameter("filiere");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String telephone = request.getParameter("telephone");
		
		
		
		
		try {
	        conn = new JDBCConnection();

			Statement statement = conn.connexion.createStatement();
			Statement statement1 = conn.connexion.createStatement();
			ResultSet rs2 = statement1.executeQuery("SELECT id_filiere FROM filiere WHERE nom = " + "\"" + filiere + "\"");
			while(rs2.next()) {
				bean2.setId(rs2.getInt("id_filiere"));
			}
			ResultSet rs1 = statement.executeQuery("SELECT id_departement FROM departement WHERE  nom = " + "\"" + dep + "\"");
			while(rs1.next()) {
				bean1.setId(rs1.getInt("id_departement"));
			}
			

			PreparedStatement preparedStatement = conn.connexion.prepareStatement( 
					"INSERT INTO etudiant (cne, nom, prenom, id_departement, id_filiere, telephone, date_inscription) VALUES(?, ?, ?, ?, ?, ?, ?);" );
					
					/* Remplissage des paramètres de la requête grâce aux méthodes setXXX() mises à disposition
					par l'objet PreparedStatement. */
					preparedStatement.setString( 1,  cne );
					preparedStatement.setString( 2, nom );
					preparedStatement.setString( 3, prenom );
					preparedStatement.setInt( 4, bean1.getId());
					preparedStatement.setInt( 5, bean2.getId()); //bean2.getId()
					preparedStatement.setString(6,  telephone );
					preparedStatement.setDate(7, java.sql.Date.valueOf(java.time.LocalDate.now()));

					/* Exécution de la requête */
					statut = preparedStatement.executeUpdate();

	
		} catch (SQLException e) {
			
			request.setAttribute("error", e.getMessage());
			e.printStackTrace();
		}

        request.setAttribute("message", statut);

		
        
        // Set message as request attribute to pass to the JSP page
        
		
		
		
		
        request.getRequestDispatcher("/WEB-INF/etudiant/InsertEtudiant.jsp").forward(request, response);

		
		
		
	}
	
	
        
        
        
        
        // Perform search operation based on  the student ID
        // For demonstration, let's assume the search result is a String
        
        // Set the search result in request attribute
        
        // Forward the request to a JSP page to display search results
    
	
   
	

}
