package asw.goodbooks.recensioniseguite.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;

public interface ConnessioneConAutoreRepository extends CrudRepository<ConnessioneConAutore, Long> {
    @Query("SELECT r.utente FROM ConnessioneConAutore r WHERE r.autore = ?1")

    public Collection<String> findUtenteByAutore(String autore);

}
