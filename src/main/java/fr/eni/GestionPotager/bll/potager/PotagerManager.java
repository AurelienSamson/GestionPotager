package fr.eni.GestionPotager.bll.potager;

import java.util.List;

import fr.eni.GestionPotager.bo.Action;
import fr.eni.GestionPotager.bo.Carre;
import fr.eni.GestionPotager.bo.Potager;

public interface PotagerManager {

	//CRUD de base
	public void addPotager(Potager potager) throws PotagerManagerException;
	public void upadtePotager(Potager potager) throws PotagerManagerException;
	public void deletePotager( Potager potager) throws PotagerManagerException;
	public List<Potager> getAllPotager();
	public Potager getPotagerById(int id);
//	public List<Carre> getAllcarreByPotager(Potager potager);
	public void addAction(Potager potager, Action action);
	public void deleteAction(Potager potager, Action action);
	public List<Action> getAllActionByPotager(Potager potager);
	
}
