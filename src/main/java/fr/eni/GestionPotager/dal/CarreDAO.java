package fr.eni.GestionPotager.dal;

import org.springframework.data.repository.CrudRepository;

import fr.eni.GestionPotager.bo.Carre;

public interface CarreDAO extends CrudRepository<Carre, Integer> {

}
