package asw.goodbooks.recensioni.domain;

import asw.goodbooks.common.api.event.DomainEvent;
public interface RecensioniEventPublisher {
    public void publish(DomainEvent event);
}
