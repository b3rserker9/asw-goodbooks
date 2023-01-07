package asw.goodbooks.connessioni.api.event;


import asw.goodbooks.common.api.event.DomainEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConnessioneConRecensoreCreatedEvent implements DomainEvent {
    private String utente;
    private String recensore;
}
