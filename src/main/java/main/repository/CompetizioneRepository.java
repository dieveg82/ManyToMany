package main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import main.model.Competizione;
import main.model.Utente;

@Repository
public interface CompetizioneRepository extends JpaRepository<Competizione, Long> {

	
	
	
}
