package com.orderingsystem.orderservicedomain.ports.output.repository;

import com.orderingsystem.orderservicedomain.entity.Shop;

import java.util.Optional;

public interface ShopRepository {

    Optional<Shop> findShopInformation(Shop shop);
}
