package asw.goodbooks.recensioniseguite.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface ConnessioniConAutoriRepository extends CrudRepository<ConnessioneConAutore, Long> {

    public Collection<ConnessioneConAutore> findAll();

    public Collection<ConnessioneConAutore> findByUtente(String utente);

    @Query ("SELECT a.utente FROM ConnessioneConAutore a WHERE a.autore = ?1")
    public Collection<String> findUtenteByAutore(String autore);
}
