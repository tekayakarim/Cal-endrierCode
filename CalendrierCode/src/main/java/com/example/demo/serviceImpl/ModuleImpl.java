package com.example.demo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entities.Modulee;
import com.example.demo.repository.ModuleRepository;
import com.example.demo.service.ModuleService;

public class ModuleImpl implements ModuleService {
	
	@Autowired
	ModuleRepository moduleRepository;
	
	@Override
	public String addModule(Modulee module) {
		if(moduleRepository.save(module)!=null)
			return "success";
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
	

}
