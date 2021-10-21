package fr.eni.GestionPotager.bll.carre;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fr.eni.GestionPotager.bo.Carre;
import fr.eni.GestionPotager.bo.Potager;
import fr.eni.GestionPotager.dal.CarreDAO;
import fr.eni.GestionPotager.dal.PlanteDAO;

public class CarreManagerImpl implements CarreManager {

	@Autowired
	private CarreDAO dao;
	
	@Autowired
	private PlanteDAO daoPlante;
	
	private int totalSurface = 0;
	
	@Override
	public void addCarre(Carre carre, Potager potager) {
		for (Carre carreVerif : potager.getCarreLst()) {
			totalSurface += carreVerif.getSurface();
		}
		if(totalSurface + carre.getSurface() < potager.getSurface()) {
			carre.setPotager(potager);
			carre.getPotager().getCarreLst().add(carre);
			dao.save(carre);
		} else {
			System.out.println("Vous ne pouvez plus ajouter de carré, il n'y a plus de place dans le potager.");
		}
		
	}

	@Override
	public void updateCarre(Carre carre) {
		if(carre.getPotager() != null) {
			for (Carre carreVerif : carre.getPotager().getCarreLst()) {
				totalSurface += carreVerif.getSurface();
			}
			if(totalSurface + carre.getSurface() < carre.getPotager().getSurface()) {
				carre.getPotager().getCarreLst().add(carre);
				dao.save(carre);
			} else {
				System.out.println("Vous ne pouvez plus ajouter de carré, il n'y a plus de place dans le potager.");
			}
		}
		
	}

	@Override
	public void deleteCarre(Carre carre) {
		daoPlante.deleteAll(carre.getLstPlante());
		dao.delete(carre);
	}

	@Override
	public List<Carre> getAllCarre() {
		return (List<Carre>) dao.findAll();
	}

}
