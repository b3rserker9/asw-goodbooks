package asw.goodbooks.recensioniseguite.eventlistener;

import asw.goodbooks.common.api.event.DomainEvent;
import asw.goodbooks.recensioniseguite.domain.EventConsumer;
import asw.goodbooks.recensioni.api.event.RecensioniServiceEventChannel;
import asw.goodbooks.connessioni.api.event.ConnessioneEventChannel;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import java.util.logging.Logger;

@Component
public class EventKafkaListener {

    private final Logger logger = Logger.getLogger(this.getClass().toString());

    @Autowired
    private EventConsumer eventConsumer;

    @KafkaListener(topics = { RecensioniServiceEventChannel.channel, ConnessioneEventChannel.channel})
    public void listen(ConsumerRecord<String, DomainEvent> record) throws Exception {
        logger.info("EVENT LISTENER: " + record.toString());
        DomainEvent event = record.value();
        eventConsumer.onEvent(event);
    }

}
