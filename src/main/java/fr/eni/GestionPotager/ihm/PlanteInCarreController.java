package fr.eni.GestionPotager.ihm;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import fr.eni.GestionPotager.bll.carre.CarreManager;
import fr.eni.GestionPotager.bll.plante.PlanteManager;
import fr.eni.GestionPotager.bll.plante.PlanteManagerException;
import fr.eni.GestionPotager.bll.planteInCarre.PlanteInCarreManager;
import fr.eni.GestionPotager.bo.Plante;
import fr.eni.GestionPotager.bo.PlanteInCarre;

@Controller
public class PlanteInCarreController {

	@Autowired
	PlanteInCarreManager manager;

	@Autowired
	CarreManager managerCarre;

	@GetMapping("/carres/{id}/plantes")
	public String listPlanteInCarre(@PathVariable("id") int id, Model model) {
		model.addAttribute("plantees", manager.getAllByCarreId(id));
		return "planteInCarre";
	}

	@GetMapping("/planteCarre/delete/{id}")
	public String deletePlante(@PathVariable("id") int id, Model model) throws PlanteManagerException {
		manager.deletePlanteInCarre(manager.findById(id));

		return "redirect:/plantes/index";
	}

	@GetMapping("/plantes/add")
	public String entreSaisie(Plante plante) {
		return "addPlanteInCarre";
	}

	@PostMapping("/plantes/add")
	public String addPlanteInCarre(@Valid PlanteInCarre planteInCarre, BindingResult result, Model model)
			throws PlanteManagerException {
		if (result.hasErrors()) {
			return "addPlanteInCarre";
		}
		manager.addPlanteInCarre(planteInCarre);
		return "redirect:/plantes/index"; // n'appelle pas l'html mais l'url

	}
}
