package com.pnu.skynet.trainingmanagerapi.service.impl;

import com.pnu.skynet.trainingmanagerapi.controller.dto.UserCreateRequest;
import com.pnu.skynet.trainingmanagerapi.controller.dto.UserDto;
import com.pnu.skynet.trainingmanagerapi.controller.dto.UserUpdateRequest;
import com.pnu.skynet.trainingmanagerapi.domain.User;
import com.pnu.skynet.trainingmanagerapi.mapper.UserMapper;
import com.pnu.skynet.trainingmanagerapi.repository.UserRepository;
import com.pnu.skynet.trainingmanagerapi.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    private final UserMapper mapper;

    private final PasswordEncoder passwordEncoder;


    public UserServiceImpl(UserRepository repository, UserMapper mapper, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.mapper = mapper;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public UserDto create(UserCreateRequest request) {
        User user = mapper.userCreateRequestToUser(request);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User saved = repository.save(user);
        return mapper.userToUserDto(saved);
    }

    @Override
    public UserDto update(String id, UserUpdateRequest request) {
        User userFromDb = findByIdOrThrowException(id);
        mapper.updateUserFromUserUpdateRequest(request, userFromDb);
        User updated = repository.save(userFromDb);
        return mapper.userToUserDto(updated);
    }

    @Override
    public UserDto getById(String id) {
        return mapper.userToUserDto(findByIdOrThrowException(id));
    }

    private User findByIdOrThrowException(String id) {
        return repository.findById(id).orElseThrow();
    }

}
