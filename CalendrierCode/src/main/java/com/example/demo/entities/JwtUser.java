package com.example.demo.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class JwtUser {
		@Id
	    @GeneratedValue
	    private long id;
		private String userName;
private String nomUser,prenomUser,emailUser,telUser,groupe;
@ManyToMany(fetch = FetchType.LAZY/*, cascade = CascadeType.ALL*/)
@JoinTable(	name = "user_roles", 
			joinColumns = @JoinColumn(name = "user_id"), 
			inverseJoinColumns = @JoinColumn(name = "role_id"))
private Set<JwtRole> roles = new HashSet<>();

private String password;
public JwtUser(String nomUser, String prenomUser, String emailUser, String telUser) {
	super();
	this.nomUser = nomUser;
	this.prenomUser = prenomUser;
	this.emailUser = emailUser;
	this.telUser = telUser;
}


public JwtUser(String userName, String nomUser, String prenomUser, String emailUser, String telUser, String password) {
	super();
	this.userName = userName;
	this.nomUser = nomUser;
	this.prenomUser = prenomUser;
	this.emailUser = emailUser;
	this.telUser = telUser;
	this.password = password;
}


public JwtUser() {
	super();
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

public Set<JwtRole> getRoles() {
	return roles;
}

public void setRoles(Set<JwtRole> roles) {
	this.roles = roles;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getUserName() {
	return userName;
}

public void setUserName(String userName) {
	this.userName = userName;
}


public String getGroupe() {
	return groupe;
}


public void setGroupe(String groupe) {
	this.groupe = groupe;
}


}
