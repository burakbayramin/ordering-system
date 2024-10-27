package com.orderingsystem.orderservicedomain;

import com.orderingsystem.orderservicedomain.ports.output.messagepublisher.payment.OrderCancelledPaymentRequestMessagePublisher;
import com.orderingsystem.orderservicedomain.ports.output.messagepublisher.payment.OrderCreatedPaymentRequestMessagePublisher;
import com.orderingsystem.orderservicedomain.ports.output.messagepublisher.shopapproval.OrderPaidShopRequestMessagePublisher;
import com.orderingsystem.orderservicedomain.ports.output.repository.OrderRepository;
import com.orderingsystem.orderservicedomain.ports.output.repository.CustomerRepository;
import com.orderingsystem.orderservicedomain.ports.output.repository.ShopRepository;
import org.mockito.Mockito;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = "com.orderingsystem")
public class OrderTestConfiguration {

    @Bean
    public OrderCreatedPaymentRequestMessagePublisher orderCreatedPaymentRequestMessagePublisher() {
        return Mockito.mock(OrderCreatedPaymentRequestMessagePublisher.class);
    }

    @Bean
    public OrderCancelledPaymentRequestMessagePublisher orderCancelledPaymentRequestMessagePublisher() {
        return Mockito.mock(OrderCancelledPaymentRequestMessagePublisher.class);
    }

    @Bean
    public OrderPaidShopRequestMessagePublisher orderPaidShopRequestMessagePublisher() {
        return Mockito.mock(OrderPaidShopRequestMessagePublisher.class);
    }

    @Bean
    public OrderRepository orderRepository() {
        return Mockito.mock(OrderRepository.class);
    }

    @Bean
    public CustomerRepository customerRepository() {
        return Mockito.mock(CustomerRepository.class);
    }

    @Bean
    public ShopRepository shopRepository() {
        return Mockito.mock(ShopRepository.class);
    }

    @Bean
    public OrderDomainService orderDomainService() {
        return new OrderDomainServiceImpl();
    }
}
