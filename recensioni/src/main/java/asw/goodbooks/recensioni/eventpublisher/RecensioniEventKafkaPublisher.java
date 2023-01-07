package asw.goodbooks.recensioni.eventpublisher;

import asw.goodbooks.common.api.event.DomainEvent;

import asw.goodbooks.recensioni.api.event.RecensioniEventChannel;
import asw.goodbooks.recensioni.domain.RecensioniEventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class RecensioniEventKafkaPublisher implements RecensioniEventPublisher {

    private final Logger logger = Logger.getLogger(this.getClass().toString());

    @Autowired
    private KafkaTemplate<String, DomainEvent> template;

    private String channel = RecensioniEventChannel.channel;

    @Override
    public void publish(DomainEvent event){
        logger.info("EVENTO PUBBLICATO: " + event.toString() + " SUL CANALE: " + channel);
        template.send(channel, event);

    }

}
