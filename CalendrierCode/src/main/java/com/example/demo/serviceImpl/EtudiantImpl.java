package com.example.demo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Etudiant;
import com.example.demo.repository.EtudiantRepository;
import com.example.demo.service.EtudiantService;
@Service
public class EtudiantImpl implements EtudiantService {

	@Autowired
	EtudiantRepository etudiantRepository;
	
	@Override
	public String addEtudiant(Etudiant etudiant) {
		if(etudiantRepository.save(etudiant)!=null)
			return "success";
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

}
