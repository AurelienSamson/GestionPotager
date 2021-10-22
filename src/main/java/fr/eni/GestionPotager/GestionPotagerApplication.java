package fr.eni.GestionPotager;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.eni.GestionPotager.bll.carre.CarreManager;
import fr.eni.GestionPotager.bll.carre.CarreManagerException;
import fr.eni.GestionPotager.bll.potager.PotagerManager;
import fr.eni.GestionPotager.bo.Carre;
import fr.eni.GestionPotager.bo.Potager;

@SpringBootApplication
public class GestionPotagerApplication implements CommandLineRunner {

	@Autowired
	PotagerManager potagerManager;
	
	@Autowired
	CarreManager carreManager;
	public static void main(String[] args) {
		SpringApplication.run(GestionPotagerApplication.class, args);
	}

	@Transactional
	@Override
	public void run(String... args) throws Exception {
//		Potager p1 = new Potager("3 rue des lilas","Carre d'herbe",10,"Quimper");
//		potagerManager.addPotager(p1);
//		carreManager.addCarre(new Carre(100, "Argileux", "Plein soleil"));
//		potagerManager.getAllPotager().forEach(System.out::println);
//		potagerManager.getAllcarreByPotager(p1).forEach(System.out::println);
		
		Potager potager = new Potager("2 bis avenue de la gare", "La Jardinière", 100, "Quimper");
		
		Carre carre = new Carre(25, "humide", "Soleil");
		try {
			potagerManager.addPotager(potager);
			carreManager.addCarre(carre, potager);
		} catch (CarreManagerException e) {
			System.out.println(e.getMessage());
		} catch (Exception e1) {
			System.out.println(e1.getMessage());
		} 
		
		
		
	}

}
