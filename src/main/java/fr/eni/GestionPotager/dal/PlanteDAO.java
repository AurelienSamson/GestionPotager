package fr.eni.GestionPotager.dal;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.eni.GestionPotager.bo.Plante;
import fr.eni.GestionPotager.bo.PlanteInCarre;

public interface PlanteDAO extends CrudRepository<Plante, Integer> {
}
