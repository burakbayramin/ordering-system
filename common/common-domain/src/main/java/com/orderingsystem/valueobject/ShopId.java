package com.orderingsystem.valueobject;

import java.util.UUID;

public class ShopId extends BaseId<UUID> {
    public ShopId(UUID value) {
        super(value);
    }
}
