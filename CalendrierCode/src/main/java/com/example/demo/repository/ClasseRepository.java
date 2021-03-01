package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Classe;
@Repository
public interface ClasseRepository extends JpaRepository<Classe, String>{
Classe findByCodeC(String codeC);
}
