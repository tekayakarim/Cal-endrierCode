package com.example.demo.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Enseignant extends User{


	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Seance> lstSeance;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Classe> lstClasse;
	
	@OneToOne
	private ChefDepartement chef;

	public Enseignant() {
		super();
	
	}

	public Enseignant(String nomUser, String prenomUser, String emailUser, String telUser) {
		super(nomUser, prenomUser, emailUser, telUser);
	}


	public List<Seance> getLstSeance() {
		return lstSeance;
	}

	public void setLstSeance(List<Seance> lstSeance) {
		this.lstSeance = lstSeance;
	}

	public List<Classe> getLstClasse() {
		return lstClasse;
	}

	public void setLstClasse(List<Classe> lstClasse) {
		this.lstClasse = lstClasse;
	}

	public ChefDepartement getChef() {
		return chef;
	}

	public void setChef(ChefDepartement chef) {
		this.chef = chef;
	}

	
	
	
}
