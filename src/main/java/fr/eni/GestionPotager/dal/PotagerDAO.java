package fr.eni.GestionPotager.dal;

import org.springframework.data.repository.CrudRepository;

import fr.eni.GestionPotager.bo.Potager;

public interface PotagerDAO extends CrudRepository<Potager, Integer> {

}
