package fr.eni.GestionPotager.bll.planteInCarre;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.GestionPotager.bo.Carre;
import fr.eni.GestionPotager.bo.PlanteInCarre;
import fr.eni.GestionPotager.dal.CarreDAO;
import fr.eni.GestionPotager.dal.PlanteInCarreDAO;

@Service
public class PlanteInCarreManagerImpl implements PlanteInCarreManager {

	@Autowired
	PlanteInCarreDAO dao;
	
	@Autowired
	CarreDAO carreDAO;
	
	@Override
	public List<PlanteInCarre> getAll() {
		return (List<PlanteInCarre>) dao.findAll();
	}

	@Override
	@Transactional
	public void addPlanteInCarre(PlanteInCarre plant) {
//		carre.getPlanteInCarreLst().add(plant);
//		carreDAO.save(carre);
		dao.save(plant);
		
	}

	@Override
	@Transactional
	public void updatePlanteInCarre(PlanteInCarre plant) {
		dao.save(plant);
		
	}

	@Override
	@Transactional
	public void deletePlanteInCarre(PlanteInCarre plant) {
		dao.delete(plant);
		
	}

	@Override
	public List<PlanteInCarre> getAllByCarre(Carre carre) {
		return dao.findPlanteByCarre(carre.getIdCarre());
	}

	@Override
	public List<PlanteInCarre> getAllByCarreId(int id) {
		return dao.findPlanteByCarre(id);
	}

	@Override
	public PlanteInCarre findById(int id) {
		return dao.findById(id).get();
	}

}
