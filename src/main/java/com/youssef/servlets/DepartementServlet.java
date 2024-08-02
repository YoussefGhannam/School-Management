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
import com.youssef.beans.DepartementBean;

@WebServlet("/list_departement")
public class DepartementServlet extends HttpServlet {
	
	JDBCConnection conn;

	/**
	
	/**
	 * 
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DepartementServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DepartementBean bean = new DepartementBean();
        try {
            conn = new JDBCConnection();
            PrintWriter out = response.getWriter();
            response.setContentType("text/html");
			
			Statement statement = conn.connexion.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM departement");
			out.println("<html>");
            out.println("<head>");
            out.println("<title>Departement List</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Departement List</h2>");
			out.println("<table>");
			out.println("<thead>");
			out.println("<tr>");
			out.println("<th>ID</th>");
			out.println("<th>Nom</th>");
			out.println("</tr>");
			out.println("</thead>");
			out.println("<tbody>");
			
			while (rs.next()) {
				out.println("<tr>");
				bean.setId(rs.getInt("id_departement"));
				bean.setNom(rs.getString("nom"));
				out.println("<td>"+bean.getId()+"</td>");
				out.println("<td>"+bean.getNom()+"</td>");
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
