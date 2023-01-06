package asw.goodbooks.recensioni.eventpublisher;

import asw.goodbooks.recensioni.event.DomainEvent;

public interface RecensioniEventPublisher {

    public void publish(DomainEvent event);
}
