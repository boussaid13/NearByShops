package com.nearByShops.NearByShops.dto;

import com.nearByShops.NearByShops.models.Authority;
import com.nearByShops.NearByShops.models.BasicUserDetails;
import org.springframework.core.convert.converter.Converter;

import java.util.ArrayList;
import java.util.List;

public class UserDTOConverter implements Converter<UserDTO, BasicUserDetails> {
    @Override
    public BasicUserDetails convert(final UserDTO dto) {

            final BasicUserDetails basicUserDetails = new BasicUserDetails();

            basicUserDetails.setUsername(dto.getUsername());
            basicUserDetails.setPassword(dto.getPassword());
            basicUserDetails.setAccountNonExpired(false);
            basicUserDetails.setCredentialsNonExpired(false);
            basicUserDetails.setEnabled(true);

            List<Authority> authorities = new ArrayList<>();
            authorities.add(Authority.USER);
            basicUserDetails.setAuthorities(authorities);
            return basicUserDetails;
    }
}
