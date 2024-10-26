package com.orderingsystem.orderservicedomain.valueobject;

import com.orderingsystem.valueobject.BaseId;

public class OrderItemId extends BaseId<Long> {
    public OrderItemId(Long value) {
        super(value);
    }
}
