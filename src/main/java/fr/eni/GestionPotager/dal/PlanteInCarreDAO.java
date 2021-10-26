package fr.eni.GestionPotager.dal;

import org.springframework.data.repository.CrudRepository;

import fr.eni.GestionPotager.bo.PlanteInCarre;

public interface PlanteInCarreDAO extends CrudRepository<PlanteInCarre, Integer> {
	
}
