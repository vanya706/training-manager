package com.pnu.skynet.trainingmanagerapi.controller.dto;

import javax.validation.constraints.Email;
import java.time.LocalDate;

public record UserUpdateRequest(
        String firstName,
        String lastName,
        @Email
        String email,
        LocalDate birthday,
        String logoImage,
        Integer height,
        Integer weight) {
}
