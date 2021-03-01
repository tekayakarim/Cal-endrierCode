package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Seance;
@Repository
public interface SeanceRepository extends JpaRepository<Seance, String> {

}
