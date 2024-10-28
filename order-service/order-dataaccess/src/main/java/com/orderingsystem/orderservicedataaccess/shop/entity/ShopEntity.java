package com.orderingsystem.orderservicedataaccess.shop.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@IdClass(ShopEntityId.class)
@Table(name = "shops")
@Entity
public class ShopEntity {

    @Id
    private UUID shopId;

    @Id
    private UUID productId;

    private String shopName;
    private Boolean shopActive;
    private String productName;
    private BigDecimal productPrice;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShopEntity that = (ShopEntity) o;
        return Objects.equals(shopId, that.shopId) && Objects.equals(productId, that.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shopId, productId);
    }
}
