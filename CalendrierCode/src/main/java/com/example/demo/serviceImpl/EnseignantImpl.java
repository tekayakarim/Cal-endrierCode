package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.ChefDepartement;
import com.example.demo.entities.Enseignant;
import com.example.demo.repository.ChefDepartementRepository;
import com.example.demo.repository.EnseignantRepository;
import com.example.demo.service.EnseignantService;
@Service
public class EnseignantImpl implements EnseignantService {

	@Autowired
	EnseignantRepository enseignantRepository;
	@Autowired
	ChefDepartementRepository chefDepartementRepository;
	@Override
	public String addEnseignant(Enseignant enseignant,long id) {
		try {
			ChefDepartement chef=chefDepartementRepository.findById(id);
			enseignant.setChef(chef);
			if(enseignantRepository.save(enseignant)!=null)
				return "success";
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		return "fail";
	}

	@Override
	public String updateEnseignant(Enseignant enseignant) {
		Enseignant ins=enseignantRepository.findById(enseignant.getId());
		if(ins!=null)
		{
			if(enseignantRepository.save(enseignant)!=null)
				return "success";
		}
		return "fail";
	}

	@Override
	public String deleteEnseignant(Enseignant enseignant) {
		long id=enseignant.getId();
		enseignantRepository.delete(enseignant);
		
		if(enseignantRepository.findById(id)==null)
			return "success";
		
		return "fail";
	}

	@Override
	public Enseignant getOneEnseignant(long id) {
		try {
			Enseignant en=enseignantRepository.findById(id);
			if (en!=null) {
				return en;
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Enseignant> getAll() {
	
		return enseignantRepository.findAll();
	}

}
