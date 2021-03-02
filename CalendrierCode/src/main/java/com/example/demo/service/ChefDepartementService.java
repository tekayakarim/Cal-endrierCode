package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.ChefDepartement;

public interface ChefDepartementService {
String addChef(ChefDepartement chef);
String updateChef(ChefDepartement chef);
String deleteChef(ChefDepartement chef);
ChefDepartement getOneChef(long id);
List<ChefDepartement> getAll();
}
