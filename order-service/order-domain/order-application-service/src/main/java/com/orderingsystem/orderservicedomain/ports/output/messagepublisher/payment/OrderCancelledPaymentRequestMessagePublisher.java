package com.orderingsystem.orderservicedomain.ports.output.messagepublisher.payment;

import com.orderingsystem.event.publisher.DomainEventPublisher;
import com.orderingsystem.orderservicedomain.event.OrderCancelledEvent;

public interface OrderCancelledPaymentRequestMessagePublisher extends DomainEventPublisher<OrderCancelledEvent> {
}
