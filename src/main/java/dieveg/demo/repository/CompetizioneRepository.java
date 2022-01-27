package dieveg.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dieveg.demo.model.Competizione;

@Repository
public interface CompetizioneRepository extends JpaRepository<Competizione, Long> {

	
	
	
}
