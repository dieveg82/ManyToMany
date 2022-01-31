package dieveg.demo.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Utente implements Serializable {

    private static final long serialVersionUID = 1905122041950251207L;

    @Id
    @GeneratedValue(
			strategy = GenerationType.IDENTITY
	)
    Long id;

    @Column(
            name = "nome"
    )
    String nome;

    @Column(
            name = "cognome"
    )
    String cognome;

    @Enumerated(value = EnumType.STRING)
    Genere genere;

    @Column(
            name = "data_nascita"
    )
    LocalDate dataDiNascita;

    @ManyToMany(
            mappedBy = "iscritti"
    )
    @JsonIgnoreProperties(value = { "iscrizioni" }, allowSetters = true)
    List<Competizione> competizioni = new ArrayList<>();
}
