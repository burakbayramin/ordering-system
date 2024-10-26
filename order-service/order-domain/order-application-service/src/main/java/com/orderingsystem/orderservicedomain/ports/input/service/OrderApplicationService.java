package com.orderingsystem.orderservicedomain.ports.input.service;

import com.orderingsystem.orderservicedomain.dto.create.CreateOrderCommand;
import com.orderingsystem.orderservicedomain.dto.create.CreateOrderResponse;
import com.orderingsystem.orderservicedomain.dto.track.TrackOrderQuery;
import com.orderingsystem.orderservicedomain.dto.track.TrackOrderResponse;
import jakarta.validation.Valid;

public interface OrderApplicationService {

    CreateOrderResponse createOrder(@Valid CreateOrderCommand createOrderCommand);

    TrackOrderResponse trackOrder(@Valid TrackOrderQuery trackOrderQuery);
}
