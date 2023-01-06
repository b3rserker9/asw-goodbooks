package asw.goodbooks.recensioniseguite.domain;

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

	/* Trova le recensioni seguite da un utente. */ 
	public Collection<Recensione> getRecensioniSeguite(String utente) {
		Collection<Recensione> recensioniSeguite = new TreeSet<>();
		
		Collection<ConnessioneConAutore> connessioniConAutore = connessioniClient.getConnessioniConAutoreByUtente(utente); 
		Collection<String> autoriSeguiti = this.connessioneConAutoreRepository.findAutoreByUtente(utente);
		if (autoriSeguiti.size()>0) {
			for(String r : autoriSeguiti){
				Collection<Recensione> recensioniDiAutori = new TreeSet<>();
				recensioniDiAutori = this.recensioneRepository.findByAutoreLibro(r);
				recensioniSeguite.addAll(recensioniDiAutori);
			}

		}
		
		Collection<ConnessioneConRecensore> connessioniConRecensore = connessioniClient.getConnessioniConRecensoreByUtente(utente); 
		Collection<String> recensoriSeguiti = this.connessioneConRecensoreRepository.findRecensoriByUtente(utente);
		if (recensoriSeguiti.size()>0) {
			for (String r : recensoriSeguiti) {
				Collection<Recensione> recensioniDiRecensori = new TreeSet<>();
				recensioniDiRecensori = this.recensioneRepository.findByRecensore(r);
				recensioniSeguite.addAll(recensioniDiRecensori);
			}
		}
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

}
