package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Enseignant;
@Repository
public interface EnseignantRepository extends JpaRepository<Enseignant, Long> {
	Enseignant findById(long id);
}
