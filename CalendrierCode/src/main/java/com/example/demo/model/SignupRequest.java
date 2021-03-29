package com.example.demo.model;
 
public class SignupRequest {

    private String userName;
     
    private String role; 
    private String nom;
    private String prenom;
    
private String tel;

    private String password;

  private String cin;

   private String email;
   
   private String groupe;
   
   
	public String getTel() {
	return tel;
}

public void setTel(String tel) {
	this.tel = tel;
}

	public String getGroupe() {
	return groupe;
}

public void setGroupe(String groupe) {
	this.groupe = groupe;
}

	public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}


	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

    
    public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getUserName() {
        return userName;
    }
 
    public void setUserName(String username) {
        this.userName = username;
    }
 
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public SignupRequest(String userName, String nom, String prenom, String tel, String password, String cin,
			String email, String groupe) {
		super();
		this.userName = userName;
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		this.password = password;
		this.cin = cin;
		this.email = email;
		this.groupe = groupe;
	}





    

}
