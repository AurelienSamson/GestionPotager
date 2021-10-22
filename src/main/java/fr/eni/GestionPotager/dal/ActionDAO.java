package fr.eni.GestionPotager.dal;

import org.springframework.data.repository.CrudRepository;

import fr.eni.GestionPotager.bo.Action;

public interface ActionDAO extends CrudRepository<Action, Integer>{

}
