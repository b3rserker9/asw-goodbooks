package asw.goodbooks.recensioniseguite.domain;

import asw.goodbooks.common.api.event.DomainEvent;
import asw.goodbooks.connessioni.api.event.ConnessioneConAutoreCreatedEvent;
import asw.goodbooks.connessioni.api.event.ConnessioneConRecensoreCreatedEvent;
import asw.goodbooks.recensioni.api.event.RecensioneCreatedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class EventConsumer {

    @Autowired
    private RecensioniSeguiteService recensioniSeguiteService;
    private final Logger logger = Logger.getLogger(this.getClass().toString());

    public void onEvent(DomainEvent event) {
        if (event.getClass().equals(RecensioneCreatedEvent.class)) {
            RecensioneCreatedEvent rce = (RecensioneCreatedEvent) event;
            onRecensioneCreated(rce);
        }
        else if(event.getClass().equals(ConnessioneConAutoreCreatedEvent.class)){
            ConnessioneConAutoreCreatedEvent cna = (ConnessioneConAutoreCreatedEvent) event;
            onConnessioneConAutoreCreated(cna);
        }
        else if(event.getClass().equals(ConnessioneConRecensoreCreatedEvent.class)){
            ConnessioneConRecensoreCreatedEvent cnr = (ConnessioneConRecensoreCreatedEvent) event;
            onConnessioneConRecensoreCreated(cnr);
        }
        else {
            logger.info("UNKNOWN EVENT: " + event);
        }
    }

    private void onRecensioneCreated(RecensioneCreatedEvent event) {
        Recensione recensione = this.recensioniSeguiteService.addRecensione(event.getRecensore(), event.getTitoloLibro(), event.getAutoreLibro(), event.getTestoRecensione());
        logger.info("Recensione ricevuta da evento e salvata nel db " + recensione);
    }

    private void onConnessioneConAutoreCreated(ConnessioneConAutoreCreatedEvent event) {
        ConnessioneConAutore connessioneConAutore = this.recensioniSeguiteService.addConnessioneConAutore(event.getUtente(), event.getAutore());
        logger.info("Connessione con autore ricevuta da evento e salvata nel db " + connessioneConAutore);
    }

    private void onConnessioneConRecensoreCreated(ConnessioneConRecensoreCreatedEvent event) {
        ConnessioneConRecensore connessioneConRecensore = this.recensioniSeguiteService.addConnessioneConRecensore(event.getUtente(), event.getRecensore());
        logger.info("Connessione con recensore ricevuta da evento e salvata nel db " + connessioneConRecensore);
    }

}
