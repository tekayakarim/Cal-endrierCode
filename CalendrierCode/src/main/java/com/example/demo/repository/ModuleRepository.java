package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Modulee;
@Repository
public interface ModuleRepository extends JpaRepository<Modulee, String> {

}
