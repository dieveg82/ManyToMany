package main;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import main.model.Competizione;
import main.model.Genere;
import main.model.Utente;
import main.service.CompetizioneService;
import main.service.UtenteService;

@Component
public class Run implements CommandLineRunner{

	@Autowired
	UtenteService utenteService;
	
	@Autowired 
	CompetizioneService competizioneService;
	
	@Override
	public void run(String... args) throws Exception {

		Utente utente = new Utente(null, "Diego", "cappai", Genere.M, LocalDate.of(1982, 3, 12));
		Utente utente2 = new Utente(null, "Beniamino", "cappai", Genere.M, LocalDate.of(1946, 6, 16));
		Utente utente3 = new Utente(null, "Gabriella", "cappai", Genere.F, LocalDate.of(1973, 9, 17));
		
		
		utenteService.save(utente);
		utenteService.save(utente2);
		utenteService.save(utente3);
		
		
		Competizione comp = new Competizione(null, LocalDate.of(2022, 3, 12), "Maratona Assemini");
		competizioneService.save (comp);

	
		
		utente = utenteService.getById(1L);
		utente.setCompetizione(comp);
		utente2 = utenteService.getById(2L);
		utente2.setCompetizione(comp);
		utente3 = utenteService.getById(3L);
		utente3.setCompetizione(comp);
		 
		utenteService.save(utente);
		utenteService.save(utente2);
		utenteService.save(utente3);
		
		
		
		comp = competizioneService.getById(1L);
		int eta= 0;
		int counter =0;
		for (Utente element : comp.getListUtenti()) {
			if (element.getGenere().equals(Genere.M)) {
				eta += LocalDate.now().getYear() - element.getDataDiNascita().getYear();
			}
			counter ++;
		}
		System.out.println(eta/counter);
		
		
		
	
		
		
		
		
	


		
		
	}

}
