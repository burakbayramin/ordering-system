package com.orderingsystem.orderservicedomain.ports.output.messagepublisher.payment;

import com.orderingsystem.event.publisher.DomainEventPublisher;
import com.orderingsystem.orderservicedomain.event.OrderCreatedEvent;

public interface OrderCreatedPaymentRequestMessagePublisher extends DomainEventPublisher<OrderCreatedEvent> {
}
