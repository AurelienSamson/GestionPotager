package fr.eni.GestionPotager.bo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Carre {
	@Id
	@GeneratedValue
	private int idCarre;
	@ManyToOne
	private Potager potager;
	private int surface;
	private String typeSol;
	private String typeExpo;
	@OneToMany
	private List<Plante> lstPlante = new ArrayList<>();
	
	public Carre(Potager potager, int surface, String typeSol, String typeExpo) {
		super();
		this.potager = potager;
		this.surface = surface;
		this.typeSol = typeSol;
		this.typeExpo = typeExpo;
	}
	
	
}
