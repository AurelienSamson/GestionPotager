package fr.eni.GestionPotager.bll.carre;

import java.util.List;

import fr.eni.GestionPotager.bo.Carre;
import fr.eni.GestionPotager.bo.Potager;

public interface CarreManager {
	public void addCarre(Carre carre, Potager potager) throws CarreManagerException;
	public void updateCarre(Carre carre, Potager potager) throws CarreManagerException;
	public void deleteCarre(Carre carre);
	public List<Carre> getAllCarre();
}
