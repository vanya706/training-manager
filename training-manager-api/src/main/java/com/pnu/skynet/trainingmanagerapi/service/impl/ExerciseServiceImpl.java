package com.pnu.skynet.trainingmanagerapi.service.impl;

import com.pnu.skynet.trainingmanagerapi.controller.dto.ExerciseCreateRequest;
import com.pnu.skynet.trainingmanagerapi.controller.dto.ExerciseDto;
import com.pnu.skynet.trainingmanagerapi.controller.dto.ExerciseUpdateRequest;
import com.pnu.skynet.trainingmanagerapi.domain.Exercise;
import com.pnu.skynet.trainingmanagerapi.exception.EntityNotFoundException;
import com.pnu.skynet.trainingmanagerapi.mapper.ExerciseMapper;
import com.pnu.skynet.trainingmanagerapi.repository.ExerciseRepository;
import com.pnu.skynet.trainingmanagerapi.service.ExerciseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseServiceImpl implements ExerciseService {

    private final ExerciseRepository repository;

    private final ExerciseMapper mapper;


    public ExerciseServiceImpl(ExerciseRepository repository, ExerciseMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public ExerciseDto create(ExerciseCreateRequest request) {
        Exercise exercise = mapper.exerciseCreateRequestToExercise(request);
        Exercise saved = repository.save(exercise);
        return mapper.exerciseToExerciseDto(saved);
    }

    @Override
    public ExerciseDto update(String id, ExerciseUpdateRequest request) {
        Exercise exerciseFromDb = findByIdOrThrowException(id);
        mapper.updateExerciseFromExerciseDto(request, exerciseFromDb);
        Exercise saved = repository.save(exerciseFromDb);
        return mapper.exerciseToExerciseDto(saved);
    }

    @Override
    public List<ExerciseDto> getAll() {
        return mapper.exercisesToExerciseDtos(repository.findAll());
    }

    private Exercise findByIdOrThrowException(String id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(Exercise.class, id));
    }

}
