package com.youssef.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JDBCConnection {
	String url = "jdbc:mysql://localhost:3306/app_jee";
		
	 String utilisateur = "jav1";
		
	 String motDePasse = "ldw_eE";
	public Connection connexion = null;
	public String state = null;
	
	public JDBCConnection() {
		try {

			connexion = DriverManager.getConnection( url, utilisateur, motDePasse );
			state = "connected";
			
			} catch ( SQLException e ) {
				System.out.println(e.getMessage());
				state = "unconnected";

			}
	}
	
	
	
	
	
	
}