package com.nearByShops.NearByShops.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Map;


@Document(collection="users")
public class User  {

    @Id
    private String id;
    private String username;
    private String password;
    private String createdAt;
    private  Map<String,Shop> preferredShops = null;
    private  Map<String,LocalDateTime> dislikedShops = null;

    public User() {
        super();
    }

    public User(String username) {
        this();
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Map<String, Shop> getPreferredShops() {
        return preferredShops;
    }

    public void setPreferredShops(Map<String, Shop> preferredShops) {
        this.preferredShops = preferredShops;
    }

    public Map<String, LocalDateTime> getDislikedShops() {
        return dislikedShops;
    }

    public void setDislikedShops(Map<String, LocalDateTime> dislikedShops) {
        this.dislikedShops = dislikedShops;
    }
}