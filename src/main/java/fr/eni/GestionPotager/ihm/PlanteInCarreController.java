package fr.eni.GestionPotager.ihm;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.annotation.SessionScope;

import fr.eni.GestionPotager.bll.carre.CarreManager;
import fr.eni.GestionPotager.bll.plante.PlanteManager;
import fr.eni.GestionPotager.bll.plante.PlanteManagerException;
import fr.eni.GestionPotager.bll.planteInCarre.PlanteInCarreException;
import fr.eni.GestionPotager.bll.planteInCarre.PlanteInCarreManager;
import fr.eni.GestionPotager.bo.Plante;
import fr.eni.GestionPotager.bo.PlanteInCarre;

@SessionScope
@Controller
public class PlanteInCarreController {

	private int idCarre;
	
	@Autowired
	PlanteInCarreManager manager;

	@Autowired
	CarreManager managerCarre;
	
	@Autowired
	PlanteManager managerPlante;

	@GetMapping("/carres/{idCarre}/plantes")
	public String listPlanteInCarre(@PathVariable("idCarre") int id, Model model) {
		if((manager.getAllByCarreId(id) == null) || manager.getAllByCarreId(id).isEmpty()) {
			model.addAttribute("error", "Cette page n'existe pas.");
		} else {
			model.addAttribute("plantees", manager.getAllByCarreId(id));
			this.idCarre = id;
			model.addAttribute("carre", managerCarre.getCarreById(this.idCarre));
		}
		return "planteInCarre";
	}

	@GetMapping("/planteCarre/delete/{id}")
	public String deletePlante(@PathVariable("id") int id, Model model) throws PlanteManagerException {
		manager.deletePlanteInCarre(manager.findById(id));

		return "redirect:/carres/"+ this.idCarre +"/plantes";
	}

	@GetMapping("/planteCarre/add")
	public String entreSaisie(PlanteInCarre planteInCarre, Model model) {
		model.addAttribute("carre", managerCarre.getCarreById(this.idCarre));
		model.addAttribute("plantes", managerPlante.getAllPlante());
		return "addPlanteInCarre";
	}

	@PostMapping("/planteCarre/add")
	public String addPlanteInCarre(@Valid PlanteInCarre planteInCarre, BindingResult result, Model model)
			throws PlanteManagerException {
		if (result.hasErrors()) {
			System.out.println("erreur reload page planteInCarre");
			return "addPlanteInCarre";
		}
		manager.addPlanteInCarre(planteInCarre);
		return "redirect:/carres/"+ this.idCarre +"/plantes"; // n'appelle pas l'html mais l'url

	}
}
