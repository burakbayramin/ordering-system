package com.orderingsystem.orderservicedomain.mapper;

import com.orderingsystem.orderservicedomain.dto.create.CreateOrderCommand;
import com.orderingsystem.orderservicedomain.dto.create.CreateOrderResponse;
import com.orderingsystem.orderservicedomain.dto.create.OrderAddress;
import com.orderingsystem.orderservicedomain.dto.message.CustomerModel;
import com.orderingsystem.orderservicedomain.dto.track.TrackOrderResponse;
import com.orderingsystem.orderservicedomain.entity.*;
import com.orderingsystem.orderservicedomain.event.OrderCreatedEvent;
import com.orderingsystem.orderservicedomain.event.OrderPaidEvent;
import com.orderingsystem.orderservicedomain.valueobject.StreetAddress;
import com.orderingsystem.valueobject.CustomerId;
import com.orderingsystem.valueobject.Money;
import com.orderingsystem.valueobject.ProductId;
import com.orderingsystem.valueobject.ShopId;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class OrderDataMapper {

    public Shop createOrderCommandToShop(CreateOrderCommand createOrderCommand) {
        return Shop.builder()
                .shopId(new ShopId(createOrderCommand.getShopId()))
                .products(createOrderCommand.getItems().stream().map(orderItem ->
                        new Product(new ProductId(orderItem.getProductId())))
                        .collect(Collectors.toList()))
                .build();
    }
    
    public Order createOrderCommandToOrder(CreateOrderCommand createOrderCommand) {
        return Order.builder()
                .customerId(new CustomerId(createOrderCommand.getCustomerId()))
                .shopId(new ShopId(createOrderCommand.getShopId()))
                .deliveryAddress(orderAddressToStreetAddress(createOrderCommand.getAddress()))
                .price(new Money(createOrderCommand.getPrice()))
                .items(orderItemsToOrderItemEntities(createOrderCommand.getItems()))
                .build();
    }

    public CreateOrderResponse orderToCreateOrderResponse(Order order, String message) {
        return CreateOrderResponse.builder()
                .orderTrackingId(order.getTrackingId().getValue())
                .orderStatus(order.getOrderStatus())
                .message(message)
                .build();
    }

    public TrackOrderResponse orderToTrackOrderResponse(Order order) {
        return TrackOrderResponse.builder()
                .orderTrackingId(order.getTrackingId().getValue())
                .orderStatus(order.getOrderStatus())
                .failureMessages(order.getFailureMessages())
                .build();
    }

    public Customer customerModelToCustomer(CustomerModel customerModel) {
        return new Customer(new CustomerId(UUID.fromString(customerModel.getId())),
                customerModel.getUsername(),
                customerModel.getFirstName(),
                customerModel.getLastName());
    }

    private List<OrderItem> orderItemsToOrderItemEntities(
            List<com.orderingsystem.orderservicedomain.dto.create.OrderItem> orderItems) {
        return orderItems.stream()
                .map(orderItem ->
                        OrderItem.builder()
                                .product(new Product(new ProductId(orderItem.getProductId())))
                                .price(new Money(orderItem.getPrice()))
                                .quantity(orderItem.getQuantity())
                                .subTotal(new Money(orderItem.getSubTotal()))
                                .build()).collect(Collectors.toList());
    }

    private StreetAddress orderAddressToStreetAddress(OrderAddress orderAddress) {
        return new StreetAddress(
                UUID.randomUUID(),
                orderAddress.getStreet(),
                orderAddress.getPostalCode(),
                orderAddress.getCity()
        );
    }
}
