package asw.goodbooks.recensioniseguite.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;

public interface ConnessioneConAutoreRepository extends CrudRepository<ConnessioneConAutore, Long> {
    @Query("SELECT r.autore FROM ConnessioneConAutore r WHERE r.utente = ?1")

    public Collection<String> findAutoreByUtente(String utente);

}
