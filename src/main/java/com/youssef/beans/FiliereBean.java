
package com.youssef.beans;


public class FiliereBean implements java.io.Serializable{  
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String nom;  
private int id;



public FiliereBean(){}  
 
public void setId(int id){this.id=id;}  
public int getId(){return id;} 
public void setNom(String nom){this.nom=nom;}  
public String getNom(){return nom;}  

}  