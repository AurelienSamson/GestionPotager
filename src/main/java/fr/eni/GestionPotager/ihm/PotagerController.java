package fr.eni.GestionPotager.ihm;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import fr.eni.GestionPotager.bll.potager.PotagerManager;
import fr.eni.GestionPotager.bll.potager.PotagerManagerException;
import fr.eni.GestionPotager.bo.Potager;

@Controller
public class PotagerController {
	
	@Autowired
	PotagerManager manager;
	
	@GetMapping("/potagers/index")
	public String listPotagers(Model model) {
		model.addAttribute("potagers", manager.getAllPotager());
		return "index";
	}
	
	@GetMapping("/potagers/delete/{id}")
	public String deletePotager(@PathVariable("id") Integer id, Model model) throws PotagerManagerException {	
		manager.deletePotager(manager.getPotagerById(id));
		
	    return "redirect:/potagers/index";
	}
	
	@GetMapping("/potagers/add")
	public String entreSaisie(Potager potager) {
		return "addPotager";
	}
	
	@PostMapping("/potagers/add")
	public String addPotager(@Valid Potager potager, BindingResult result, Model model) throws PotagerManagerException{
		if (result.hasErrors()) {
			return "addPotager";
		}
		manager.addPotager(potager);
		return "redirect:/potagers/index"; // n'appelle pas l'html mais l'url

	}
}
