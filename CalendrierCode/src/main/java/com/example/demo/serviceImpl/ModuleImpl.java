package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.ChefDepartement;
import com.example.demo.entities.Modulee;
import com.example.demo.repository.ChefDepartementRepository;
import com.example.demo.repository.ModuleRepository;
import com.example.demo.service.ModuleService;
@Service
public class ModuleImpl implements ModuleService {
	
	@Autowired
	ModuleRepository moduleRepository;
	@Autowired
	ChefDepartementRepository chefDepartementRepository;
	@Override
	public String addModule(Modulee module,long id) {
		try {
			ChefDepartement chef=chefDepartementRepository.findById(id);
			module.setChef(chef);
			if(moduleRepository.save(module)!=null)
				return "success";
		} catch (Exception e) {
	
			e.printStackTrace();
		}
		return "fail";
	}

	@Override
	public String updateModule(Modulee module) {
		Modulee ins=moduleRepository.findByCodeM(module.getCodeM());
		if(ins!=null)
		{
			if(moduleRepository.save(module)!=null)
				return "success";
		}
		return "fail";
	}

	@Override
	public String deleteModule(Modulee module) {
		String codeM=module.getCodeM();
		moduleRepository.delete(module);
		
		if(moduleRepository.findByCodeM(codeM)==null)
			return "success";
		
		return "fail";
	}

	@Override
	public Modulee getOneModule(String codeM) {
		try {
			Modulee mo=moduleRepository.findByCodeM(codeM);
			if (mo!=null) {
				return mo;
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Modulee> getAll() {
		
		return moduleRepository.findAll();
	}
	

}
