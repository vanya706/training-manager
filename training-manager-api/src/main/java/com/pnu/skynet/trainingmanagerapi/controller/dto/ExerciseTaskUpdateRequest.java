package com.pnu.skynet.trainingmanagerapi.controller.dto;

import java.time.Duration;

public record ExerciseTaskUpdateRequest(
        boolean done,
        Duration expectedDuration,
        Duration finalDuration,
        Integer expectedRepeats,
        Integer finalRepeats) {

}
