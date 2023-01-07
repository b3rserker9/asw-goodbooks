package asw.goodbooks.connessioni.domain;


import asw.goodbooks.common.api.event.DomainEvent;

public interface ConnessioniEventPublisher {

    public void publish(DomainEvent event);
}
