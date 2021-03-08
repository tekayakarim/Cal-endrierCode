package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.ChefDepartement;
import com.example.demo.entities.Classe;
import com.example.demo.repository.ChefDepartementRepository;
import com.example.demo.repository.ClasseRepository;
import com.example.demo.service.ClasseService;
@Service
public class ClasseImpl implements ClasseService {

	@Autowired
	ClasseRepository classeRepository;
	@Autowired
	ChefDepartementRepository chefDepartementRepository;
	@Override
	public String addClasse(Classe classe,long id) {
		try {
			ChefDepartement chef=chefDepartementRepository.findById(id);
			classe.setChef(chef);
			if (classeRepository.save(classe)!=null) {
				return "success";
			}
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		return "fail";
	}

	@Override
	public String updateClasse(Classe classe) {
		Classe ins=classeRepository.findByCodeC(classe.getCodeC());
		if(ins!=null)
		{
			if(classeRepository.save(classe)!=null)
				return "success";
		}
		return "fail";
	}

	@Override
	public String deleteClasse(Classe classe) {
		String codeC=classe.getCodeC();
		classeRepository.delete(classe);
		
		if(classeRepository.findByCodeC(codeC)==null)
			return "success";
		
		return "fail";
	}

	@Override
	public Classe getOneClasse(String codeC) {
		try {
			Classe cl=classeRepository.findByCodeC(codeC);
			if(cl!=null)
				return cl;
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Classe> getAll() {
		
		return classeRepository.findAll();
	}

}
