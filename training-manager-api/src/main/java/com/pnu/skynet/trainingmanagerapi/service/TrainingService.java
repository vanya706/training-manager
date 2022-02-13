package com.pnu.skynet.trainingmanagerapi.service;

import com.pnu.skynet.trainingmanagerapi.controller.dto.TrainingCreateRequest;
import com.pnu.skynet.trainingmanagerapi.controller.dto.TrainingDto;
import com.pnu.skynet.trainingmanagerapi.controller.dto.TrainingUpdateRequest;

public interface TrainingService {

    TrainingDto create(TrainingCreateRequest request);

    TrainingDto update(String id, TrainingUpdateRequest request);

    void delete(String id);

    TrainingDto getById(String id);

}
