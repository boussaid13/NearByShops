package com.nearByShops.NearByShops.repositories;

import com.nearByShops.NearByShops.models.BasicUserDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<BasicUserDetails, String> {

    BasicUserDetails findByUsername(final String userName);
}