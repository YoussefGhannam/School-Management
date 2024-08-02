
package com.youssef.beans;

import java.util.Date;

public class EtudiantBean implements java.io.Serializable{  
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String cne;  
private String nom;  
private String prenom;
private String telephone;  
private Date date_inscription;  


public EtudiantBean(){}  
public void setCne(String cne){this.cne=cne;}  
public String getCne(){return cne;}  
public void setNom(String nom){this.nom=nom;}  
public String getNom(){return nom;}  
public void setPrenom(String prenom){this.prenom=prenom;}  
public String getPrenom(){return prenom;} 
public void setTelephone(String telephone){this.telephone=telephone;}  
public String getTelephone(){return telephone;} 
public void setDateinscription(Date date_inscription){this.date_inscription=date_inscription;}  
public Date getDateinscription(){return date_inscription;} 
}  