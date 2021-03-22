package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Enseignant;
import com.example.demo.service.EnseignantService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/main/enseignant")
public class EnseignantController {
	@Autowired
	EnseignantService enseignantService;
	
	@PostMapping("/add")
	public String addEnseignant(@RequestBody Enseignant enseignant,@RequestParam long id) {
		return enseignantService.addEnseignant(enseignant,id);
	}
	
	@PutMapping("/update")
	public String updateEnseignant(@RequestBody Enseignant enseignant) {
		return enseignantService.updateEnseignant(enseignant);
	}
	
	@DeleteMapping("/delete")
	public String deleteEnseignant(@RequestBody Enseignant enseignant) {
		return enseignantService.deleteEnseignant(enseignant);
	}
	
	@GetMapping("/get")
	public Enseignant getEnseignant(@RequestParam long id) {
		return enseignantService.getOneEnseignant(id);
	}
	
	@GetMapping("/getAll")
	public List<Enseignant> getAllEnseignant() {
		return enseignantService.getAll();
	}
}
