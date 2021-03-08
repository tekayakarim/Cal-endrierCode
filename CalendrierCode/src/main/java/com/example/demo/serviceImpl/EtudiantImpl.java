package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.ChefDepartement;
import com.example.demo.entities.Classe;
import com.example.demo.entities.Etudiant;
import com.example.demo.repository.ChefDepartementRepository;
import com.example.demo.repository.ClasseRepository;
import com.example.demo.repository.EtudiantRepository;
import com.example.demo.service.EtudiantService;
@Service
public class EtudiantImpl implements EtudiantService {

	@Autowired
	EtudiantRepository etudiantRepository;
	@Autowired
	ChefDepartementRepository chefDepartementRepository;
	@Autowired
	ClasseRepository classeRepository;
	@Override
	public String addEtudiant(Etudiant etudiant,long id) {
		try {
			//chef determine
			ChefDepartement chef=chefDepartementRepository.findById(id);
			etudiant.setChef(chef);
			if(etudiantRepository.save(etudiant)!=null)
				return "success";
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		return "fail";
	}

	@Override
	public String updateEtudiant(Etudiant etudiant) {
		Etudiant ins=etudiantRepository.findById(etudiant.getId());
		if(ins!=null)
		{
			if(etudiantRepository.save(etudiant)!=null)
				return "success";
		}
		return "fail";
	}

	@Override
	public String deleteEtudiant(Etudiant etudiant) {
		long id=etudiant.getId();
		etudiantRepository.delete(etudiant);
		
		if(etudiantRepository.findById(id)==null)
			return "success";
		
		return "fail";
	}

	@Override
	public Etudiant getOneEtudiant(long id) {
	try {
		Etudiant et=etudiantRepository.findById(id);
		if (et!=null) {
			return et;
		}
	} catch (Exception e) {
	
		e.printStackTrace();
	}
		return null;
	}

	@Override
	public List<Etudiant> getAll() {
		
		return etudiantRepository.findAll();
	}

}
