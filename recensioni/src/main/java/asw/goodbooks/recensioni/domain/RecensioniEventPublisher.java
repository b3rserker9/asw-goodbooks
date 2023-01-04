package asw.goodbooks.recensioni.domain;

import asw.goodbooks.recensioni.event.DomainEvent;

public interface RecensioniEventPublisher {

    public void publish(DomainEvent event);
}
