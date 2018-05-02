package com.nearByShops.NearByShops.services;

import com.nearByShops.NearByShops.models.Shop;

import java.util.List;



public interface ShopServiceImpl {

    public List<Shop> findNearbyShops();
    public List<Shop> findPreferedShops();
    public Shop getShop(String id);
    public Shop saveShop(Shop shop);

}