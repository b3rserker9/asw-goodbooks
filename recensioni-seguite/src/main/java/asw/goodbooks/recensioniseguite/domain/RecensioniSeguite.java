package asw.goodbooks.recensioniseguite.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class RecensioniSeguite {


    @EmbeddedId
    private RecensioniSeguiteId id;

    private String Recensore;
    private String titoloLibro;
    private String autoreLibro;
    private String testoRecensione;


}
