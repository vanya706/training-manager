package com.pnu.skynet.trainingmanagerapi.service.impl;

import com.pnu.skynet.trainingmanagerapi.controller.dto.ProgramDto;
import com.pnu.skynet.trainingmanagerapi.domain.Program;
import com.pnu.skynet.trainingmanagerapi.mapper.ProgramMapper;
import com.pnu.skynet.trainingmanagerapi.repository.ProgramRepository;
import com.pnu.skynet.trainingmanagerapi.service.ProgramService;
import org.springframework.stereotype.Service;

@Service
public class ProgramServiceImpl implements ProgramService {

    private final ProgramRepository repository;

    private final ProgramMapper mapper;


    public ProgramServiceImpl(ProgramRepository repository, ProgramMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public ProgramDto getById(String id) {
        return mapper.programToProgramDto(findByIdOrThrowException(id));
    }

    private Program findByIdOrThrowException(String id) {
        return repository.findById(id).orElseThrow();
    }

}
