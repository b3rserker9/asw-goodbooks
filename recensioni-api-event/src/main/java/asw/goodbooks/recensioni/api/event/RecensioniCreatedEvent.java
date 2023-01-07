package asw.goodbooks.recensioni.api.event;

import asw.goodbooks.common.api.event.DomainEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecensioniCreatedEvent implements DomainEvent {

    private Long id;
    private String recensore;
    private String titoloLibro;
    private String autoreLibro;
    private String testoRecensione;

}
