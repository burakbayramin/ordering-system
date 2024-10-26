package com.orderingsystem.orderservicedomain;

import com.orderingsystem.orderservicedomain.entity.Order;
import com.orderingsystem.orderservicedomain.entity.Shop;
import com.orderingsystem.orderservicedomain.event.OrderCancelledEvent;
import com.orderingsystem.orderservicedomain.event.OrderCreatedEvent;
import com.orderingsystem.orderservicedomain.event.OrderPaidEvent;

import java.util.List;

public interface OrderDomainService {

    OrderCreatedEvent validateAndInitiateOrder(Order order, Shop shop);

    OrderPaidEvent payOrder(Order order);

    void approveOrder(Order order);

    OrderCancelledEvent cancelOrderPayment(Order order, List<String> failureMessages);

    void cancelOrder(Order order, List<String> failureMessages);
}
