package com.pnu.skynet.trainingmanagerapi.service;

import com.pnu.skynet.trainingmanagerapi.controller.dto.ExerciseTaskCreateRequest;
import com.pnu.skynet.trainingmanagerapi.controller.dto.ExerciseTaskDto;
import com.pnu.skynet.trainingmanagerapi.controller.dto.ExerciseTaskUpdateRequest;

public interface ExerciseTaskService {

    ExerciseTaskDto create(ExerciseTaskCreateRequest request);

    ExerciseTaskDto update(String id, ExerciseTaskUpdateRequest request);

    void markAsDone(String id);

    void deleteById(String id);

}
