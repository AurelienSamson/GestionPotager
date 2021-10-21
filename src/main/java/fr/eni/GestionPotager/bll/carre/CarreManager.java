package fr.eni.GestionPotager.bll.carre;

import java.util.List;

import fr.eni.GestionPotager.bo.Carre;

public interface CarreManager {
	public void addCarre(Carre carre);
	public void updateCarre(Carre carre);
	public void deleteCarre(Carre carre);
	public List<Carre> getAllCarre();
}
