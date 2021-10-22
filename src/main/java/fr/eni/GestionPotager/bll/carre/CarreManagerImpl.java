package fr.eni.GestionPotager.bll.carre;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.GestionPotager.bo.Action;
import fr.eni.GestionPotager.bo.Carre;
import fr.eni.GestionPotager.bo.Plante;
import fr.eni.GestionPotager.bo.Potager;
import fr.eni.GestionPotager.dal.ActionDAO;
import fr.eni.GestionPotager.dal.CarreDAO;
import fr.eni.GestionPotager.dal.PlanteDAO;
import fr.eni.GestionPotager.dal.PotagerDAO;

@Service
public class CarreManagerImpl implements CarreManager {

	@Autowired
	private PotagerDAO daoPotager;

	@Autowired
	private CarreDAO dao;

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
		for (Carre carreVerif : potager.getCarreLst()) {
			totalSurface += carreVerif.getSurface();
		}
		if (totalSurface + carre.getSurface() > potager.getSurface()) {
			throw new CarreManagerException(
					"La surface du carré est trop grande, il n'y a pas assez de place dans le potager.");
		}

		potager.getCarreLst().add(carre);
		dao.save(carre);
		daoPotager.save(potager);

	}

	@Override
	@Transactional
	public void updateCarre(Carre carre) throws CarreManagerException {
		if (carre.getPotager() == null) {
			throw new CarreManagerException("Un carré doit forcément appartenir à un potager.");
		}
		carre.getPotager().getCarreLst().remove(carre.getIdCarre());

		for (Carre carreVerif : carre.getPotager().getCarreLst()) {
			totalSurface += carreVerif.getSurface();
		}
		if (totalSurface + carre.getSurface() < carre.getPotager().getSurface()) {
			throw new CarreManagerException(
					"La surface du carré est trop grande, il n'y a pas assez de place dans le potager.");
		}
		carre.getPotager().getCarreLst().add(carre);
		dao.save(carre);

	}

	@Override
	@Transactional
	public void deleteCarre(Carre carre) {
		daoPlante.deleteAll(carre.getLstPlante());
		dao.delete(carre);
	}

	@Override
	public List<Carre> getAllCarre() {
		return (List<Carre>) dao.findAll();
	}

	@Override
	public List<Plante> getAllPlanteByCarre(Carre carre) {
		return dao.findById(carre.getIdCarre()).get().getLstPlante();
	}

	@Override
	public void addPlanteToCarre(Plante plante, Carre carre) {
		carre.getLstPlante().add(plante);
		dao.save(carre);
	}

	@Override
	public void deletePlanteToCarre(Plante plante, Carre carre) {
		carre.getLstPlante().remove(plante);
		dao.save(carre);
	}

	@Override
	public void addAction(Carre carre, Action action) {
		carre.getActionLst().add(action);
		daoAction.save(action);
		dao.save(carre);		
	}
	
	@Override
	public void deleteAction(Carre carre, Action action) {
		carre.getActionLst().remove(action);
		daoAction.delete(action);
		dao.save(carre);		
	}

	@Override
	public List<Action> getAllActionByCarre(Carre carre) {
		return dao.findById(carre.getIdCarre()).get().getActionLst();
	}

}
