package dieveg.demo.controller;

import dieveg.demo.service.CompetizioneService;
import dieveg.demo.service.dto.CompetizioneDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/competitions")
public class CompetizioneController {

    @Autowired
    private CompetizioneService service;

    @GetMapping
    public ResponseEntity<List<CompetizioneDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompetizioneDTO> getUtenteById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }
}
