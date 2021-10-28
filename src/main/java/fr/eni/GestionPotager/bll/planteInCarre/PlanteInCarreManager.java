package fr.eni.GestionPotager.bll.planteInCarre;

import java.util.List;

import fr.eni.GestionPotager.bo.Carre;
import fr.eni.GestionPotager.bo.PlanteInCarre;

public interface PlanteInCarreManager {
	public void addPlanteInCarre(PlanteInCarre plant);
	public void updatePlanteInCarre(PlanteInCarre plant);
	public void deletePlanteInCarre(PlanteInCarre plant);
	public List<PlanteInCarre> getAll();
	public List<PlanteInCarre> getAllByCarre(Carre carre);
	public List<PlanteInCarre> getAllByCarreId(int id);
	public PlanteInCarre findById(int id);
}
