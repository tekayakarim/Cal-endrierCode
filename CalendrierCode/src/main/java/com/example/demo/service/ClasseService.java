package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.ChefDepartement;
import com.example.demo.entities.Classe;

public interface ClasseService {
String addClasse(Classe classe,long id);
String updateClasse(Classe classe);
String deleteClasse(Classe classe);
Classe getOneClasse(String codeC);
List<Classe> getAll();
}
