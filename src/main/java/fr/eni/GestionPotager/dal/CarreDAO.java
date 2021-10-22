package fr.eni.GestionPotager.dal;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.eni.GestionPotager.bo.Carre;
import fr.eni.GestionPotager.bo.Potager;

public interface CarreDAO extends CrudRepository<Carre, Integer> {

	
}
