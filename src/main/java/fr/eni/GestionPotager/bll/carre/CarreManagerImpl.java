package fr.eni.GestionPotager.bll.carre;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.GestionPotager.bo.Action;
import fr.eni.GestionPotager.bo.Carre;
import fr.eni.GestionPotager.bo.PlanteInCarre;
import fr.eni.GestionPotager.bo.Potager;
import fr.eni.GestionPotager.dal.ActionDAO;
import fr.eni.GestionPotager.dal.CarreDAO;
import fr.eni.GestionPotager.dal.PlanteDAO;
import fr.eni.GestionPotager.dal.PlanteInCarreDAO;
import fr.eni.GestionPotager.dal.PotagerDAO;

@Service
public class CarreManagerImpl implements CarreManager {

	@Autowired
	private PotagerDAO daoPotager;

	@Autowired
	private CarreDAO dao;

	@Autowired
	private PlanteInCarreDAO daoPlanteInCarre;
	
	@Autowired
	private PlanteDAO daoPlante;
	
	@Autowired
	private ActionDAO daoAction;

	private int totalSurface = 0;

	@Override
	@Transactional
	public void addCarre(Carre carre, Potager potager) throws CarreManagerException {

		if (daoPotager.findByNom(potager.getNom()).isEmpty()) {
			throw new CarreManagerException("Le potager renseigné n'existe pas.");
		}
		for (Carre carreVerif : dao.findAll()) {
			if(carreVerif.getPotager().getNom().equals(potager.getNom())) {
				totalSurface += carreVerif.getSurfaceCarre();
			}
		}
		if (totalSurface + carre.getSurfaceCarre() > potager.getSurface()) {
			throw new CarreManagerException(
					"La surface du carré est trop grande, il n'y a pas assez de place dans le potager.");
		}

//		potager.getCarreLst().add(carre);
		dao.save(carre);
//		daoPotager.save(potager);

	}

	@Override
	@Transactional
	public void updateCarre(Carre carre, Potager potager) throws CarreManagerException {
		if (carre.getPotager() == null) {
			throw new CarreManagerException("Un carré doit forcément appartenir à un potager.");
		}
//		carre.getPotager().getCarreLst().remove(carre.getIdCarre());

		for (Carre carreVerif : dao.findAll()) {
			if(carreVerif.getPotager().equals(potager)) {
				totalSurface += carreVerif.getSurfaceCarre();
			}
		}
		if (totalSurface + carre.getSurfaceCarre() < carre.getPotager().getSurface()) {
			throw new CarreManagerException(
					"La surface du carré est trop grande, il n'y a pas assez de place dans le potager.");
		}
//		carre.getPotager().getCarreLst().add(carre);
		
		if(potager != carre.getPotager()) {
			daoPotager.save(potager);
			carre.setPotager(potager);
		}
		dao.save(carre);

	}

	@Override
	@Transactional
	public void deleteCarre(Carre carre) throws CarreManagerException {
//		daoPlanteInCarre.deleteAll(carre.getPlanteInCarreLst());
		if(dao.findById(carre.getIdCarre()) == null) {
			throw new CarreManagerException("Ce carré n'existe pas.");
		}
		for (PlanteInCarre planteInCarre : daoPlanteInCarre.findPlanteByCarre(carre.getIdCarre())) {
			daoPlanteInCarre.delete(planteInCarre);
		}
		dao.delete(carre);
	}

	@Override
	public List<Carre> getAllCarre() {
		return (List<Carre>) dao.findAll();
	}

	@Override
	public void addAction(Carre carre, Action action) {
		carre.getActionLst().add(action);
		daoAction.save(action);
		dao.save(carre);		
	}
	
	@Override
	@Transactional
	public void deleteAction(Carre carre, Action action) {
		carre.getActionLst().remove(action);
		daoAction.delete(action);
		dao.save(carre);		
	}

	@Override
	public List<Action> getAllActionByCarre(Carre carre) {
		return dao.findById(carre.getIdCarre()).get().getActionLst();
	}

	@Override
	public Carre getCarreById(int id) {
		return dao.findCarreById(id);
	}

	@Override
	public List<Carre> getCarresByPotagerId(int id) {
		return dao.findAllByIdPotager(id);
	}

}
