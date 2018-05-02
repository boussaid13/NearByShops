package com.nearByShops.NearByShops.repositories;

import java.util.Date;
import java.util.List;

import com.nearByShops.NearByShops.models.Shop;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ShopRepository extends MongoRepository<Shop, String> {

    List<Shop> findByIsLikedTrue();
    List<Shop> findByLocationNearAndIsLikedFalseAndShownAfterBefore(Point refPoint,Date dateNow);

}