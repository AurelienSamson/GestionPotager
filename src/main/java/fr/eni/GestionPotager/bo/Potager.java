package fr.eni.GestionPotager.bo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Potager {
	@Id
	@GeneratedValue
	private int idPotager;
	private String localisation;
	private String nom;
	private int surface;
	private String ville;
	@OneToMany(mappedBy="Carre")
	private List<Carre> carreLst = new ArrayList<>();
	
	public Potager(String localisation, String nom, int surface, String ville) {
		super();
		this.localisation = localisation;
		this.nom = nom;
		this.surface = surface;
		this.ville = ville;
	}

	@Override
	public String toString() {
		return "Potager [localisation=" + localisation + ", nom=" + nom + ", surface=" + surface+ "m� , ville=" + ville
				+ ", carreLst=" + carreLst + "]";
	}
	
	
}
