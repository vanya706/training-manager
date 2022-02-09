package com.pnu.skynet.trainingmanagerapi.controller.dto;

import com.pnu.skynet.trainingmanagerapi.constant.Color;

import javax.validation.constraints.NotNull;
import java.time.Duration;
import java.time.LocalDateTime;

public record TrainingDto(
        Color color,
        @NotNull
        LocalDateTime startDate,
        Duration duration) {
}
