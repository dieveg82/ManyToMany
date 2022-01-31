package dieveg.demo.service;

import dieveg.demo.model.Competizione;
import dieveg.demo.repository.CompetizioneRepository;
import dieveg.demo.service.dto.CompetizioneDTO;
import dieveg.demo.service.mapper.CompetizioneMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompetizioneService {

    @Autowired
    CompetizioneRepository repository;

    public void save(Competizione competizione) {

        repository.save(competizione);
    }

    public List<CompetizioneDTO> getAll() {
        List<Competizione> competizioni = repository.findAll();
        return CompetizioneMapper.toDTO(competizioni);
    }

    public CompetizioneDTO getById(Long idCompetizione) {
        Competizione competizione = repository.findById(idCompetizione)
                .orElseThrow(
                        () -> new RuntimeException("Nessuna competizione con id " + idCompetizione)
                );
        return CompetizioneMapper.toDTO(competizione);
    }


}
