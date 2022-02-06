package com.pnu.skynet.trainingmanagerapi.controller.dto;

import com.pnu.skynet.trainingmanagerapi.constant.ProgramDifficultyLevel;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record ProgramDto(
        String id,
        String createdBy,
        LocalDateTime createdDate,
        String label,
        String description,
        LocalDate startDate,
        LocalDate endDate,
        ProgramDifficultyLevel difficultyLevel,
        boolean finished,
        boolean active) {
}
