package com.nearByShops.NearByShops.models;

import org.springframework.security.core.GrantedAuthority;

public enum Authority implements GrantedAuthority{
    USER,
    ADMIN,
    ANONYMOUS
    ;

    @Override
    public String getAuthority() {
        return this.name();
    }

}