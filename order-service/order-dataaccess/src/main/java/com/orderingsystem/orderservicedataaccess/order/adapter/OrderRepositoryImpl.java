package com.orderingsystem.orderservicedataaccess.order.adapter;

import com.orderingsystem.orderservicedataaccess.order.mapper.OrderDataAccessMapper;
import com.orderingsystem.orderservicedataaccess.order.repository.OrderJpaRepository;
import com.orderingsystem.orderservicedomain.entity.Order;
import com.orderingsystem.orderservicedomain.ports.output.repository.OrderRepository;
import com.orderingsystem.orderservicedomain.valueobject.TrackingId;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class OrderRepositoryImpl implements OrderRepository {

    private final OrderJpaRepository orderJpaRepository;
    private final OrderDataAccessMapper orderDataAccessMapper;

    public OrderRepositoryImpl(OrderJpaRepository orderJpaRepository, OrderDataAccessMapper orderDataAccessMapper) {
        this.orderJpaRepository = orderJpaRepository;
        this.orderDataAccessMapper = orderDataAccessMapper;
    }

    @Override
    public Order save(Order order) {
        return orderDataAccessMapper.orderEntityToOrder(orderJpaRepository.save(orderDataAccessMapper.orderToOrderEntity(order)));
    }

    @Override
    public Optional<Order> findByTrackingId(TrackingId trackingId) {
        return orderJpaRepository.findByTrackingId(trackingId.getValue()).map(orderDataAccessMapper::orderEntityToOrder);
    }
}
