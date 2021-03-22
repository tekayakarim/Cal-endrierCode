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

import com.example.demo.entities.Seance;
import com.example.demo.service.SeanceService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/main/seance")
public class SeanceController {
	@Autowired
	SeanceService seanceService;
	
	@PostMapping("/add")
	public String addSeance(@RequestBody Seance seance,@RequestParam long id) {
		return seanceService.addSeance(seance,id);
	}
	
	@PutMapping("/update")
	public String updateSeance(@RequestBody Seance seance) {
		return seanceService.updateSeance(seance);
	}
	
	@DeleteMapping("/delete")
	public String deleteSeance(@RequestBody Seance seance) {
		return seanceService.deleteSeance(seance);
	}
	
	@GetMapping("/get")
	public Seance getSeance(@RequestParam String codeS) {
		return seanceService.getOneSeance(codeS);
	}
	
	@GetMapping("/getAll")
	public List<Seance> getAllSeance() {
		return seanceService.getAll();
	}
}
