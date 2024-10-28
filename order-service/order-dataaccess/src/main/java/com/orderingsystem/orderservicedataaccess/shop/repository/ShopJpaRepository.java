package com.orderingsystem.orderservicedataaccess.shop.repository;

import com.orderingsystem.orderservicedataaccess.shop.entity.ShopEntity;
import com.orderingsystem.orderservicedataaccess.shop.entity.ShopEntityId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ShopJpaRepository extends JpaRepository<ShopEntity, ShopEntityId> {

    Optional<List<ShopEntity>> findByShopIdAndProductIdIn(UUID shopId, List<UUID> productIds);
}
