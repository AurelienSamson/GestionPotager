package fr.eni.GestionPotager.bll.potager;

import java.util.List;

import fr.eni.GestionPotager.bo.Action;
import fr.eni.GestionPotager.bo.Carre;
import fr.eni.GestionPotager.bo.Potager;

public interface PotagerManager {

	//CRUD de base
	public void addPotager(Potager potager);
	public void upadtePotager(Potager potager);
	public void deletePotager( Potager potager);
	public List<Potager> getAllPotager();
	//Gestion des carres d'un potager
	public List<Carre> getAllcarreByPotager(Potager potager);
	//Gestion des actions d'un potager
	public void addAction(Potager potager, Action action);
	public void deleteAction(Potager potager, Action action);
	public List<Action> getAllActionByPotager(Potager potager);
	
}
