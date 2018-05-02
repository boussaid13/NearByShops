package com.nearByShops.NearByShops.services;

import com.nearByShops.NearByShops.models.BasicUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class BasicUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Autowired
    public BasicUserDetailsService(final UserService userService) {
        this.userService = userService;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final BasicUserDetails basicUserDetails = userService.findByUsername(username);
        if (basicUserDetails != null) {
            return basicUserDetails;
        } else {
            throw new UsernameNotFoundException("User with username:" + username + " not found");
        }
    }

}