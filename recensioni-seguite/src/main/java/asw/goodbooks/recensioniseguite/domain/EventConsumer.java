package asw.goodbooks.recensioniseguite.domain;

import asw.goodbooks.common.api.event.DomainEvent;
import asw.goodbooks.connessioni.api.event.ConnessioneConAutoreCreatedEvent;
import asw.goodbooks.connessioni.api.event.ConnessioneConRecensoreCreatedEvent;
import asw.goodbooks.recensioni.api.event.RecensioneCreatedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Logger;

@Service
public class EventConsumer {

    private final Logger logger = Logger.getLogger(this.getClass().toString());
    @Autowired
    private RecensioniSeguiteService recensioniseguiteservice;

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
        Recensione recensione = this.recensioniseguiteservice.saveRecensione(event.getRecensore(), event.getTitoloLibro(), event.getAutoreLibro(), event.getTestoRecensione());
        logger.info("RECIVED EVENT FROM RECEZIONI: " + recensione);
        logger.info("Saving data into Database ");
        for( String u : this.recensioniseguiteservice.getUtentiByAutoriAndUtenti(recensione)){
            this.recensioniseguiteservice.saveRecensioneSeguite(u,recensione);
        }
        logger.info("saved successfully ");

    }

    private void onConnessioneConAutoreCreated(ConnessioneConAutoreCreatedEvent event) {
        ConnessioneConAutore connessioneConAutore = this.recensioniseguiteservice.saveConnessioneConAutore(event.getUtente(), event.getAutore());
        logger.info("RECIVED EVENT FROM CONNESSIONI CON AUTORE: " + connessioneConAutore);
        logger.info("Saving data into Database ");
        Collection<Recensione> re = this.recensioniseguiteservice.getRecensioniByAutore(connessioneConAutore.getAutore());
        for( Recensione r : re){
            this.recensioniseguiteservice.saveRecensioneSeguite(connessioneConAutore.getUtente(), r);
        }
        logger.info("saved successfully ");

    }

    private void onConnessioneConRecensoreCreated(ConnessioneConRecensoreCreatedEvent event) {
        ConnessioneConRecensore connessioneConRecensore = this.recensioniseguiteservice.saveConnessioneConRecensore(event.getUtente(), event.getRecensore());
        logger.info("RECIVED EVENT FROM CONNESSIONI CON RECENSORE: " + connessioneConRecensore);
        logger.info("Saving data into Database ");
        Collection<Recensione> re = this.recensioniseguiteservice.getRecensioniByRecensore(connessioneConRecensore.getRecensore());
        for( Recensione r : re){
            this.recensioniseguiteservice.saveRecensioneSeguite(connessioneConRecensore.getUtente(), r);
        }
        logger.info("saved successfully ");
    }

}
