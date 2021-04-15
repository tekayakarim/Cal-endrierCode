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

import com.example.demo.entities.Etudiant;
import com.example.demo.service.EtudiantService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/main/etudiant")
public class EtudiantController {
	@Autowired
	EtudiantService etudiantService;
	
	@PostMapping("/add")
	public String addEtudiant(@RequestBody Etudiant etudiant,@RequestParam long id) {
		return etudiantService.addEtudiant(etudiant,id);
	}
	
	@PutMapping("/update")
	public String updateEtudiant(@RequestBody Etudiant etudiant) {
		return etudiantService.updateEtudiant(etudiant);
	}
	
	@DeleteMapping("/delete")
	public String deleteEtudiant(@RequestParam long id) {
		return etudiantService.deleteEtudiant(this.getEtudiant(id));
	}
	
	@GetMapping("/get")
	public Etudiant getEtudiant(@RequestParam long id) {
		return etudiantService.getOneEtudiant(id);
	}
	
	@GetMapping("/getAll")
	public List<Etudiant> getAllEtudiant() {
		return etudiantService.getAll();
	}
}
