package dieveg.demo.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UtenteDTO {

    Long id;
    String nome;
    String cognome;
    String genere;
    LocalDate dataDiNascita;
}
