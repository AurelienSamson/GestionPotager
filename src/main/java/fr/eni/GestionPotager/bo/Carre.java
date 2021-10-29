package fr.eni.GestionPotager.bo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	private int surfaceCarre;
	private String typeSol;
	private String typeExpo;
	@ManyToOne
	private Potager potager;
//	@OneToMany(mappedBy="idCarre")
//	private List<PlanteInCarre> planteInCarreLst = new ArrayList<>();
	@OneToMany
	private List<Action> actionLst = new ArrayList<Action>();
	
	public Carre(Potager potager, int surface, String typeSol, String typeExpo) {
		super();
		this.potager = potager;
		this.surfaceCarre = surface;
		this.typeSol = typeSol;
		this.typeExpo = typeExpo;
	}

	@Override
	public String toString() {
		return "Carre [potager=" + potager.getNom() + ", surface=" + surfaceCarre + ", typeSol=" + typeSol + ", typeExpo=" + typeExpo
				 + ", actions=" + actionLst + "]";
	}
	
	
	
}
