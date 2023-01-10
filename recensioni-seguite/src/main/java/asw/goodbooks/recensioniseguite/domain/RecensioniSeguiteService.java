package asw.goodbooks.recensioniseguite.domain;

import asw.goodbooks.common.api.event.DomainEvent;
import asw.goodbooks.connessioni.api.event.ConnessioneConAutoreCreatedEvent;
import asw.goodbooks.connessioni.api.event.ConnessioneConRecensoreCreatedEvent;
import asw.goodbooks.recensioni.api.event.RecensioneCreatedEvent;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*; 
import java.util.stream.*; 

@Service 
public class RecensioniSeguiteService {

	@Autowired 
	private ConnessioniClientPort connessioniClient;

	@Autowired 
	private RecensioniClientPort recensioniClient;

	@Autowired
	private RecensioneRepository recensioneRepository;

	@Autowired
	private ConnessioneConAutoreRepository connessioneConAutoreRepository;

	@Autowired
	private ConnessioneConRecensoreRepository connessioneConRecensoreRepository;

	@Autowired
	private RecensioniSeguiteRepository recensioniSeguiteRepository;

	/* Trova le recensioni seguite da un utente. */
	/* ovvero le recensioni dei recensori e degli autori di libri seguiti da quell’utente  */

	public Collection<Recensione> getRecensioniSeguite(String utente) {
		Collection<Recensione> recensioniSeguite = new ArrayList<>();
		
		/*Collection<String> autoriSeguiti = this.connessioneConAutoreRepository.findAutoreByUtente(utente);
		if (autoriSeguiti.size()>0) {
			for (String r : autoriSeguiti) {
				Collection<Recensione> recensioniDiAutori = new TreeSet<>();
				recensioniDiAutori = this.recensioneRepository.findByAutoreLibro(r);
				recensioniSeguite.addAll(recensioniDiAutori);
			}
		}
		
		Collection<String> recensoriSeguiti = this.connessioneConRecensoreRepository.findRecensoriByUtente(utente);
		if (recensoriSeguiti.size()>0) {
			for(String r:recensoriSeguiti){
				Collection<Recensione> recensioniDiRecensori = new TreeSet<>();
				recensioniDiRecensori =	this.recensioneRepository.findByRecensore(r);
				recensioniSeguite.addAll(recensioniDiRecensori);
			}
		}*/
		recensioniSeguite = (ArrayList) recensioniSeguiteRepository.findByRecensioniSeguiteId_Utente(utente);


		return recensioniSeguite; 
	}

	public Recensione addRecensione(String recensore, String titoloLibro, String autoreLibro, String testoRecensione) {
		Recensione recensione = new Recensione(recensore, titoloLibro, autoreLibro, testoRecensione);
		recensione = recensioneRepository.save(recensione);
		return recensione;
	}

	public ConnessioneConRecensore addConnessioneConRecensore(String utente, String recensore) {
		ConnessioneConRecensore connessione = new ConnessioneConRecensore(utente, recensore);
		connessione = connessioneConRecensoreRepository.save(connessione);
		return connessione;
	}

	public ConnessioneConAutore addConnessioneConAutore(String utente, String autore) {
		ConnessioneConAutore connessione = new ConnessioneConAutore(utente, autore);
		connessione = connessioneConAutoreRepository.save(connessione);
		return connessione;
	}

	public Collection<String> getUtentiFromAutore(String autore){
		Collection<String> utenti = connessioneConAutoreRepository.findUtenteByAutore(autore);
		return utenti;
	}

	public Collection<String> getUtentiFromRecensore(String autore){
		Collection<String> utenti = connessioneConRecensoreRepository.findUtenteByRecensore(autore);
		return utenti;
	}

	public RecensioniSeguite addRecensioniSeguite(String utente, Long idRecensione, String recensore, String titoloLibro, String autoreLibro, String testoRecensione){
		RecensioniSeguiteId recensioniSeguiteId = new RecensioniSeguiteId(utente, idRecensione);
		RecensioniSeguite recensioniSeguite = new RecensioniSeguite(recensioniSeguiteId, recensore, titoloLibro, autoreLibro, testoRecensione);
		recensioniSeguite = recensioniSeguiteRepository.save(recensioniSeguite);
		return recensioniSeguite;
	}

}
