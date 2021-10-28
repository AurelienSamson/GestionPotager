package fr.eni.GestionPotager.bll.potager;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.GestionPotager.bo.Action;
import fr.eni.GestionPotager.bo.Carre;
import fr.eni.GestionPotager.bo.Potager;
import fr.eni.GestionPotager.dal.ActionDAO;
import fr.eni.GestionPotager.dal.CarreDAO;
import fr.eni.GestionPotager.dal.PotagerDAO;

@Service
public class PotagerManagerImpl implements PotagerManager {

	@Autowired
	PotagerDAO dao;

	@Autowired
	CarreDAO daoCarre;
	
	@Autowired
	ActionDAO daoAction;

	@Override
	@Transactional
	public void addPotager(Potager potager) throws PotagerManagerException {
		List<Potager> potagers = (List<Potager>) dao.findAll();
		
		for (Potager potagerBDD : potagers) {
			if(potager.getNom() == potagerBDD.getNom()) {
				throw new PotagerManagerException("Un potager porte dékà ce nom.");
			}
			
			if(potager.getLocalisation() == potagerBDD.getLocalisation()) {
				throw new PotagerManagerException("Il existe déjà un potager à cet endroit.");
			}
		}
		
		dao.save(potager);
	}

	@Override
	@Transactional
	public void upadtePotager(Potager potager) throws PotagerManagerException {
		List<Potager> potagers = (List<Potager>) dao.findAll();
		for (Potager potagerBDD : potagers) {
			if(potager.equals(potagerBDD)) {
				throw new PotagerManagerException("Aucun changement n'est à enregistrer, ce potager existe déjà.");
			}
		}
		
		dao.save(potager);
	}

	@Override
	@Transactional
	public void deletePotager(Potager potager) throws PotagerManagerException {
		if(dao.findById(potager.getIdPotager()) == null) {
			throw new PotagerManagerException("Ce potager n'existe pas.");
		}
		
		dao.deleteCarreByPotager(potager);
		dao.delete(potager);
	}

	@Override
	public List<Potager> getAllPotager() {
		return (List<Potager>) dao.findAll();
	}


//	@Override
//	public List<Carre> getAllcarreByPotager(Potager potager) {
//		return potager.getCarreLst();
//	}

	@Override
	@Transactional
	public void addAction(Potager potager, Action action) {
		potager.getActionLst().add(action);
		daoAction.save(action);
		dao.save(potager);
	}

	@Override
	public List<Action> getAllActionByPotager(Potager potager) {
		return dao.findById(potager.getIdPotager()).get().getActionLst();
	}

	@Override
	@Transactional
	public void deleteAction(Potager potager, Action action) {
		potager.getActionLst().remove(action);
		dao.save(potager);
	}

	@Override
	public Potager getPotagerById(int id) {
		return dao.findPotagerById(id);
	}
	
	

}
