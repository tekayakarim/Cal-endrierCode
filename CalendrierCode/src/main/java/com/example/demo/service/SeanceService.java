package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.ChefDepartement;
import com.example.demo.entities.Seance;

public interface SeanceService {
	String addSeance(Seance seance,long id);
	String updateSeance(Seance seance);
	String deleteSeance(Seance seance);
	Seance getOneSeance(String codeS);
	List<Seance> getAll();
}
