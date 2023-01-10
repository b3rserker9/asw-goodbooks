package asw.goodbooks.recensioniseguite.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface ConnessioniConRecensoriRepository extends CrudRepository<ConnessioneConRecensore, Long> {

    public Collection<ConnessioneConRecensore> findAll();

    public Collection<ConnessioneConRecensore> findByUtente(String utente);

    @Query("SELECT r.utente FROM ConnessioneConRecensore r WHERE r.recensore = ?1")
    public Collection<String> findUtenteByRecensore(String recensore);
}
