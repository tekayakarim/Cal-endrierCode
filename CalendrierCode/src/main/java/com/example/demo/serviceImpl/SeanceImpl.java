package com.example.demo.serviceImpl;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.ChefDepartement;
import com.example.demo.entities.Classe;
import com.example.demo.entities.Enseignant;
import com.example.demo.entities.Modulee;
import com.example.demo.entities.Seance;
import com.example.demo.repository.ChefDepartementRepository;
import com.example.demo.repository.EnseignantRepository;
import com.example.demo.repository.ModuleRepository;
import com.example.demo.repository.SeanceRepository;
import com.example.demo.service.SeanceService;
import com.sun.nio.sctp.SendFailedNotification;
@Service
public class SeanceImpl implements SeanceService {

	@Autowired
	SeanceRepository seanceRepository;
	@Autowired
	ChefDepartementRepository chefDepartementRepository;
	@Autowired
	ModuleRepository  moduleRepository;
	
	@Autowired
	EnseignantRepository  enseignantRepository;
	@Override
	public String addSeance(Seance seance,long id) {
		try {
			//chef determine 
			ChefDepartement  chef=chefDepartementRepository.findById(id);
			seance.setChef(chef);
			
			Modulee mo=seance.getModule();//moduleRepository.findByCodeM(seance.getModule().getCodeM());
			seance.setModule(mo);
			
			Enseignant en=seance.getEnseignant();//enseignantRepository.findById(seance.getEnseignant().getId());
			seance.setEnseignant(en);
			
			Classe cl=seance.getCl();
			seance.setCl(cl);
			
			for (Seance sea : this.getAll()) {
				if (sea.getCl().getCodeC().equals(cl.getCodeC()) &&
					sea.getModule().getCodeM().equals(mo.getCodeM()) &&
					sea.getEnseignant().getId()==en.getId() &&
					sea.getNumSalle()==seance.getNumSalle()) {
					return "seance existe deja";
				}
				if(sea.getJour().equals( seance.getJour()) && 
						sea.getNumSalle()==seance.getNumSalle())
				{
					try {
						int hhD=Integer.valueOf(sea.getHeureDeb().substring(0, 2));
						int hhF=Integer.valueOf(sea.getHeureFin().substring(0, 2 ));
						System.out.println("hhd "+ hhD + "hhf" + hhF);
						int hhDCourante=Integer.valueOf(seance.getHeureDeb().substring(0, 2));
						int hhFCourante=Integer.valueOf(seance.getHeureFin().substring(0, 2));
						System.out.println("hhdCour "+ hhDCourante + "hhfcouran" + hhFCourante);
						if(hhDCourante==hhD  ) {
							
							return "salle reservé a cette heure";
							
						}
						if (hhFCourante==hhF ) {
							
							return "salle reservé a cette heure";
						}
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				
			}
			if(seanceRepository.findByCodeS(seance.getCodeS())!=null)
				return "fail";
			
			if(seanceRepository.save(seance)!=null)
				return "success";
			
		} catch (Exception e) {
		
			e.printStackTrace();
		}
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

	@Override
	public Seance getOneSeance(String codeS) {
		try {
			Seance se=seanceRepository.findByCodeS(codeS);
			if (se!=null) {
				return se;
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Seance> getAll() {
	
		return seanceRepository.findAll();
	}

}
