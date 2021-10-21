package fr.eni.GestionPotager.bll.potager;

import java.util.List;

import fr.eni.GestionPotager.bo.Carre;
import fr.eni.GestionPotager.bo.Potager;

public interface PotagerManager {

	public void addPotager(Potager potager);
	public void upadtePotager(Potager potager);
	public void deletePotager( Potager potager);
	public List<Potager> getAllPotager();
	public List<Carre> getAllcarreByPotager(Potager potager);
}
