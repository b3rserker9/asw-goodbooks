package asw.goodbooks.recensioni.event;

import asw.goodbooks.recensioni.event.DomainEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecensioniCreatedEvent implements DomainEvent{

    private Long id;
    private String recensore;
    private String titoloLibro;
    private String autoreLibro;
    private String testoRecensione;

}
