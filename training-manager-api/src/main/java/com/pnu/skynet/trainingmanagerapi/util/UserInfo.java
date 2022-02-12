package com.pnu.skynet.trainingmanagerapi.util;

import com.pnu.skynet.trainingmanagerapi.domain.AuthUser;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserInfo {

    public static String getUsername() {
        return ((AuthUser) getAuthentication().getPrincipal()).getUsername();

    }

    private static Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

}
