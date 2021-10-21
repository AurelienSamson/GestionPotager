package fr.eni.GestionPotager.bll.potager;

import java.util.List;

import fr.eni.GestionPotager.bo.Potager;

public interface PotagerManager {

	public void addPotager(Potager potager);
	public List<Potager> getAllPotager();
}
