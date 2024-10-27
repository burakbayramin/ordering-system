package com.orderingsystem.orderservicedomain;

import com.orderingsystem.orderservicedomain.dto.create.CreateOrderCommand;
import com.orderingsystem.orderservicedomain.entity.Customer;
import com.orderingsystem.orderservicedomain.entity.Order;
import com.orderingsystem.orderservicedomain.entity.Shop;
import com.orderingsystem.orderservicedomain.event.OrderCreatedEvent;
import com.orderingsystem.orderservicedomain.exception.OrderDomainException;
import com.orderingsystem.orderservicedomain.mapper.OrderDataMapper;
import com.orderingsystem.orderservicedomain.ports.output.repository.CustomerRepository;
import com.orderingsystem.orderservicedomain.ports.output.repository.OrderRepository;
import com.orderingsystem.orderservicedomain.ports.output.repository.ShopRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class OrderCreateHelper {

    private final OrderDomainService orderDomainService;
    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final ShopRepository shopRepository;
    private final OrderDataMapper orderDataMapper;

    public OrderCreateHelper(OrderDomainService orderDomainService, OrderRepository orderRepository, CustomerRepository customerRepository, ShopRepository shopRepository, OrderDataMapper orderDataMapper) {
        this.orderDomainService = orderDomainService;
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.shopRepository = shopRepository;
        this.orderDataMapper = orderDataMapper;
    }

    @Transactional
    public OrderCreatedEvent persistOrder(CreateOrderCommand createOrderCommand) {
        checkCustomer(createOrderCommand.getCustomerId());
        Shop shop = checkShop(createOrderCommand);
        Order order = orderDataMapper.createOrderCommandToOrder(createOrderCommand);
        OrderCreatedEvent orderCreatedEvent = orderDomainService.validateAndInitiateOrder(order, shop);
        saveOrder(order);
        log.info("Order is created with id: {}", orderCreatedEvent.getOrder().getId().getValue());
        return orderCreatedEvent;
    }

    private Shop checkShop(CreateOrderCommand createOrderCommand) {
        Shop shop = orderDataMapper.createOrderCommandToShop(createOrderCommand);
        Optional<Shop> optionalShop = shopRepository.findShopInformation(shop);
        if (optionalShop.isEmpty()) {
            log.warn("Could not find shop with shop id: {}", createOrderCommand.getShopId());
            throw new OrderDomainException("Could not find restaurant with restaurant id: " +
                    createOrderCommand.getShopId());
        }
        return optionalShop.get();
    }

    private void checkCustomer(UUID customerId) {
        Optional<Customer> customer = customerRepository.findCustomer(customerId);
        if (customer.isEmpty()) {
            log.warn("Could not find customer with customer id: {}", customerId);
            throw new OrderDomainException("Could not find customer with customer id: " + customerId);
        }
    }

    private Order saveOrder(Order order) {
        Order orderResult = orderRepository.save(order);
        if (orderResult == null) {
            log.error("Could not save order!");
            throw new OrderDomainException("Could not save order!");
        }
        log.info("Order is saved with id: {}", orderResult.getId().getValue());
        return orderResult;
    }
}
