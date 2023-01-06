package asw.goodbooks.connessioni.api.event;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConnessioneConAutoreCreatedEvent implements DomainEvent {
    private String utente;
    private String autore;

}
