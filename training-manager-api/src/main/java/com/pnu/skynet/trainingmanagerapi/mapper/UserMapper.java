package com.pnu.skynet.trainingmanagerapi.mapper;

import com.pnu.skynet.trainingmanagerapi.config.MapStructConfig;
import com.pnu.skynet.trainingmanagerapi.controller.dto.UserCreateRequest;
import com.pnu.skynet.trainingmanagerapi.controller.dto.UserDto;
import com.pnu.skynet.trainingmanagerapi.controller.dto.UserUpdateRequest;
import com.pnu.skynet.trainingmanagerapi.domain.User;
import org.mapstruct.*;

@Mapper(config = MapStructConfig.class)
public interface UserMapper {

    User userDtotoUser(UserDto user);

    UserDto userToUserDto(User user);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "userRole", ignore = true)
    User userCreateRequestToUser(UserCreateRequest request);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "userRole", ignore = true)
    @Mapping(target = "username", ignore = true)
    @Mapping(target = "password", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateUserFromUserUpdateRequest(UserUpdateRequest userUpdateRequest, @MappingTarget User user);

}
