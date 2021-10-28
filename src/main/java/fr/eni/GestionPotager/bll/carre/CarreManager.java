package fr.eni.GestionPotager.bll.carre;

import java.util.List;

import fr.eni.GestionPotager.bo.Action;
import fr.eni.GestionPotager.bo.Carre;
import fr.eni.GestionPotager.bo.Potager;

public interface CarreManager {
	//CRUD de base
	public void addCarre(Carre carre, Potager potager) throws CarreManagerException;
	public void updateCarre(Carre carre, Potager potager) throws CarreManagerException;
	public void deleteCarre(Carre carre) throws CarreManagerException;
	public List<Carre> getAllCarre();
	//Gestion des actions d'un carre
	public List<Action> getAllActionByCarre(Carre carre);
	public void addAction(Carre carre, Action action);
	public void deleteAction(Carre carre, Action action);
}
