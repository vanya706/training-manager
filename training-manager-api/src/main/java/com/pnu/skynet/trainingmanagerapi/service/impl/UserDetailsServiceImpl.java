package com.pnu.skynet.trainingmanagerapi.service.impl;

import com.pnu.skynet.trainingmanagerapi.domain.AuthUser;
import com.pnu.skynet.trainingmanagerapi.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository repository;


    public UserDetailsServiceImpl(UserRepository repository) {
        this.repository = repository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByUsername(username)
                .map(user -> new AuthUser(user.getUsername(), user.getPassword(), user.getUserRole()))
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User does not exist by the username: %s", username)));
    }

}
