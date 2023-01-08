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
    @Id
    private String utente;

   @Id
    private Long idRecensione;

    private String recensore;

    private String titoloLibro;

    private String autoreLibro;

    private String testoRecensione;
}
