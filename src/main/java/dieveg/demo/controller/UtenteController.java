package dieveg.demo.controller;

import dieveg.demo.service.UtenteService;
import dieveg.demo.service.dto.UtenteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UtenteController {

    @Autowired
    private UtenteService service;

    @GetMapping
    public ResponseEntity<List<UtenteDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UtenteDTO> getUtenteById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }
}
