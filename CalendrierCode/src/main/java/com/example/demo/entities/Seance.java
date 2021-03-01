package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class Seance {
	@Id
	private String codeS;
	private String codeC,nomM,nomE,heureDeb,heureFin,date;

	@OneToOne
	private ChefDepartement chef;
	
	public Seance(String codeS, String codeC, String nomM, String nomE, String heureDeb, String heureFin, String date) {
		super();
		this.codeS = codeS;
		this.codeC = codeC;
		this.nomM = nomM;
		this.nomE = nomE;
		this.heureDeb = heureDeb;
		this.heureFin = heureFin;
		this.date = date;
	}
	

	public Seance() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getCodeC() {
		return codeC;
	}

	public void setCodeC(String codeC) {
		this.codeC = codeC;
	}

	public String getNomM() {
		return nomM;
	}

	public void setNomM(String nomM) {
		this.nomM = nomM;
	}

	public String getNomE() {
		return nomE;
	}

	public void setNomE(String nomE) {
		this.nomE = nomE;
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
	

}
