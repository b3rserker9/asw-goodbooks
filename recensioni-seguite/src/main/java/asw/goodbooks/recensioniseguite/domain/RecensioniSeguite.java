package asw.goodbooks.recensioniseguite.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecensioniSeguite implements Serializable {
   @EmbeddedId
   private RecensioniSeguiteId recensioniSeguiteId;

    private String recensore;

    private String titoloLibro;

    private String autoreLibro;

    private String testoRecensione;
}
