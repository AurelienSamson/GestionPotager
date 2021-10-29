package fr.eni.GestionPotager.dal;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import fr.eni.GestionPotager.bo.Carre;

public interface CarreDAO extends CrudRepository<Carre, Integer> {
	@Query("FROM Carre WHERE idCarre = :id")
	Carre findCarreById(@Param("id")int id);

	@Query("FROM Carre c WHERE c.potager.idPotager = :id")
	List<Carre> findAllByIdPotager(@Param("id") int id);
}
