package asw.goodbooks.recensioni.eventPublisher;

import asw.goodbooks.common.api.event.DomainEvent;
import asw.goodbooks.recensioni.domain.RecensioniEventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.kafka.core.KafkaTemplate;
import asw.goodbooks.recensioni.api.event.RecensioniServiceEventChannel;

import java.util.logging.Logger;

@Component
public class RecensioneCreatedEventKafkaPublisher implements RecensioniEventPublisher {


    private final Logger logger = Logger.getLogger(this.getClass().toString());
    @Autowired
    private KafkaTemplate<String, DomainEvent> template;

    private String channel = RecensioniServiceEventChannel.channel;

    @Override
    public void publish(DomainEvent event) {
        logger.info("EVENT PUBLISHER: " + event.toString() + " ON CHANNEL: " + channel);
        template.send(channel, event);
    }
}
