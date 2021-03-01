package com.example.demo.service;

import com.example.demo.entities.Enseignant;

public interface EnseignantService {
	String addEnseignant(Enseignant enseignant);
	String uddateEnseignant(Enseignant enseignant);
	String deleteEnseignant(Enseignant enseignant);
}
