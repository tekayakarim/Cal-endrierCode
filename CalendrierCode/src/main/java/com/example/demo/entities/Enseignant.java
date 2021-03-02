package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Enseignant extends User{

/*	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(	name = "chef_departement_list_module", 
	joinColumns = @JoinColumn(name = "id"), 
	inverseJoinColumns = @JoinColumn(name = "codeM"))
	private List<Module> lstModule;
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(	name = "chef_departement_list_module", 
	joinColumns = @JoinColumn(name = "id"), 
	inverseJoinColumns = @JoinColumn(name = "codeS"))
	private List<Seance> lstSeance;
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(	name = "chef_departement_list_module", 
	joinColumns = @JoinColumn(name = "id"), 
	inverseJoinColumns = @JoinColumn(name = "codeC"))
	private List<Classe> lstClasse;
	*/
	@OneToOne
	private ChefDepartement chef;

	public ChefDepartement getChef() {
		return chef;
	}
	public void setChef(ChefDepartement chef) {
		this.chef = chef;
	}
	
	
}
