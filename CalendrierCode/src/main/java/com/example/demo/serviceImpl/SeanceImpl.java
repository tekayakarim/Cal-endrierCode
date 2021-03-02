package com.example.demo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entities.Seance;
import com.example.demo.repository.SeanceRepository;
import com.example.demo.service.SeanceService;

public class SeanceImpl implements SeanceService {

	@Autowired
	SeanceRepository seanceRepository;
	
	@Override
	public String addSeance(Seance seance) {
		if(seanceRepository.save(seance)!=null)
			return "success";
		return "fail";
	}

	@Override
	public String updateSeance(Seance seance) {
		Seance ins=seanceRepository.findByCodeS(seance.getCodeS());
		if(ins!=null)
		{
			if(seanceRepository.save(seance)!=null)
				return "success";
		}
		return "fail";
		
	}

	@Override
	public String deleteSeance(Seance seance) {
		String codeS=seance.getCodeS();
		seanceRepository.delete(seance);
		
		if(seanceRepository.findByCodeS(codeS)==null)
			return "success";
		
		return "fail";
	}

}
