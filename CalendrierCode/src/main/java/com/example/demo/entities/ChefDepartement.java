package com.example.demo.entities;

import javax.persistence.Entity;

@Entity
public class ChefDepartement extends JwtUser{

	private String departement;

	public ChefDepartement(String nomUser, String prenomUser, String emailUser, String telUser, String departement) {
		super(nomUser, prenomUser, emailUser, telUser);
		this.departement = departement;
	}

	
	public ChefDepartement(String userName, String nomUser, String prenomUser, String emailUser, String telUser,
			String password, String departement) {
		super(userName, nomUser, prenomUser, emailUser, telUser, password);
		this.departement = departement;
	}


	public ChefDepartement() {
		super();

	}

	public String getDepartement() {
		return departement;
	}

	public void setDepartement(String departement) {
		this.departement = departement;
	}
	
}
