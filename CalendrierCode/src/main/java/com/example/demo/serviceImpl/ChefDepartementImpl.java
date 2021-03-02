package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.ChefDepartement;
import com.example.demo.repository.ChefDepartementRepository;
import com.example.demo.service.ChefDepartementService;
@Service
public class ChefDepartementImpl implements ChefDepartementService {

	@Autowired
	ChefDepartementRepository chefDepartementRepository;
	
	@Override
	public String addChef(ChefDepartement chef) {
		if(chefDepartementRepository.save(chef)!=null)
			return "success";
		return "fail";
	}

	@Override
	public String updateChef(ChefDepartement chef) {
		ChefDepartement ins=chefDepartementRepository.findById(chef.getId());
		if(ins!=null)
		{
			if(chefDepartementRepository.save(chef)!=null)
				return "success";
		}
		return "fail";
	}

	@Override
	public String deleteChef(ChefDepartement chef) {
		long id=chef.getId();
		chefDepartementRepository.delete(chef);
		
		if(chefDepartementRepository.findById(id)==null)
			return "success";
		
		return "fail";
	}

	@Override
	public ChefDepartement getOneChef(long id) {
		
		try {
			ChefDepartement chef=chefDepartementRepository.findById(id);
			if (chefDepartementRepository.findById(id)!=null) {
				return chef;
			}
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<ChefDepartement> getAll() {
	
		return chefDepartementRepository.findAll();
	}

}
