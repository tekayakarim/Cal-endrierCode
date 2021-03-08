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

import com.example.demo.entities.ChefDepartement;
import com.example.demo.entities.Classe;
import com.example.demo.service.ChefDepartementService;
import com.example.demo.service.ClasseService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/classe")
public class ClasseController {
	@Autowired
	ClasseService classeService;
	
	@PostMapping("/add")
	public String addClasse(@RequestBody Classe classe,@RequestParam long id) {
		return classeService.addClasse(classe,id);
	}
	
	@PutMapping("/update")
	public String updateClassse(@RequestBody Classe classe) {
		return classeService.updateClasse(classe);
	}
	
	@DeleteMapping("/delete")
	public String deleteClasse(@RequestBody Classe classe) {
		return classeService.deleteClasse(classe);
	}
	
	@GetMapping("/get")
	public Classe getClasse(@RequestParam String codeC) {
		return classeService.getOneClasse(codeC);
	}
	
	@GetMapping("/getAll")
	public List<Classe> getAllClasse() {
		return classeService.getAll();
	}
}
