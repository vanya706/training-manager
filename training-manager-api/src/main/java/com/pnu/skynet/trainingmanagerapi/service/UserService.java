package com.pnu.skynet.trainingmanagerapi.service;

import com.pnu.skynet.trainingmanagerapi.controller.dto.UserDto;

public interface UserService {

    UserDto getById(String id);

}
