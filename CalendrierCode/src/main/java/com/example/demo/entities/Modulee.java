package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class Modulee {
@Id
private String codeM;
private String nomM,niveau,semestre;

@OneToOne
private ChefDepartement chef;


public Modulee(String codeM, String nomM, String niveau, String semestre) {
	super();
	this.codeM = codeM;
	this.nomM = nomM;
	this.niveau = niveau;
	this.semestre = semestre;
}


public Modulee() {
	super();
}


public ChefDepartement getChef() {
	return chef;
}


public void setChef(ChefDepartement chef) {
	this.chef = chef;
}


public String getCodeM() {
	return codeM;
}
public void setCodeM(String codeM) {
	this.codeM = codeM;
}
public String getNomM() {
	return nomM;
}
public void setNomM(String nomM) {
	this.nomM = nomM;
}
public String getNiveau() {
	return niveau;
}
public void setNiveau(String niveau) {
	this.niveau = niveau;
}


public String getSemestre() {
	return semestre;
}


public void setSemestre(String semestre) {
	this.semestre = semestre;
}


}
