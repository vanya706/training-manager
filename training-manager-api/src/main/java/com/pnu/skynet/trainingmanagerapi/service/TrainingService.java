package com.pnu.skynet.trainingmanagerapi.service;

import com.pnu.skynet.trainingmanagerapi.controller.dto.TrainingDto;

public interface TrainingService {

    TrainingDto getById(String id);

}
