package fr.eni.GestionPotager.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.eni.GestionPotager.bll.carre.CarreManager;
import fr.eni.GestionPotager.bll.plante.PlanteManager;
import fr.eni.GestionPotager.bll.planteInCarre.PlanteInCarreManager;
import fr.eni.GestionPotager.bll.potager.PotagerManager;
import fr.eni.GestionPotager.bo.Carre;
import fr.eni.GestionPotager.bo.Plante;
import fr.eni.GestionPotager.bo.PlanteInCarre;
import fr.eni.GestionPotager.bo.Potager;

@RestController
public class PotagerWS {
	
	@Autowired
	PotagerManager managerPotager;
	
	@Autowired
	CarreManager managerCarre;
	
	@Autowired
	PlanteManager managerPlante;
	
	@Autowired
	PlanteInCarreManager managerPlanteInCarre;
	
	@GetMapping("/potager")
	public List<Potager> getPotager(){
		return managerPotager.getAllPotager();
	}
	
	@GetMapping("/potager/carre")
	public List<Carre> getCarre(){
		return managerCarre.getAllCarre();
	}
	
	@GetMapping("/potager/plante")
	public List<Plante> getplante(){
		return managerPlante.getAllPlante();
	}
	
	@GetMapping("/potager/plantee")
	public List<PlanteInCarre> getplantee(){
		return managerPlanteInCarre.getAll();
	}
}
