package com.pnu.skynet.trainingmanagerapi.service.impl;

import com.pnu.skynet.trainingmanagerapi.controller.dto.ExerciseTaskCreateRequest;
import com.pnu.skynet.trainingmanagerapi.controller.dto.ExerciseTaskDto;
import com.pnu.skynet.trainingmanagerapi.controller.dto.ExerciseTaskUpdateRequest;
import com.pnu.skynet.trainingmanagerapi.domain.ExerciseTask;
import com.pnu.skynet.trainingmanagerapi.exception.EntityNotFoundException;
import com.pnu.skynet.trainingmanagerapi.mapper.ExerciseTaskMapper;
import com.pnu.skynet.trainingmanagerapi.repository.ExerciseTaskRepository;
import com.pnu.skynet.trainingmanagerapi.service.ExerciseTaskService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ExerciseTaskServiceImpl implements ExerciseTaskService {

    private final ExerciseTaskRepository repository;

    private final ExerciseTaskMapper mapper;


    public ExerciseTaskServiceImpl(ExerciseTaskRepository repository, ExerciseTaskMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public ExerciseTaskDto create(ExerciseTaskCreateRequest request) {
        ExerciseTask exerciseTask = mapper.exerciseCreateRequestToExercise(request);
        ExerciseTask saved = repository.save(exerciseTask);
        return mapper.exerciseTaskToExerciseTaskDto(saved);
    }

    @Override
    public ExerciseTaskDto update(String id, ExerciseTaskUpdateRequest request) {
        ExerciseTask exerciseTaskFromDb = findByIdOrThrowException(id);
        mapper.updateExerciseTaskFromExerciseTaskDto(request, exerciseTaskFromDb);
        ExerciseTask saved = repository.save(exerciseTaskFromDb);
        return mapper.exerciseTaskToExerciseTaskDto(saved);
    }

    @Transactional
    @Override
    public void markAsDone(String id) {
        repository.markAsDone(id);
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }

    private ExerciseTask findByIdOrThrowException(String id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(ExerciseTask.class, id));
    }

}
