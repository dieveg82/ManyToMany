package dieveg.demo.service;

import dieveg.demo.model.Utente;
import dieveg.demo.repository.UtenteRepository;
import dieveg.demo.service.dto.UtenteDTO;
import dieveg.demo.service.mapper.UtenteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtenteService {


    @Autowired
    private UtenteRepository repository;

    public void save(Utente utente) {
        repository.save(utente);
    }

    public UtenteDTO getById(Long utenteId) {
        Utente utente = repository.findById(utenteId)
                .orElseThrow(
                        () -> new RuntimeException("Nessun utente con id " + utenteId)
                );

        return UtenteMapper.toDTO(utente);
    }

    public List<UtenteDTO> getAll() {
        return UtenteMapper.toDTO(repository.findAll());
    }


}
