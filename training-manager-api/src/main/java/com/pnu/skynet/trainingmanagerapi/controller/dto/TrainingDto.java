package com.pnu.skynet.trainingmanagerapi.controller.dto;

import com.pnu.skynet.trainingmanagerapi.constant.Color;

import java.time.Duration;
import java.time.LocalDateTime;

public record TrainingDto(
        String id,
        Color color,
        LocalDateTime startDate,
        Duration duration) {
}
