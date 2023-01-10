package asw.goodbooks.recensioniseguite.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface RecensioniSeguiteRepository extends CrudRepository<RecensioniSeguite, RecensioniSeguiteId> {


    public Collection<RecensioniSeguite> findByIdUtente(String utente);


}
