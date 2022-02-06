package com.pnu.skynet.trainingmanagerapi.controller.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

public record UserCreateRequest(
        String firstName,
        String lastName,
        @NotBlank
        String username,
        @Email
        String email,
        LocalDate birthday,
        String logoImage,
        Integer height,
        Integer weight,
        @NotBlank
        String password) {
}
