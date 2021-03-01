package com.example.demo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entities.ChefDepartement;
import com.example.demo.entities.Enseignant;
import com.example.demo.repository.EnseignantRepository;
import com.example.demo.service.EnseignantService;

public class EnseignantImpl implements EnseignantService {

	@Autowired
	EnseignantRepository enseignantRepository;
	@Override
	public String addEnseignant(Enseignant enseignant) {
		if(enseignantRepository.save(enseignant)!=null)
			return "success";
		return "fail";
	}

	@Override
	public String uddateEnseignant(Enseignant enseignant) {
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

}
