package fr.eni.GestionPotager;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.eni.GestionPotager.bll.carre.CarreManager;
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
		Potager p1 = new Potager("3 rue des lilas","Carre d'herbe",10,"Quimper");
		potagerManager.addPotager(p1);
		carreManager.addCarre(new Carre(p1, 100, "Argileux", "Plein soleil"));
		potagerManager.getAllPotager().forEach(System.out::println);
		potagerManager.getAllcarreByPotager(p1).forEach(System.out::println);
	}

}
