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

import com.example.demo.entities.Classe;
import com.example.demo.entities.Modulee;
import com.example.demo.service.ClasseService;
import com.example.demo.service.ModuleService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/module")
public class ModuleController {
	@Autowired
	ModuleService moduleService;
	
	@PostMapping("/add")
	public String addModule(@RequestBody Modulee module,@RequestParam long id) {
		return moduleService.addModule(module,id);
	}
	
	@PutMapping("/update")
	public String updateModule(@RequestBody Modulee module) {
		return moduleService.updateModule(module);
	}
	
	@DeleteMapping("/delete")
	public String deleteModule(@RequestBody Modulee module) {
		return moduleService.deleteModule(module);
	}
	
	@GetMapping("/get")
	public Modulee getModule(@RequestParam String codeM) {
		return moduleService.getOneModule(codeM);
	}
	
	@GetMapping("/getAll")
	public List<Modulee> getAllModule() {
		return moduleService.getAll();
	}
}
