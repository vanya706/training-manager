package com.pnu.skynet.trainingmanagerapi.controller.dto;

import com.pnu.skynet.trainingmanagerapi.constant.ProgramDifficultyLevel;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public record ProgramUpdateRequest(
        @NotBlank
        String label,
        String description,
        @NotNull
        LocalDate startDate,
        LocalDate endDate,
        @NotNull
        ProgramDifficultyLevel difficultyLevel,
        boolean finished,
        boolean active) {

}
