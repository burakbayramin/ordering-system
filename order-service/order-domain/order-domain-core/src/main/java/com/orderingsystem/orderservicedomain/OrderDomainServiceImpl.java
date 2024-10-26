package com.orderingsystem.orderservicedomain;

import com.orderingsystem.orderservicedomain.entity.Order;
import com.orderingsystem.orderservicedomain.entity.Product;
import com.orderingsystem.orderservicedomain.entity.Shop;
import com.orderingsystem.orderservicedomain.event.OrderCancelledEvent;
import com.orderingsystem.orderservicedomain.event.OrderCreatedEvent;
import com.orderingsystem.orderservicedomain.event.OrderPaidEvent;
import com.orderingsystem.orderservicedomain.exception.OrderDomainException;
import lombok.extern.slf4j.Slf4j;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

import static com.orderingsystem.DomainConstants.UTC;


@Slf4j
public class OrderDomainServiceImpl implements OrderDomainService {

    @Override
    public OrderCreatedEvent validateAndInitiateOrder(Order order, Shop shop) {
        validateShop(shop);
        setOrderProductInformation(order, shop);
        order.validateOrder();
        order.initializeOrder();
        log.info("Order with id: {} is initiated", order.getId().getValue());
        return new OrderCreatedEvent(order, ZonedDateTime.now(ZoneId.of(UTC)));
    }

    @Override
    public OrderPaidEvent payOrder(Order order) {
        order.pay();
        log.info("Order with id: {} is paid", order.getId().getValue());
        return new OrderPaidEvent(order, ZonedDateTime.now(ZoneId.of(UTC)));
    }

    @Override
    public void approveOrder(Order order) {
        order.approve();
        log.info("Order with id: {} is approved", order.getId().getValue());
    }

    @Override
    public OrderCancelledEvent cancelOrderPayment(Order order, List<String> failureMessages) {
        order.initCancel(failureMessages);
        log.info("Order payment is cancelling for order id: {}", order.getId().getValue());
        return new OrderCancelledEvent(order, ZonedDateTime.now(ZoneId.of(UTC)));
    }

    @Override
    public void cancelOrder(Order order, List<String> failureMessages) {
        order.cancel(failureMessages);
        log.info("Order with id: {} is cancelled", order.getId().getValue());
    }

    private void validateShop(Shop shop) {
        if (!shop.isActive()) {
            throw new OrderDomainException("Shop with id " + shop.getId().getValue() + " is currently not active!");
        }
    }

    private void setOrderProductInformation(Order order, Shop shop) {
        order.getItems().forEach(orderItem -> shop.getProducts().forEach(shopProduct -> {
            Product currentProduct = orderItem.getProduct();
            if (currentProduct.equals(shopProduct)) {
                currentProduct.updateWithConfirmedNameAndPrice(shopProduct.getName(),
                        shopProduct.getPrice());
            }
        }));
    }
}
