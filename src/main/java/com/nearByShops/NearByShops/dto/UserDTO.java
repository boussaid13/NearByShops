package com.nearByShops.NearByShops.dto;

import com.nearByShops.NearByShops.models.Shop;

import java.util.List;

public class UserDTO {

    private String username;
    //@JsonDeserialize(using = BCryptPasswordDeserializer.class)
    private String password;
    private String name;

    private List<Shop> preferredShops;

    public UserDTO() {
        super();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Shop> getPreferredShops() {
        return preferredShops;
    }

    public void setPreferredShops(List<Shop> preferredShops) {
        this.preferredShops = preferredShops;
    }
}
