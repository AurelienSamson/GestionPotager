package fr.eni.GestionPotager.bll.carre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.eni.GestionPotager.bll.potager.PotagerManager;
import fr.eni.GestionPotager.bo.Carre;
import fr.eni.GestionPotager.bo.Potager;

@SpringBootApplication
public class CarreManagerTest implements CommandLineRunner {
	
	@Autowired
	private PotagerManager managerPotager;
	
	@Autowired
	private CarreManager managerCarre;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void run(String... args) throws Exception {
		Potager potager = new Potager("2 bis avenue de la gare", "La Jardinière", 100, "Quimper");
		
		Carre carre = new Carre(25, "humide", "Soleil");
		
		managerPotager.addPotager(potager);
		
		managerCarre.addCarre(carre, potager);
	}

}
