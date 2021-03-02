package com.example.demo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entities.Classe;
import com.example.demo.repository.ClasseRepository;
import com.example.demo.service.ClasseService;

public class ClasseImpl implements ClasseService {

	@Autowired
	ClasseRepository classeRepository;
	@Override
	public String addClasse(Classe classe) {
		if (classeRepository.save(classe)!=null) {
			return "success";
		}
		return "fail";
	}

	@Override
	public String uddateClasse(Classe classe) {
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

}
