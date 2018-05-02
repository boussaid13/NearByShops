package com.nearByShops.NearByShops.services;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

import com.nearByShops.NearByShops.models.Shop;
import com.nearByShops.NearByShops.repositories.ShopRepository;

@Service
public class ShopService implements ShopServiceImpl {

    @Autowired
    ShopRepository shopRepository;

    // A reference point : this point in located in Agadir city
    Point refPoint=new Point(-9, 30);


    @Override
    public List<Shop> findNearbyShops() {

        return shopRepository.findByLocationNearAndIsLikedFalseAndShownAfterBefore(refPoint,new Date());
    }

    @Override
    public List<Shop> findPreferedShops() {
        return shopRepository.findByIsLikedTrue();
    }

    @Override
    public Shop getShop(String id) {
        return shopRepository.findOne(id);
    }

    @Override
    public Shop saveShop(Shop shop) {
        return shopRepository.save(shop);
    }






}