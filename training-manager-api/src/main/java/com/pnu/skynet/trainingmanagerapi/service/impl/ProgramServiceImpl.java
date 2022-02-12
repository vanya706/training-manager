package com.pnu.skynet.trainingmanagerapi.service.impl;

import com.pnu.skynet.trainingmanagerapi.controller.dto.ProgramCreateRequest;
import com.pnu.skynet.trainingmanagerapi.controller.dto.ProgramDto;
import com.pnu.skynet.trainingmanagerapi.controller.dto.ProgramUpdateRequest;
import com.pnu.skynet.trainingmanagerapi.domain.Program;
import com.pnu.skynet.trainingmanagerapi.exception.EntityNotFoundException;
import com.pnu.skynet.trainingmanagerapi.mapper.ProgramMapper;
import com.pnu.skynet.trainingmanagerapi.repository.ProgramRepository;
import com.pnu.skynet.trainingmanagerapi.service.ProgramService;
import com.pnu.skynet.trainingmanagerapi.util.UserInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProgramServiceImpl implements ProgramService {

    private final ProgramRepository repository;

    private final ProgramMapper mapper;


    public ProgramServiceImpl(ProgramRepository repository, ProgramMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Transactional
    @Override
    public ProgramDto create(ProgramCreateRequest request) {
        Program program = mapper.programCreateRequestToProgram(request);
        deactivateIfNeeded(program);
        Program saved = repository.save(program);
        return mapper.programToProgramDto(saved);
    }

    @Transactional
    @Override
    public ProgramDto update(String id, ProgramUpdateRequest request) {
        Program programFromDb = findByIdOrThrowException(id);
        mapper.updateProgramFromProgramDto(request, programFromDb);
        deactivateIfNeeded(programFromDb);
        Program updated = repository.save(programFromDb);
        return mapper.programToProgramDto(updated);
    }

    @Transactional
    @Override
    public void activate(String id) {
        repository.deactivateAllByCreatedBy(UserInfo.getUsername());
        repository.activateById(id);
    }

    @Override
    public ProgramDto getById(String id) {
        return mapper.programToProgramDto(findByIdOrThrowException(id));
    }

    @Override
    public List<ProgramDto> getAllByUsername(String username) {
        return mapper.programsToProgramDtos(repository.findAllByCreatedBy(username));
    }

    private void deactivateIfNeeded(Program program) {
        if (program.isActive()) {
            repository.deactivateAllByCreatedBy(UserInfo.getUsername());
        }
    }

    private Program findByIdOrThrowException(String id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(Program.class, id));
    }

}
