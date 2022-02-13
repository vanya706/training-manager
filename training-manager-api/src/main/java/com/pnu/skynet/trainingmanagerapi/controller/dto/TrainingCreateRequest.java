package com.pnu.skynet.trainingmanagerapi.controller.dto;

import com.pnu.skynet.trainingmanagerapi.constant.Color;

import java.time.Duration;
import java.time.LocalDateTime;

public record TrainingCreateRequest(
        Color color,
        LocalDateTime startDate,
        Duration duration) {

}
