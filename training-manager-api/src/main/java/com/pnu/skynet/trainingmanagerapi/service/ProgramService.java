package com.pnu.skynet.trainingmanagerapi.service;

import com.pnu.skynet.trainingmanagerapi.controller.dto.ProgramCreateRequest;
import com.pnu.skynet.trainingmanagerapi.controller.dto.ProgramDto;
import com.pnu.skynet.trainingmanagerapi.controller.dto.ProgramUpdateRequest;

import java.util.List;

public interface ProgramService {

    ProgramDto create(ProgramCreateRequest request);

    ProgramDto update(String id, ProgramUpdateRequest request);

    ProgramDto getById(String id);

    List<ProgramDto> getAllByUsername(String username);
}
