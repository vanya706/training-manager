package com.pnu.skynet.trainingmanagerapi.service;

import com.pnu.skynet.trainingmanagerapi.controller.dto.ProgramDto;
import com.pnu.skynet.trainingmanagerapi.controller.dto.TrainingCreateRequest;
import com.pnu.skynet.trainingmanagerapi.controller.dto.TrainingUpdateRequest;

import java.util.List;

public interface ProgramService {

    ProgramDto create(TrainingCreateRequest request);

    ProgramDto update(String id, TrainingUpdateRequest request);

    ProgramDto getById(String id);

    List<ProgramDto> getAllByUsername(String username);
}
