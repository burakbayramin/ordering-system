package com.orderingsystem.orderservicedataaccess.shop.entity;

import lombok.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShopEntityId implements Serializable {

    private UUID shopId;
    private UUID productId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShopEntityId that = (ShopEntityId) o;
        return Objects.equals(shopId, that.shopId) && Objects.equals(productId, that.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shopId, productId);
    }
}
