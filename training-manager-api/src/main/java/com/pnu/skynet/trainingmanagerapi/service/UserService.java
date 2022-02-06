package com.pnu.skynet.trainingmanagerapi.service;

import com.pnu.skynet.trainingmanagerapi.controller.dto.UserCreateRequest;
import com.pnu.skynet.trainingmanagerapi.controller.dto.UserDto;
import com.pnu.skynet.trainingmanagerapi.controller.dto.UserUpdateRequest;

public interface UserService {

    UserDto create(UserCreateRequest request);

    UserDto update(String id, UserUpdateRequest request);

    UserDto getById(String id);

}
