package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class Seance {
	@Id
	private String codeS;
	private String heureDeb,heureFin,date;
	private String type;
	private String jour;
	
	@OneToOne
	private Classe cl;
	
	@OneToOne
	private ChefDepartement chef;
	
	@OneToOne
	private Modulee module;
	
	@OneToOne
	private Enseignant enseignant;
	
	public Seance(String codeS, String heureDeb, String heureFin, String date
			,String type,String jour) {
		super();
		this.codeS = codeS;
		this.heureDeb = heureDeb;
		this.heureFin = heureFin;
		this.date = date;
		this.type=type;
		this.setJour(jour);
	}
	

	public Seance() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Classe getCl() {
		return cl;
	}


	public void setCl(Classe cl) {
		this.cl = cl;
	}


	public Enseignant getEnseignant() {
		return enseignant;
	}


	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}


	public ChefDepartement getChef() {
		return chef;
	}

	public void setChef(ChefDepartement chef) {
		this.chef = chef;
	}


	public String getCodeS() {
		return codeS;
	}

	public void setCodeS(String codeS) {
		this.codeS = codeS;
	}


	public String getHeureDeb() {
		return heureDeb;
	}

	public void setHeureDeb(String heureDeb) {
		this.heureDeb = heureDeb;
	}

	public String getHeureFin() {
		return heureFin;
	}

	public void setHeureFin(String heureFin) {
		this.heureFin = heureFin;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}


	public Modulee getModule() {
		return module;
	}


	public void setModule(Modulee module) {
		this.module = module;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getJour() {
		return jour;
	}


	public void setJour(String jour) {
		this.jour = jour;
	}
	

}
