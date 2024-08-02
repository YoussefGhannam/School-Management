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
import com.youssef.beans.DepartementBean;

@WebServlet("/searchDepartement")
public class SearchDepartementServlet extends HttpServlet {
	
	JDBCConnection conn;
    String DepartementNom;

	/**
	
	/**
	 * 
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SearchDepartementServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher( "/WEB-INF/departement/RechercheDepartement.html" ).forward( request, response );
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the student ID from the form
		DepartementBean bean = new DepartementBean();
		DepartementNom = request.getParameter("departementNom");
        try {
            conn = new JDBCConnection();
			Statement statement = conn.connexion.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM departement WHERE nom = " +"\"" + DepartementNom + "\"" );			
			while (rs.next()) {
					bean.setId(rs.getInt("id_departement"));
					bean.setNom(rs.getString("nom"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        
        
        // Perform search operation based on  the student ID
        // For demonstration, let's assume the search result is a String
        
        // Set the search result in request attribute
        request.setAttribute("id", bean.getId());
        request.setAttribute("nom", bean.getNom());



        
        // Forward the request to a JSP page to display search results
        request.getRequestDispatcher("/WEB-INF/departement/RechercheDepartement.jsp").forward(request, response);
    }
	
   
	

}
