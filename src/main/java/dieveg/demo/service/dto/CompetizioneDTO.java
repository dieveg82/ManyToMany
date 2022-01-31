package dieveg.demo.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompetizioneDTO {

    Long id;
    LocalDate dataCompetizione;
    String descrizione;
    List<UtenteDTO> iscritti;

}
