package fr.eni.GestionPotager.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
	
	public Carre(Potager potager, int surface, String typeSol, String typeExpo) {
		super();
		this.potager = potager;
		this.surface = surface;
		this.typeSol = typeSol;
		this.typeExpo = typeExpo;
	}
	
	
}
