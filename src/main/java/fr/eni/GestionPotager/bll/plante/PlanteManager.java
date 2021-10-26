package fr.eni.GestionPotager.bll.plante;

import java.util.List;

import fr.eni.GestionPotager.bo.Plante;

public interface PlanteManager {

	public void addPlante(Plante plante) throws PlanteManagerException;
	public void updatePlante(Plante plante) throws PlanteManagerException;
	public void deletePlante(Plante plante);
	public List<Plante> getAllPlante();
}
