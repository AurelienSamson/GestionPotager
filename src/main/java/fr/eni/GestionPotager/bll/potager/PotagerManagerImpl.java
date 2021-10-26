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
	PotagerDAO daoPotager;

	@Autowired
	CarreDAO daoCarre;
	
	@Autowired
	ActionDAO daoAction;

	@Override
	@Transactional
	public void addPotager(Potager potager) {
		daoPotager.save(potager);
	}

	@Override
	public void upadtePotager(Potager potager) {
		daoPotager.save(potager);
	}

	@Override
	public void deletePotager(Potager potager) {
		daoPotager.deleteCarreByPotager(potager);
		daoPotager.delete(potager);
	}

	@Override
	public List<Potager> getAllPotager() {
		return (List<Potager>) daoPotager.findAll();
	}

//	@Override
//	public List<Carre> getAllcarreByPotager(Potager potager) {
//		return potager.getCarreLst();
//	}

	@Override
	public void addAction(Potager potager, Action action) {
		potager.getActionLst().add(action);
		daoAction.save(action);
		daoPotager.save(potager);
	}

}
