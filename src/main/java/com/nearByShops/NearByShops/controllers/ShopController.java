package com.nearByShops.NearByShops.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.nearByShops.NearByShops.models.Shop;
import com.nearByShops.NearByShops.services.ShopService;


import java.util.Date;
import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/shops")
@CrossOrigin("*")
public class ShopController {

    @Autowired
    ShopService shopService;


    @GetMapping("/nearby")
    public ResponseEntity<List<Shop>> getNearbyShops() {
        List<Shop> nearbyShopsPage = shopService.findNearbyShops();
        return new ResponseEntity<>(nearbyShopsPage, HttpStatus.OK);
    }
    @GetMapping("/prefered")
    public ResponseEntity<List<Shop>> getPreferedShops() {
        List<Shop> preferedShopsPage = shopService.findPreferedShops();
        return new ResponseEntity<>(preferedShopsPage, HttpStatus.OK);
    }

    @PutMapping(value="/preferShop/{id}")
    public ResponseEntity<Shop> likeShop(@PathVariable("id") String id,
                                         @Valid @RequestBody Shop shop) {
        Shop shopData = shopService.getShop(id);
        if(shopData == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        shopData.setIsLiked(true);
        Shop updatedShop = shopService.saveShop(shopData);
        return new ResponseEntity<>(updatedShop, HttpStatus.OK);
    }

    @PutMapping(value="/removeFromPreferedShops/{id}")
    public ResponseEntity<Shop> removeFromPrefered(@PathVariable("id") String id,
                                                   @Valid @RequestBody Shop shop) {
        Shop shopData = shopService.getShop(id);
        if(shopData == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        shopData.setIsLiked(false);


        Shop updatedShop = shopService.saveShop(shopData);
        return new ResponseEntity<>(updatedShop, HttpStatus.OK);
    }

    @PutMapping(value="/dislike/{id}")
    public ResponseEntity<Shop> dislikeShop(@PathVariable("id") String id,
                                            @Valid @RequestBody Shop shop) {
        Shop shopData = shopService.getShop(id);
        if(shopData == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        shopData.setShownAfter(new Date(new Date().getTime()+2*3600*1000));

        Shop updatedShop = shopService.saveShop(shopData);
        return new ResponseEntity<>(updatedShop, HttpStatus.OK);
    }

}