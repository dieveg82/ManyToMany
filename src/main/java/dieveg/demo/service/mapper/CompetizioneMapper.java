package dieveg.demo.service.mapper;

import dieveg.demo.model.Competizione;
import dieveg.demo.service.dto.CompetizioneDTO;

import java.util.ArrayList;
import java.util.List;

public class CompetizioneMapper {

    public static CompetizioneDTO toDTO(Competizione entity) {
        return CompetizioneDTO.builder()
                .id(entity.getId())
                .dataCompetizione(entity.getDataCompetizione())
                .descrizione(entity.getDescrizione())
                .iscritti(UtenteMapper.toDTO(entity.getIscritti()))
                .build();
    }

    public static Competizione toEntity(CompetizioneDTO dto) {
        return Competizione.builder()
                .id(dto.getId())
                .dataCompetizione(dto.getDataCompetizione())
                .descrizione(dto.getDescrizione())
                .iscritti(UtenteMapper.toEntity(dto.getIscritti()))
                .build();
    }

    public static List<CompetizioneDTO> toDTO(List<Competizione> entities) {
        List<CompetizioneDTO> dtos = new ArrayList<>();
        for (Competizione entity : entities) {
            dtos.add(toDTO(entity));
        }
        return dtos;
    }

    public static List<Competizione> toEntity(List<CompetizioneDTO> dtos) {
        List<Competizione> entities = new ArrayList<>();
        for (CompetizioneDTO dto : dtos) {
            entities.add(toEntity(dto));
        }
        return entities;

    }
}
