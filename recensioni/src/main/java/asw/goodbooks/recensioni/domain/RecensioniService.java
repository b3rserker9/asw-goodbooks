package asw.goodbooks.recensioni.domain;

import asw.goodbooks.recensioni.event.DomainEvent;
import asw.goodbooks.recensioni.api.event.RecensioniCreatedEvent;
import asw.goodbooks.recensioni.eventpublisher.RecensioniEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*; 

@Service
public class RecensioniService {

	@Autowired
	private RecensioniRepository recensioniRepository;

	@Autowired
	private RecensioniEventPublisher recensioniEventPublisher;



 	public Recensione createRecensione(String recensore, String titoloLibro, String autoreLibro, String testoRecensione) {
		Recensione recensione = new Recensione(recensore, titoloLibro, autoreLibro, testoRecensione); 
		recensione = recensioniRepository.save(recensione);
		DomainEvent event = new RecensioniCreatedEvent(recensione.getId(),
														recensione.getRecensore(),
														recensione.getTitoloLibro(),
														recensione.getAutoreLibro(),
														recensione.getTestoRecensione());
		recensioniEventPublisher.publish(event);
		return recensione;
	}

 	public Recensione getRecensione(Long id) {
		Recensione recensione = recensioniRepository.findById(id).orElse(null);
		return recensione;
	}

	public Collection<Recensione> getRecensioni() {
		Collection<Recensione> recensioni = recensioniRepository.findAll();
		return recensioni;
	}

	public Collection<Recensione> getRecensioniByRecensore(String recensore) {
		Collection<Recensione> recensioni = recensioniRepository.findByRecensore(recensore);
		return recensioni;
	}

	public Collection<Recensione> getRecensioniByRecensori(Collection<String> recensori) {
		Collection<Recensione> recensioni = recensioniRepository.findByRecensoreIn(recensori);
		return recensioni;
	}

	public Collection<Recensione> getRecensioniByTitolo(String titolo) {
		Collection<Recensione> recensioni = recensioniRepository.findByTitoloLibro(titolo);
		return recensioni;
	}

	public Collection<Recensione> getRecensioniByAutore(String autore) {
		Collection<Recensione> recensioni = recensioniRepository.findByAutoreLibro(autore);
		return recensioni;
	}

	public Collection<Recensione> getRecensioniByAutori(Collection<String> autori) {
		Collection<Recensione> recensioni = recensioniRepository.findByAutoreLibroIn(autori);
		return recensioni;
	}





}
