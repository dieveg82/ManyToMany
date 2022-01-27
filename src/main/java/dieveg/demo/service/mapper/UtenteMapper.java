package dieveg.demo.service.mapper;

import dieveg.demo.model.Utente;
import dieveg.demo.service.dto.UtenteDTO;

import java.util.ArrayList;
import java.util.List;

import static dieveg.demo.model.Genere.FEMALE;
import static dieveg.demo.model.Genere.MALE;

public class UtenteMapper {

    public static UtenteDTO toDTO(Utente utente) {
        return UtenteDTO.builder()
                .id(utente.getId())
                .nome(utente.getNome())
                .cognome(utente.getCognome())
                .dataDiNascita(utente.getDataDiNascita())
                .genere(utente.getGenere().toString())
                .build();
    }

    public static Utente toEntity(UtenteDTO utenteDTO) {
        return Utente.builder()
                .id(utenteDTO.getId())
                .nome(utenteDTO.getNome())
                .cognome(utenteDTO.getCognome())
                .dataDiNascita(utenteDTO.getDataDiNascita())
                .genere(utenteDTO.getGenere().equals("FEMALE") ? FEMALE : MALE)
                .build();
    }

    public static List<UtenteDTO> toDTO(List<Utente> entities) {
        List<UtenteDTO> dtos = new ArrayList<>();
        for (Utente entity: entities) {
            dtos.add(toDTO(entity));
        }
        return dtos;
    }

    public static List<Utente> toEntity(List<UtenteDTO> dtos) {
        List<Utente> entities = new ArrayList<>();
        for (UtenteDTO dto: dtos) {
            entities.add(toEntity(dto));
        }
        return entities;
    }
}
