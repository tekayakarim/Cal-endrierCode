package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Etudiant;

public interface EtudiantService {
String addEtudiant(Etudiant etudiant,long id);
String updateEtudiant(Etudiant etudiant);
String deleteEtudiant(Etudiant etudiant);
Etudiant getOneEtudiant(long id);
List<Etudiant> getAll();
}
