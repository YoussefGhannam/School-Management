package com.youssef.servlets;

import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet("/list_etudiant")
public class EtudiantServlet extends HttpServlet {
	
	JDBCConnection conn;

	/**
	
	/**
	 * 
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EtudiantServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EtudiantBean bean = new EtudiantBean();
        try {
            conn = new JDBCConnection();
            PrintWriter out = response.getWriter();
            response.setContentType("text/html");
			
			Statement statement = conn.connexion.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM etudiant");
			out.println("<html>");
            out.println("<head>");
            out.println("<title>Etudiant List</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Etudiant List</h2>");
			out.println("<table>");
			out.println("<thead>");
			out.println("<tr>");
			out.println("<th>CNE</th>");
			out.println("<th>Nom</th>");
			out.println("<th>Prénom</th>");
			out.println("<th>Téléphone</th>");
			out.println("<th>Date Inscription</th>");
			out.println("</tr>");
			out.println("</thead>");
			out.println("<tbody>");
			
			while (rs.next()) {
				out.println("<tr>");
				bean.setCne(rs.getString("cne"));
				bean.setNom(rs.getString("nom"));
				bean.setPrenom(rs.getString("prenom"));
				bean.setTelephone(rs.getString("telephone"));
				bean.setDateinscription(rs.getDate("date_inscription"));


				


				out.println("<td>"+bean.getCne()+"</td>");
				out.println("<td>"+bean.getNom()+"</td>");
				out.println("<td>"+bean.getPrenom()+"</td>");
				out.println("<td>"+bean.getTelephone()+"</td>");
				out.println("<td>"+bean.getDateinscription()+"</td>");
				
				out.println("</tr>");
			}
			out.println("</tbody>");
			out.println("</table>");	
			out.println("</body>");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}

}


