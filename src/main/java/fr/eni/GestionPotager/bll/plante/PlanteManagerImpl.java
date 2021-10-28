package fr.eni.GestionPotager.bll.plante;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.GestionPotager.bo.Plante;
import fr.eni.GestionPotager.dal.PlanteDAO;
@Service
public class PlanteManagerImpl implements PlanteManager {

	@Autowired
	PlanteDAO dao;
	
	private boolean flag = false;
	
	@Override
	@Transactional
	public void addPlante(Plante plante) throws PlanteManagerException {
		
		for (Plante plantes : getAllPlante()) {
			if(plante.getNom().equals(plantes.getNom())&& plante.getVariete().equals(plantes.getVariete())) {
				flag=true;
			}
		}
		if(flag==true) {
			throw new PlanteManagerException("Cette plante existe déjà.");
		}
		dao.save(plante);
	}

	@Override
	@Transactional
	public void updatePlante(Plante plante) throws PlanteManagerException {
		for (Plante plantes : getAllPlante()) {
			if(plante.getNom().equals(plantes.getNom())&& plante.getVariete().equals(plantes.getVariete())) {
				flag=true;
			}
		}
		if(flag==true) {
			throw new PlanteManagerException("Cette plante existe déjà.");
		}
		dao.save(plante);
	}

	@Override
	@Transactional
	public void deletePlante(Plante plante) throws PlanteManagerException {
		if(dao.findById(plante.getIdPlante()) == null) {
			throw new PlanteManagerException("Cette plante n'existe pas.");
		}
		dao.delete(plante);		
	}

	@Override
	public List<Plante> getAllPlante() {
		return (List<Plante>) dao.findAll();
	}

}
