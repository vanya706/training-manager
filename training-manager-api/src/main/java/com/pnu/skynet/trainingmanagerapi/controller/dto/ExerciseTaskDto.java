package com.pnu.skynet.trainingmanagerapi.controller.dto;

import java.time.Duration;


public record ExerciseTaskDto(
        String id,
        Integer sequenceNumber,
        boolean done,
        Duration expectedDuration,
        Duration finalDuration,
        Integer expectedRepeats,
        Integer finalRepeats) {

}
