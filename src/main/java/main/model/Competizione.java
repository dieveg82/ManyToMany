package main.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Setter
@Getter
@Entity
public class Competizione {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	LocalDate dataCompetizione;
	String descrizione;
	@ManyToMany (mappedBy = "listCompetizione" )
	List<Utente> listUtenti = new ArrayList<>();

	public Competizione(Long id, LocalDate dataCompetizione, String descrizione) {
		this.id = id;
		this.dataCompetizione = dataCompetizione;
		this.descrizione = descrizione;

	}

	@Override
	public String toString() {
		return "Competizione [id=" + id + ", dataCompetizione=" + dataCompetizione + ", descrizione=" + descrizione
				+ "]";
	}

	
}
