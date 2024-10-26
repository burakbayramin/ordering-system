package com.orderingsystem.orderservicedomain.valueobject;

import com.orderingsystem.valueobject.BaseId;

import java.util.UUID;

public class TrackingId extends BaseId<UUID> {
    public TrackingId(UUID value) {
        super(value);
    }
}
