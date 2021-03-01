package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Etudiant extends User{

	private String codeC;
	@OneToOne
	private ChefDepartement chef;
	@OneToOne
	private Classe classe;

	public Etudiant(String nomUser, String prenomUser, String emailUser, String telUser, String codeC) {
		super(nomUser, prenomUser, emailUser, telUser);
		this.codeC = codeC;
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

	public String getCodeC() {
		return codeC;
	}

	public void setCodeC(String codeC) {
		this.codeC = codeC;
	}
	
	
}
