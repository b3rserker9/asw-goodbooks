package asw.goodbooks.recensioniseguite.domain;

import asw.goodbooks.common.api.event.DomainEvent;
import asw.goodbooks.recensioni.api.event.RecensioneCreatedEvent;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class EventConsumer {

    private final Logger logger = Logger.getLogger(this.getClass().toString());

    public void onEvent(DomainEvent event) {
        if (event.getClass().equals(RecensioneCreatedEvent.class)) {
            RecensioneCreatedEvent rce = (RecensioneCreatedEvent) event;
            onRecensioneCreated(rce);
        } else {
            logger.info("UNKNOWN EVENT: " + event);
        }
    }

    private void onRecensioneCreated(RecensioneCreatedEvent event) {
        Recensione recensione = new Recensione(event.getRecensore(), event.getTitoloLibro(), event.getAutoreLibro(), event.getTestoRecensione());
        logger.info("Okay funziona tutto okay recensioni ricevuta da evento: " + recensione);
    }

}
