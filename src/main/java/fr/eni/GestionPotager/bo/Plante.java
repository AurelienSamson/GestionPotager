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
public class Plante {
	@Id
	@GeneratedValue
	private int idPlante;
	private String nom;
	private String type;
	private String variete;
	private int surfaceOccupe;
	@ManyToOne
	private Carre carre;
	
	public Plante(String nom, String type, String variete, int surfaceOccupe) {
		super();
		this.nom = nom;
		this.type = type;
		this.variete = variete;
		this.surfaceOccupe = surfaceOccupe;
	}
	
	
}
