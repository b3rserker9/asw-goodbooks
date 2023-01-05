package asw.goodbooks.recensioniseguite.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;

public interface RecensioneRepository extends CrudRepository<Recensione, Long> {
    public Collection<Recensione> findByAutoreLibro(String autoreLibro);

    public Collection<Recensione> findByRecensore(String recensore);
}
