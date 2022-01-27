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
public class Competizione implements Serializable {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    Long id;

    @Column(
            name = "data",
            nullable = false
    )
    LocalDate dataCompetizione;

    @Column(
            name = "descrizione"
    )
    String descrizione;

    @ManyToMany()
    @JoinTable(
            name = "iscrizioni",
            joinColumns = @JoinColumn(name = "id_competizione"),
            inverseJoinColumns = @JoinColumn(name = "id_user")
    )
    @JsonIgnoreProperties(value = { "iscritti" }, allowSetters = true)
    List<Utente> iscritti = new ArrayList<>();

    public Competizione(LocalDate dataCompetizione, String descrizione){
        this.dataCompetizione = dataCompetizione;
        this.descrizione = descrizione;
    }

    public void iscrivi(Utente utente) {
        // controllo se l'utente è già iscritto
        for(Utente iscritto: getIscritti()) {
            if (iscritto.getId().equals(utente.getId())) {
                // se è iscritto esco
                return;
            }
        }

        // utente non iscritto: lo aggiungo agli iscritti
        this.iscritti.add(utente);
    }
}


