package fr.eni.GestionPotager.bll.potager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.GestionPotager.bo.Carre;
import fr.eni.GestionPotager.bo.Potager;
import fr.eni.GestionPotager.dal.CarreDAO;
import fr.eni.GestionPotager.dal.PotagerDAO;

@Service
public class PotagerManagerImpl implements PotagerManager {

	@Autowired
	PotagerDAO daoPotager;

	@Autowired
	CarreDAO daoCarre;

	@Override
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

	@Override
	public List<Carre> getAllcarreByPotager(Potager potager) {
		return daoCarre.findAllByPotager(potager);
	}

}
