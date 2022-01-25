package main.service;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.model.Competizione;
import main.model.Utente;
import main.repository.CompetizioneRepository;

@Service
public class CompetizioneService {

	
	@Autowired
	CompetizioneRepository competizioneRepository;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	public void save (Competizione competizione) {
		
		competizioneRepository.save(competizione);
	}
	
	
	@Transactional
	public Competizione getById (Long utenteId) {
		
		Optional<Competizione> utenteResponse = competizioneRepository.findById(utenteId);
		Competizione utente = utenteResponse.get();
		Session sessin = (Session)entityManager.unwrap(Session.class);
		sessin.close ();
		return utente;
	}
	
}
