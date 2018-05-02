package com.nearByShops.NearByShops.services;

import com.nearByShops.NearByShops.models.BasicUserDetails;

import java.util.List;


public interface UserService {

    BasicUserDetails create(BasicUserDetails object);
    BasicUserDetails find(String id);
    BasicUserDetails findByUsername(String userName);
    List<BasicUserDetails> findAll();
    BasicUserDetails update(String id, BasicUserDetails object);
    String delete(String id);

}