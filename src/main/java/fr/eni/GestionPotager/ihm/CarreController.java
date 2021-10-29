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
import fr.eni.GestionPotager.bll.carre.CarreManagerException;
import fr.eni.GestionPotager.bo.Carre;
import fr.eni.GestionPotager.bo.Potager;

@Controller
public class CarreController {

	@Autowired
	CarreManager manager;

	@GetMapping("/carres/index")
	public String listCarre(Model model) {
		model.addAttribute("carres", manager.getAllCarre());
		return "index";
	}

	@GetMapping("/carres/delete/{id}")
	public String deleteCarre(@PathVariable("id") Integer id, Model model) throws CarreManagerException {
		manager.deleteCarre(manager.getCarreById(id));

		return "redirect:/carres/index";
	}

	@GetMapping("/carres/add")
	public String entreSaisie(Carre carre) {
		return "addCarre";
	}

	@PostMapping("/carres/add")
	public String addCarre(@Valid Potager potager, Carre carre, BindingResult result, Model model)
			throws CarreManagerException {
		if (result.hasErrors()) {
			return "addCarre";
		}
		manager.addCarre(carre, potager);
		return "redirect:/carres/index"; // n'appelle pas l'html mais l'url

	}
}
