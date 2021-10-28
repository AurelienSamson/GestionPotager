package fr.eni.GestionPotager.ihm;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import fr.eni.GestionPotager.bll.carre.CarreManagerException;
import fr.eni.GestionPotager.bll.plante.PlanteManager;
import fr.eni.GestionPotager.bll.plante.PlanteManagerException;
import fr.eni.GestionPotager.bo.Carre;
import fr.eni.GestionPotager.bo.Plante;

@Controller
public class PlanteController {
	
	@Autowired
	PlanteManager manager;
	
	@GetMapping("/plantes/index")
	public String listPlante(Model model) {
		model.addAttribute("plantes", manager.getAllPlante());
		return "plante";
	}
	
	@GetMapping("/plantes/delete/{id}")
	public String deletePlante(@PathVariable("id") Integer id, Model model) throws PlanteManagerException {	
		manager.deletePlante(manager.GetPlanteById(id));
		
	    return "redirect:/plantes/index";
	}
	
	@GetMapping("/plantes/add")
	public String entreSaisie(Plante plante) {
		return "addPlante";
	}
	
	@PostMapping("/plantes/add")
	public String addPlante(@Valid Plante plante, BindingResult result, Model model) throws  PlanteManagerException{
		if (result.hasErrors()) {
			return "addPlante";
		}
		manager.addPlante(plante);
		return "redirect:/plantes/index"; // n'appelle pas l'html mais l'url

	}
}
