package com.orderingsystem.orderservicedomain.ports.output.messagepublisher.shopapproval;


import com.orderingsystem.event.publisher.DomainEventPublisher;
import com.orderingsystem.orderservicedomain.event.OrderPaidEvent;

public interface OrderPaidShopRequestMessagePublisher extends DomainEventPublisher<OrderPaidEvent> {
}
