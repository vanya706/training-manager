package com.pnu.skynet.trainingmanagerapi.controller.dto;

import com.pnu.skynet.trainingmanagerapi.constant.UserRole;

import java.time.LocalDate;

public record UserDto(
        String id,
        String firstName,
        String lastName,
        String username,
        String email,
        LocalDate birthday,
        String logoImage,
        Integer height,
        Integer weight,
        String password,
        UserRole userRole) {
}
