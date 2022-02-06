package com.pnu.skynet.trainingmanagerapi.service.impl;

import com.pnu.skynet.trainingmanagerapi.controller.dto.UserDto;
import com.pnu.skynet.trainingmanagerapi.domain.User;
import com.pnu.skynet.trainingmanagerapi.mapper.UserMapper;
import com.pnu.skynet.trainingmanagerapi.repository.UserRepository;
import com.pnu.skynet.trainingmanagerapi.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    private final UserMapper mapper;


    public UserServiceImpl(UserRepository repository, UserMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public UserDto getById(String id) {
        return mapper.userToUserDto(findByIdOrThrowException(id));
    }

    private User findByIdOrThrowException(String id) {
        return repository.findById(id).orElseThrow();
    }

}
