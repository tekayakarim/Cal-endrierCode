package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Etudiant extends JwtUser{

	
	@OneToOne
	private ChefDepartement chef;
	@OneToOne
	private Classe classe;

	public Etudiant(String nomUser, String prenomUser, String emailUser, String telUser) {
		super(nomUser, prenomUser, emailUser, telUser);
		
	}

	public Etudiant() {
		super();
		
	}
	public Etudiant(ChefDepartement chef) {
		super();
		setChef(chef);
	}
	public ChefDepartement getChef() {
		return chef;
	}

	public void setChef(ChefDepartement chef) {
		this.chef = chef;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}


	
	
}
