package fr.eni.GestionPotager.bo;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Action {
	@Id
	@GeneratedValue
	private int idAction;
	private LocalDate date;
	private String evenement;
	
	public Action(LocalDate date, String evenement) {
		super();
		this.date = date;
		this.evenement = evenement;
	}
	
	
}
