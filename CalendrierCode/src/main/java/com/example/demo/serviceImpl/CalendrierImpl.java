package com.example.demo.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Classe;
import com.example.demo.entities.Enseignant;
import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Seance;
import com.example.demo.repository.ClasseRepository;
import com.example.demo.repository.EnseignantRepository;
import com.example.demo.repository.EtudiantRepository;
import com.example.demo.repository.SeanceRepository;
import com.example.demo.service.CalendrierService;
@Service
public class CalendrierImpl implements CalendrierService {
	
@Autowired
SeanceRepository seanceRepository;

@Autowired
EnseignantRepository enseignantRepository;

@Autowired
EtudiantRepository etudiantRepository;

@Autowired
ClasseRepository classeRepository;

	@Override
	public List<Seance> addSeanceToEnseignant(String codeS, long id) {
		try {
			Seance sc=seanceRepository.findByCodeS(codeS);
			Enseignant en=enseignantRepository.findById(id);
			if(en!=null) 
			{
			if(sc!=null)
			{
				List<Seance> ls=en.getLstSeance();
				if(ls==null)
				{
					ls=new ArrayList<Seance>();
					ls.add(sc);
					en.setLstSeance(ls);
					
				}
				else
				{
					ls.add(sc);
				}
				enseignantRepository.flush();
			
				return ls;
			}
			}

		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Etudiant addEtudiantToClasse(long id, String codeC) {
		try {
			Etudiant et=etudiantRepository.findById(id);
			Classe cl=classeRepository.findByCodeC(codeC);
			if(et!=null && cl!=null)
			{
				et.setClasse(cl);
				etudiantRepository.flush();
			}
			return et;
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Classe> addClasseToEnseignant(String codeC, long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
