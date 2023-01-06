package asw.goodbooks.connessioni.eventpublisher;

import asw.goodbooks.connessioni.api.event.DomainEvent;

public interface ConnessioniEventPublisher {

    public void publish(DomainEvent event);
}
