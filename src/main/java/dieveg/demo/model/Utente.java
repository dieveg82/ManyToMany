package dieveg.demo.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Setter
@Getter
@Entity
public class Utente implements Serializable {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	Long id;
	String nome;
	String cognome;
	@Enumerated (value = EnumType.STRING)
	Genere genere;
	LocalDate dataDiNascita;
	@ManyToMany ()
	@JoinTable (name = "Partecipazione" ,joinColumns = @JoinColumn (name = "id_user") , inverseJoinColumns = @JoinColumn (name = "id_competizione"))
	List <Competizione> listCompetizione = new ArrayList<Competizione> ();
	
	
	public Utente(Long id, String nome, String cognome, Genere genere, LocalDate dataDiNascita) {
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.genere = genere;
		this.dataDiNascita = dataDiNascita;
	}

	public void setCompetizione(Competizione competizione) {
		if (this.listCompetizione == null) {
			this.listCompetizione = new ArrayList<>();
		}
		this.listCompetizione.add(competizione);
	}

	@Override
	public String toString() {
		return "Utente [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", genere=" + genere
				+ ", dataDiNascita=" + dataDiNascita + "]";
	}

	
	

	
	
}
