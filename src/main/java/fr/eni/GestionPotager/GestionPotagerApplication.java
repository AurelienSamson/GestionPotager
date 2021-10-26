package fr.eni.GestionPotager;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.eni.GestionPotager.bll.carre.CarreManager;
import fr.eni.GestionPotager.bll.carre.CarreManagerException;
import fr.eni.GestionPotager.bll.plante.PlanteManager;
import fr.eni.GestionPotager.bll.planteInCarre.PlanteInCarreManager;
//import fr.eni.GestionPotager.bll.carre.CarreManagerException;
import fr.eni.GestionPotager.bll.potager.PotagerManager;
import fr.eni.GestionPotager.bo.Carre;
import fr.eni.GestionPotager.bo.Plante;
import fr.eni.GestionPotager.bo.PlanteInCarre;
import fr.eni.GestionPotager.bo.Potager;

@SpringBootApplication
public class GestionPotagerApplication implements CommandLineRunner {

	@Autowired
	PotagerManager potagerManager;
	
	@Autowired
	CarreManager carreManager;
	
	@Autowired
	PlanteManager planteManager;
	
	@Autowired
	PlanteInCarreManager planteInCarreManager;
	
	public static void main(String[] args) {
		SpringApplication.run(GestionPotagerApplication.class, args);
	}

	@Transactional
	@Override
	public void run(String... args) throws Exception {
		
		Potager potager = new Potager("2 bis avenue de la gare", "La Jardinière", 100, "Quimper");
		
		Carre carre = new Carre(potager, 25, "humide", "Soleil");
		Plante patate = new Plante("Patate", "Pomme de tere", "Patate nouvelle", 5);
		PlanteInCarre plantDePatate1 = new PlanteInCarre(carre, patate, 10, LocalDate.now(), LocalDate.now().plusDays(60));
		
		try {
			potagerManager.addPotager(potager);
			carreManager.addCarre(carre, potager);
			planteManager.addPlante(patate);
			planteInCarreManager.addPlanteInCarre(plantDePatate1, carre);
			
			
		} catch (CarreManagerException e) {
			System.out.println(e.getMessage());
		}
		

//		Potager p1 = new Potager("3 rue des lilas","Carre d'herbe",100,"Quimper");
//		potagerManager.addPotager(p1);
//		carreManager.addCarre(new Carre(p1,10, "Argileux", "Plein soleil"),p1);
//		carreManager.addCarre(new Carre(p1, 10, "Sableux", "ESE"), p1);
//		System.out.println("Tous les potagers: _____________________");
//		potagerManager.getAllPotager().forEach(System.out::println);
//
//		System.out.println("Tous les carrés d'un potager: ______________");
//		potagerManager.getAllcarreByPotager(p1).forEach(System.out::println);
//		potagerManager.addAction(p1, new Action(LocalDate.now().plusDays(7), "Ajout d'un carré", "Quimper"));
//		System.out.println("Affichage des actions d'un potager: ________");
//		p1.getActionLst().forEach(System.out::println);
	

	}

}
