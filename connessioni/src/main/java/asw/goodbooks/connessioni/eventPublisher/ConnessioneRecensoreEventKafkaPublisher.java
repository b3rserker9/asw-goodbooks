package asw.goodbooks.connessioni.eventPublisher;

import asw.goodbooks.common.api.event.DomainEvent;
import asw.goodbooks.connessioni.api.event.ConnessioneConRecensoreEventChannel;
import asw.goodbooks.connessioni.domain.ConnessioniEventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

//@Component
public class ConnessioneRecensoreEventKafkaPublisher //implements ConnessioniEventPublisher
 {


    private final Logger logger = Logger.getLogger(this.getClass().toString());
    @Autowired
    private KafkaTemplate<String, DomainEvent> template;

    private String channel = ConnessioneConRecensoreEventChannel.channel;

    //@Override
    public void publish(DomainEvent event) {
        logger.info("EVENT PUBLISHER: " + event.toString() + " ON CHANNEL: " + channel);
        template.send(channel, event);
    }

}



