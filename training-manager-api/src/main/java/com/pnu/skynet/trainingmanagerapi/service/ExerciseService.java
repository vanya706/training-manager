package com.pnu.skynet.trainingmanagerapi.service;

import com.pnu.skynet.trainingmanagerapi.controller.dto.ExerciseCreateRequest;
import com.pnu.skynet.trainingmanagerapi.controller.dto.ExerciseDto;
import com.pnu.skynet.trainingmanagerapi.controller.dto.ExerciseUpdateRequest;

import java.util.List;

public interface ExerciseService {

    ExerciseDto create(ExerciseCreateRequest request);

    ExerciseDto update(String id, ExerciseUpdateRequest request);

    List<ExerciseDto> getAll();

}
