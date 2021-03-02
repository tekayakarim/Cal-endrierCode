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
import com.example.demo.service.ChefDepartementService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/chefDepartement")
public class ChefDepartementController {

	@Autowired
	ChefDepartementService chefDepartementService;
	
	@PostMapping("/add")
	public String addChef(@RequestBody ChefDepartement chef) {
		return chefDepartementService.addChef(chef);
	}
	
	@PutMapping("/update")
	public String updateChef(@RequestBody ChefDepartement chef) {
		return chefDepartementService.updateChef(chef);
	}
	
	@DeleteMapping("/delete")
	public String deleteChef(@RequestBody ChefDepartement chef) {
		return chefDepartementService.deleteChef(chef);
	}
	
	@GetMapping("/get")
	public ChefDepartement getChef(@RequestParam long id) {
		return chefDepartementService.getOneChef(id);
	}
	
	@GetMapping("/getAll")
	public List<ChefDepartement> getAllChef() {
		return chefDepartementService.getAll();
	}
}
