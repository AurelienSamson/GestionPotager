package fr.eni.GestionPotager.dal;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import fr.eni.GestionPotager.bo.Carre;
import fr.eni.GestionPotager.bo.PlanteInCarre;

public interface PlanteInCarreDAO extends CrudRepository<PlanteInCarre, Integer> {
	@Query("FROM PlanteInCarre p WHERE p.carre.idCarre =:id")
	List<PlanteInCarre> findPlanteByCarre(@Param("id") int id);
	
	@Query("FROM PlanteInCarre p WHERE p.plante.idPlante =:id")
	List<PlanteInCarre> findAllByPlanteId(@Param("id")int id);
	
	@Query("FROM PlanteInCarre WHERE idPlanteInCarre = :id")
	Carre findPlanteInCarreById(@Param("id")int id);
}
