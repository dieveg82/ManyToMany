package dieveg.demo;

import dieveg.demo.model.Competizione;
import dieveg.demo.model.Utente;
import dieveg.demo.service.CompetizioneService;
import dieveg.demo.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

import static dieveg.demo.model.Genere.FEMALE;
import static dieveg.demo.model.Genere.MALE;

@Component
public class Run implements CommandLineRunner{

	@Autowired
    UtenteService utenteService;
	
	@Autowired 
	CompetizioneService competizioneService;
	
	@Override
	public void run(String... args) throws Exception {

		// creo gli alcuni utenti
		Utente diego = Utente.builder()
				.id(1L)
				.nome("Diego")
				.cognome("Cappai")
				.dataDiNascita(LocalDate.of(1982, 3, 12))
				.genere(MALE)
				.build();
		utenteService.save(diego);
		Utente beniamino = Utente.builder()
				.id(2L)
				.nome("Beniamino")
				.cognome("Cappai")
				.dataDiNascita(LocalDate.of(1946, 6, 16))
				.genere(MALE)
				.build();
		utenteService.save(beniamino);
		Utente gabriella = Utente.builder()
				.id(3L)
				.nome("Gabriella")
				.cognome("Cappai")
				.dataDiNascita(LocalDate.of(1973, 9, 17))
				.genere(FEMALE)
				.build();
		utenteService.save(gabriella);

		// creo alcune competizioni
		Competizione maratonaDiAssemini = Competizione.builder()
				.id(1L)
				.dataCompetizione(LocalDate.of(2022, 3, 12))
				.descrizione("Maratona di Assemini")
				.build();
		competizioneService.save (maratonaDiAssemini);
		Competizione cagliariRespira = Competizione.builder()
				.id(2L)
				.dataCompetizione(LocalDate.of(2022, 12, 1))
				.descrizione("Cagliari Respira")
				.build();
		competizioneService.save (cagliariRespira);

	
		// iscrivo tutti gli utenti alla maratona di assemini
		maratonaDiAssemini.setIscritti(List.of(diego, beniamino, gabriella));
		competizioneService.save(maratonaDiAssemini);

		// iscrivo diego e gabriella alla maratona di cagliari
		cagliariRespira.setIscritti(List.of(diego, gabriella));
		competizioneService.save(cagliariRespira);

		int eta= 0;
		int counter =0;
		for (Utente element : maratonaDiAssemini.getIscritti()) {
			if (element.getGenere().equals(MALE)) {
				eta += LocalDate.now().getYear() - element.getDataDiNascita().getYear();
				counter ++;
			}
			
		}
		System.out.println(eta/counter);
		
		
		
	
		
		
		
		
	


		
		
	}

}
