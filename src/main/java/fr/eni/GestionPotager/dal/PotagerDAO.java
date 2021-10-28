package fr.eni.GestionPotager.dal;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import fr.eni.GestionPotager.bo.Carre;
import fr.eni.GestionPotager.bo.Potager;

public interface PotagerDAO extends CrudRepository<Potager, Integer> {
	@Modifying
	@Query("DELETE FROM Carre c WHERE c.potager = :potager")
	void deleteCarreByPotager(@Param("potager") Potager potager);

	List<Potager> findByNom(String nom);
	
	@Query("FROM Potager WHERE idPotager = :id")
	Potager findPotagerById(@Param("id")int id);
}
