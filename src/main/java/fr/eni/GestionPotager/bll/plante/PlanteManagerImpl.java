package fr.eni.GestionPotager.bll.plante;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.GestionPotager.bo.Plante;
import fr.eni.GestionPotager.dal.PlanteDAO;
@Service
public class PlanteManagerImpl implements PlanteManager {

	@Autowired
	PlanteDAO daoPlante;
	
	private boolean flag = false;
	
	@Override
	public void addPlante(Plante plante) {
		
		for (Plante plantes : getAllPlante()) {
			if(plante.getNom().equals(plantes.getNom())&& plante.getVariete().equals(plantes.getVariete())) {
				flag=true;
			}
		}
		if(flag==false) {
			daoPlante.save(plante);
		}
	}

	@Override
	public void updatePlante(Plante plante) {
		for (Plante plantes : getAllPlante()) {
			if(plante.getNom().equals(plantes.getNom())&& plante.getVariete().equals(plantes.getVariete())) {
				flag=true;
			}
		}
		if(flag==false) {
			daoPlante.save(plante);
		}
	}

	@Override
	public void deletePlante(Plante plante) {
		daoPlante.delete(plante);		
	}

	@Override
	public List<Plante> getAllPlante() {
		return (List<Plante>) daoPlante.findAll();
	}

}
