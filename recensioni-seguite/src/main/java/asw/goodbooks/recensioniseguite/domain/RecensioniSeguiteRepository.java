package asw.goodbooks.recensioniseguite.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface RecensioniSeguiteRepository extends CrudRepository<RecensioniSeguite, RecensioniSeguiteId> {

    Collection<RecensioniSeguite> findByRecensioniSeguiteId_Utente(String utente);
}
