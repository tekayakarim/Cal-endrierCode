package com.example.demo.service;

import com.example.demo.entities.Seance;

public interface SeanceService {
	String addSeance(Seance seance);
	String updateSeance(Seance seance);
	String deleteSeance(Seance seance);
}
