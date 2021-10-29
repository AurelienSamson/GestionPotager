package fr.eni.GestionPotager.bo;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class PlanteInCarre {
	
	@Id
	@GeneratedValue
	private int idPlanteInCarre;
	
	@ManyToOne
	private Carre carre;
	
	@ManyToOne
	private Plante plante;
	
	private int quantite;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate dateMeP;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate dateRecolta;
	
	public PlanteInCarre(Carre carre, Plante plante, int quantite, LocalDate dateMeP, LocalDate dateRecolta) {
		super();
		this.carre = carre;
		this.plante = plante;
		this.quantite = quantite;
		this.dateMeP = dateMeP;
		this.dateRecolta = dateRecolta;
	}
	
	
	
	
	
}
