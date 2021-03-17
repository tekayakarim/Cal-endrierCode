package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class Modulee {
@Id
private String codeM;
private String nomM,niveau,semstre;

@OneToOne
private ChefDepartement chef;


public Modulee(String codeM, String nomM, String niveau, String semstre) {
	super();
	this.codeM = codeM;
	this.nomM = nomM;
	this.niveau = niveau;
	this.semstre = semstre;
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
public String getSemstre() {
	return semstre;
}
public void setSemstre(String semstre) {
	this.semstre = semstre;
}

}
