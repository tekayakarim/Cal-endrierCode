package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class Classe {
	@Id
	private String codeC;
private String niveauC;

@OneToOne
private ChefDepartement chef;

public Classe(String codeC, String niveauC) {
	super();
	this.codeC = codeC;
	this.niveauC = niveauC;
}

public Classe() {
	super();
	
}

public ChefDepartement getChef() {
	return chef;
}

public void setChef(ChefDepartement chef) {
	this.chef = chef;
}

public String getCodeC() {
	return codeC;
}

public void setCodeC(String codeC) {
	this.codeC = codeC;
}

public String getNiveauC() {
	return niveauC;
}

public void setNiveauC(String niveauC) {
	this.niveauC = niveauC;
}

}
