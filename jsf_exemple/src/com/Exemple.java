package com;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Exemple implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int id;
	private String nom;
	private String qte;
	
	public Exemple() {
		
	}
	public Exemple(String nom, String qte) {
		super();
		this.nom = nom;
		this.qte = qte;
	}
	public Exemple(int id, String nom, String qte) {
		super();
		this.id = id;
		this.nom = nom;
		this.qte = qte;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getQte() {
		return qte;
	}
	public void setQte(String qte) {
		this.qte = qte;
	}
	
	

}
