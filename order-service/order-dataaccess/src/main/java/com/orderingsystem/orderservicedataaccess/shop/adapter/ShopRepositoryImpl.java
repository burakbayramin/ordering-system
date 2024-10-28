package com.orderingsystem.orderservicedataaccess.shop.adapter;

import com.orderingsystem.orderservicedataaccess.shop.entity.ShopEntity;
import com.orderingsystem.orderservicedataaccess.shop.mapper.ShopDataAccessMapper;
import com.orderingsystem.orderservicedataaccess.shop.repository.ShopJpaRepository;
import com.orderingsystem.orderservicedomain.entity.Shop;
import com.orderingsystem.orderservicedomain.ports.output.repository.ShopRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ShopRepositoryImpl implements ShopRepository {

    private final ShopJpaRepository shopJpaRepository;
    private final ShopDataAccessMapper shopDataAccessMapper;

    public ShopRepositoryImpl(ShopJpaRepository shopJpaRepository, ShopDataAccessMapper shopDataAccessMapper) {
        this.shopJpaRepository = shopJpaRepository;
        this.shopDataAccessMapper = shopDataAccessMapper;
    }

    @Override
    public Optional<Shop> findShopInformation(Shop shop) {
        List<UUID> shopProducts =
                shopDataAccessMapper.shopToShopProducts(shop);
        Optional<List<ShopEntity>> shopEntities = shopJpaRepository
                .findByShopIdAndProductIdIn(shop.getId().getValue(), shopProducts);
        return shopEntities.map(shopDataAccessMapper::shopEntityToShop);
    }
}
