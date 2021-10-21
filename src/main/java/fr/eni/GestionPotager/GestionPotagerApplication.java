package fr.eni.GestionPotager;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.eni.GestionPotager.bll.potager.PotagerManager;
import fr.eni.GestionPotager.bo.Potager;

@SpringBootApplication
public class GestionPotagerApplication implements CommandLineRunner {

	@Autowired
	PotagerManager potagerManager;
	public static void main(String[] args) {
		SpringApplication.run(GestionPotagerApplication.class, args);
	}

	@Transactional
	@Override
	public void run(String... args) throws Exception {
		potagerManager.addPotager(new Potager("3 rue des lilas","Carre d'herbe",10,"Quimper"));
		potagerManager.getAllPotager().forEach(System.out::println);
	}

}
