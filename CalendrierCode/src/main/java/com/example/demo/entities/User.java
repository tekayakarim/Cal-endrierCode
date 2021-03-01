package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
		@Id
	    @GeneratedValue
	    private long id;
private String nomUser,prenomUser,emailUser,telUser;
public User(String nomUser, String prenomUser, String emailUser, String telUser) {
	super();
	this.nomUser = nomUser;
	this.prenomUser = prenomUser;
	this.emailUser = emailUser;
	this.telUser = telUser;
}

public User() {
	super();
	// TODO Auto-generated constructor stub
}

public String getNomUser() {
	return nomUser;
}
public void setNomUser(String nomUser) {
	this.nomUser = nomUser;
}
public String getPrenomUser() {
	return prenomUser;
}
public void setPrenomUser(String prenomUser) {
	this.prenomUser = prenomUser;
}
public String getEmailUser() {
	return emailUser;
}
public void setEmailUser(String emailUser) {
	this.emailUser = emailUser;
}
public String getTelUser() {
	return telUser;
}
public void setTelUser(String telUser) {
	this.telUser = telUser;
}

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}


}
