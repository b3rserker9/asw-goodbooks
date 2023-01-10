package asw.goodbooks.recensioniseguite.domain;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*; 
import java.util.stream.*; 

@Service 
public class RecensioniSeguiteService {

	//@Autowired
	//private ConnessioniClientPort connessioniClient;

	//@Autowired
	//private RecensioniClientPort recensioniClient;

	@Autowired
	private ConnessioniConAutoriRepository connessioniConAutoriRepository;

	@Autowired
	private ConnessioniConRecensoriRepository connessioniConRecensoriRepository;

	@Autowired
	private RecensioniRepository recensioniRepository;
	@Autowired
	private RecensioniSeguiteRepository recensioniseguiterepository;

	/* Trova le recensioni seguite da un utente. */ 
	public Collection<RecensioniSeguite> getRecensioniSeguite(String utente) {



		return this.recensioniseguiterepository.findByIdUtente(utente);
	}

	public ConnessioneConAutore saveConnessioneConAutore(String utente, String autore) {
		ConnessioneConAutore connessione = new ConnessioneConAutore(utente, autore);
		connessione = connessioniConAutoriRepository.save(connessione);
		return connessione;
	}

	public ConnessioneConRecensore saveConnessioneConRecensore(String utente, String recensore) {
		ConnessioneConRecensore connessione = new ConnessioneConRecensore(utente, recensore);
		connessione = connessioniConRecensoriRepository.save(connessione);
		return connessione;
	}
	public Collection<ConnessioneConRecensore> getConnessioniConRecensoreByUtente(String utente) {
		Collection<ConnessioneConRecensore> connessioni = connessioniConRecensoriRepository.findByUtente(utente);
		return connessioni;
	}
	public Collection<ConnessioneConAutore> getConnessioniConAutoreByUtente(String utente) {
		Collection<ConnessioneConAutore> connessioni = connessioniConAutoriRepository.findByUtente(utente);
		return connessioni;
	}

	public Recensione saveRecensione(String recensore, String titoloLibro, String autoreLibro, String testoRecensione) {
		Recensione recensione = new Recensione(recensore, titoloLibro, autoreLibro, testoRecensione);
		recensione = recensioniRepository.save(recensione);
		return recensione;
	}

	public Collection<Recensione> getRecensioniByAutori(Collection<String> autori) {
		Collection<Recensione> recensioni = recensioniRepository.findByAutoreLibroIn(autori);
		return recensioni;
	}

	public Collection<Recensione> getRecensioniByRecensori(Collection<String> recensori) {
		Collection<Recensione> recensioni = recensioniRepository.findByRecensoreIn(recensori);
		return recensioni;
	}

	public Collection<Recensione> getRecensioniByAutore(String autore) {
		Collection<Recensione> recensioni = recensioniRepository.findByAutoreLibro(autore);
		return recensioni;
	}

	public Collection<Recensione> getRecensioniByRecensore(String recensore) {
		Collection<Recensione> recensioni = recensioniRepository.findByRecensore(recensore);
		return recensioni;
	}
	public RecensioniSeguite saveRecensioneSeguite(String utente, Recensione r) {
		RecensioniSeguiteId recensioniSeguiteId = new RecensioniSeguiteId(utente,r.getId());
		RecensioniSeguite rs = new RecensioniSeguite(recensioniSeguiteId,r.getRecensore(),r.getTitoloLibro(),r.getAutoreLibro(),r.getTestoRecensione());
		return  recensioniseguiterepository.save(rs);
	}

	public Set<String> getUtentiByAutoriAndUtenti(Recensione recensione){
		Collection<String> utenti = this.connessioniConAutoriRepository.findUtenteByAutore(recensione.getAutoreLibro());
		utenti.addAll(this.connessioniConRecensoriRepository.findUtenteByRecensore(recensione.getRecensore()));
		return new HashSet<String>(utenti);
	}

}
