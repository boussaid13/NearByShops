package com.nearByShops.NearByShops.services;

import com.nearByShops.NearByShops.models.BasicUserDetails;
import com.nearByShops.NearByShops.models.Shop;
import com.nearByShops.NearByShops.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

public class UserServiceImpl implements UserService{

    private final UserRepository repository;

    @Autowired
    public UserServiceImpl(final UserRepository repository) {
        this.repository = repository;
    }
    @Override
    public BasicUserDetails create(BasicUserDetails basicUserDetails) {
        basicUserDetails.setCreatedAt(String.valueOf(LocalDateTime.now()));
        basicUserDetails.setPreferredShops(new HashMap<String,Shop>());
        basicUserDetails.setDislikedShops(new HashMap<String,LocalDateTime>());
        return repository.save(basicUserDetails);
    }

    @Override
    public BasicUserDetails find(String id) {
        return repository.findOne(id);
    }

    @Override
    public BasicUserDetails findByUsername(String userName) {
        return repository.findByUsername(userName);
    }

    @Override
    public List<BasicUserDetails> findAll() {
        return repository.findAll();
    }

    @Override
    public BasicUserDetails update(String id, BasicUserDetails basicUserDetails) {
        basicUserDetails.setId(id);
        final BasicUserDetails saved = repository.findOne(id);
        if (saved != null) {
            basicUserDetails.setCreatedAt(saved.getCreatedAt());
        } else {
            basicUserDetails.setCreatedAt(String.valueOf(LocalDateTime.now()));
        }
        repository.save(basicUserDetails);
        return basicUserDetails;
    }

    @Override
    public String delete(String id) {
        repository.delete(id);
        return id;
    }

}
