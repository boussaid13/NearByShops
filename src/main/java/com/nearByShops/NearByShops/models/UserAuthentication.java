package com.nearByShops.NearByShops.models;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class UserAuthentication implements Authentication {

    private  BasicUserDetails basicUserDetails;
    private boolean authenticated = true;

    public UserAuthentication(final BasicUserDetails basicUserDetails) {
        this.basicUserDetails = basicUserDetails;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return basicUserDetails.getAuthorities();
    }

    @Override
    public Object getCredentials() {
        return basicUserDetails.getPassword();
    }

    @Override
    public Object getDetails() {
        return basicUserDetails;
    }

    @Override
    public Object getPrincipal() {
        return basicUserDetails.getUsername();
    }

    @Override
    public boolean isAuthenticated() {
        return authenticated;
    }

    @Override
    public void setAuthenticated(final boolean authenticated) throws IllegalArgumentException {
        this.authenticated = authenticated;

    }

    @Override
    public String getName() {
        return basicUserDetails.getUsername();
    }

    public BasicUserDetails getBasicUserDetails() {
        return basicUserDetails;
    }

}
