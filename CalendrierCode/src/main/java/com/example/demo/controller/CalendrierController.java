package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Seance;
import com.example.demo.service.CalendrierService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/calendrier")
public class CalendrierController {

	@Autowired
	CalendrierService calendrierService;
	
	@PostMapping("/addSeanceToEnseignant")
	public List<Seance> addSeanceToEnseignant(@RequestParam String codeS,@RequestParam long id) {
		return calendrierService.addSeanceToEnseignant(codeS, id);
	}
	
	@PostMapping("/addEtudiantToClasse")
	public Etudiant addEtudiantToClasse(@RequestParam long id,@RequestParam String codeC) {
		return calendrierService.addEtudiantToClasse(id, codeC);
	}
}
