package com.orderingsystem.event.publisher;

import com.orderingsystem.event.DomainEvent;

public interface DomainEventPublisher<T extends DomainEvent> {

    void publish(T domainEvent);
}
