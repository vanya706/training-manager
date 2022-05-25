package com.pnu.skynet.trainingmanagerapi.controller.dto;

import java.time.Duration;

public record StatisticDto(
        long finishedTrainings,
        Duration spentTime) {

}
