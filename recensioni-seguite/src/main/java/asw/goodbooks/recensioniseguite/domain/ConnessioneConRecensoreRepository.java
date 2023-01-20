package asw.goodbooks.recensioniseguite.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;

public interface ConnessioneConRecensoreRepository extends CrudRepository<ConnessioneConRecensore, Long> {
    @Query("SELECT c.recensore FROM ConnessioneConRecensore c WHERE c.utente = ?1")
    public List<String> findRecensoriByUtente(String utente);
    @Query("SELECT r.utente FROM ConnessioneConRecensore r WHERE r.recensore = ?1")

    public Collection<String> findUtenteByRecensore(String recensore);

}
