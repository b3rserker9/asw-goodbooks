package asw.goodbooks.recensioniseguite.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;
@Embeddable
@Data
@AllArgsConstructor@NoArgsConstructor
public class RecensioniSeguiteId implements Serializable {


    private String utente;

    private Long recensoreid;


}
