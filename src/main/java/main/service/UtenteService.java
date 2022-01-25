package main.service;

import java.awt.print.Book;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.model.Utente;
import main.repository.UtenteRepository;

@Service
public class UtenteService {

	
	@Autowired
	UtenteRepository utenteRepository;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void save (Utente utente) {
		
		utenteRepository.save(utente);
	}
	

	@Transactional
	public Utente getById (Long utenteId) {
		
		Optional<Utente> utenteResponse = utenteRepository.findById(utenteId);
		Utente utente = utenteResponse.get();
		Session sessin = (Session)entityManager.unwrap(Session.class);
		sessin.close ();
		return utente;
	}

}
