package com.orderingsystem.orderservicedomain.ports.output.repository;

import com.orderingsystem.orderservicedomain.entity.Order;
import com.orderingsystem.orderservicedomain.valueobject.TrackingId;

import java.util.Optional;

public interface OrderRepository {

    Order save(Order order);

    Optional<Order> findByTrackingId(TrackingId trackingId);
}
