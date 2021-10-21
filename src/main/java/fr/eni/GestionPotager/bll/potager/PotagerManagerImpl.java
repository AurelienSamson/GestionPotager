package fr.eni.GestionPotager.bll.potager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fr.eni.GestionPotager.bo.Potager;
import fr.eni.GestionPotager.dal.PotagerDAO;

public class PotagerManagerImpl implements PotagerManager {

	@Autowired
	PotagerDAO dao;
	@Override
	public void addPotager(Potager potager) {
		dao.save(potager);
	}

	@Override
	public List<Potager> getAllPotager() {
		// TODO Auto-generated method stub
		return null;
	}

}
