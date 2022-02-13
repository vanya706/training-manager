package com.pnu.skynet.trainingmanagerapi.controller.dto;

import java.time.Duration;

public record ExerciseTaskCreateRequest(
        Duration expectedDuration,
        Integer expectedRepeats) {

}
