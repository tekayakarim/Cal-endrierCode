package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.ChefDepartement;
import com.example.demo.entities.Modulee;

public interface ModuleService {
	String addModule(Modulee module);
	String updateModule(Modulee module);
	String deleteModule(Modulee module);
	Module getOneModule(String codeM);
	List<Module> getAll();
}
