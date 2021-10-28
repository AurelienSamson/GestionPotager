package fr.eni.GestionPotager.dal;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import fr.eni.GestionPotager.bo.Carre;
import fr.eni.GestionPotager.bo.Potager;

public interface CarreDAO extends CrudRepository<Carre, Integer> {
	@Query("FROM Carre WHERE idCarre = :id")
	Carre findCarreById(@Param("id")int id);
}
