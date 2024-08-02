package com.youssef.servlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.youssef.bdd.JDBCConnection;
import com.youssef.beans.EtudiantBean;

@WebServlet("/searchEtudiant")
public class SearchEtudiantServlet extends HttpServlet {
	
	JDBCConnection conn;
    String studentNom;

	/**
	
	/**
	 * 
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SearchEtudiantServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher( "/WEB-INF/etudiant/RechercheEtudiant.html" ).forward( request, response );
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the student ID from the form
		EtudiantBean bean = new EtudiantBean();
		
		studentNom = request.getParameter("studentNom");
        try {
            conn = new JDBCConnection();
			Statement statement = conn.connexion.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM etudiant WHERE nom = " +"\"" + studentNom + "\"" );			
			while (rs.next()) {
					bean.setCne(rs.getString("cne"));
					bean.setNom(rs.getString("nom"));
					bean.setPrenom(rs.getString("prenom"));
					bean.setTelephone(rs.getString("telephone"));
					bean.setDateinscription(rs.getDate("date_inscription"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			request.setAttribute("error", e.getMessage());
			e.printStackTrace();
		}
        
        
        
        
        // Perform search operation based on  the student ID
        // For demonstration, let's assume the search result is a String
        
        // Set the search result in request attribute
        request.setAttribute("cne", bean.getCne());
        request.setAttribute("nom", bean.getNom());
        request.setAttribute("prenom", bean.getPrenom());
        request.setAttribute("telephone", bean.getTelephone());
        request.setAttribute("date_inscription", bean.getDateinscription());



        
        // Forward the request to a JSP page to display search results
        request.getRequestDispatcher("/WEB-INF/etudiant/RechercheEtudiant.jsp").forward(request, response);
    }
	
   
	

}
