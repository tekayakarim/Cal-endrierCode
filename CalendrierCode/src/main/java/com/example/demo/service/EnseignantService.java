package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Enseignant;

public interface EnseignantService {
	String addEnseignant(Enseignant enseignant,long id);
	String updateEnseignant(Enseignant enseignant);
	String deleteEnseignant(Enseignant enseignant);
	Enseignant getOneEnseignant(long id);
	List<Enseignant> getAll();
}
