package com.pnu.skynet.trainingmanagerapi.controller.dto;

import com.pnu.skynet.trainingmanagerapi.constant.BodyPart;
import com.pnu.skynet.trainingmanagerapi.constant.ExerciseType;

import java.util.Set;

public record ExerciseCreateRequest(
        String name,
        ExerciseType type,
        Set<BodyPart> relatedBodyParts) {

}
