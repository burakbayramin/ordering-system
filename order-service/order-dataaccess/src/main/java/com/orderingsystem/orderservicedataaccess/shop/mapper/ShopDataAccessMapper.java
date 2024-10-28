package com.orderingsystem.orderservicedataaccess.shop.mapper;

import com.orderingsystem.orderservicedataaccess.shop.entity.ShopEntity;
import com.orderingsystem.orderservicedataaccess.shop.exception.ShopDataAccessException;
import com.orderingsystem.orderservicedomain.entity.Product;
import com.orderingsystem.orderservicedomain.entity.Shop;
import com.orderingsystem.valueobject.Money;
import com.orderingsystem.valueobject.ProductId;
import com.orderingsystem.valueobject.ShopId;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class ShopDataAccessMapper {

    public List<UUID> shopToShopProducts(Shop shop) {
        return shop.getProducts().stream()
                .map(product -> product.getId().getValue())
                .collect(Collectors.toList());
    }

    public Shop shopEntityToShop(List<ShopEntity> shopEntities) {
        ShopEntity shopEntity =
                shopEntities.stream().findFirst().orElseThrow(() ->
                        new ShopDataAccessException("Shop could not be found!"));

        List<Product> shopProducts = shopEntities.stream().map(entity ->
                new Product(new ProductId(entity.getProductId()), entity.getProductName(),
                        new Money(entity.getProductPrice())))
                .collect(Collectors.toList());

        return Shop.builder()
                .shopId(new ShopId(shopEntity.getShopId()))
                .products(shopProducts)
                .active(shopEntity.getShopActive())
                .build();
    }
}
