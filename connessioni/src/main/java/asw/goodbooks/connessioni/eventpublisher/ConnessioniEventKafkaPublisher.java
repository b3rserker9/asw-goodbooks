package asw.goodbooks.connessioni.eventpublisher;

import asw.goodbooks.connessioni.api.event.ConnessioniEventChannel;
import asw.goodbooks.connessioni.api.event.DomainEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class ConnessioniEventKafkaPublisher implements ConnessioniEventPublisher{

    private final Logger logger = Logger.getLogger(this.getClass().toString());

    @Autowired
    private KafkaTemplate<String, DomainEvent> template;

    private String channel = ConnessioniEventChannel.channel;

    @Override
    public void publish(DomainEvent event){
        logger.info("EVENTO PUBBLICATO: " + event.toString() + " SUL CANALE: " + channel);
        template.send(channel, event);
    }



}
