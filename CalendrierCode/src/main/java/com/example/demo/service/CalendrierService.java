package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Classe;
import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Seance;

public interface CalendrierService {
List<Seance> addSeanceToEnseignant(String codeS,long id);
Etudiant addEtudiantToClasse(long id,String codeC);
List<Classe> addClasseToEnseignant(String codeC,long id);
}
