package com.pnu.skynet.trainingmanagerapi.service.impl;

import com.pnu.skynet.trainingmanagerapi.controller.dto.TrainingCreateRequest;
import com.pnu.skynet.trainingmanagerapi.controller.dto.TrainingDto;
import com.pnu.skynet.trainingmanagerapi.controller.dto.TrainingUpdateRequest;
import com.pnu.skynet.trainingmanagerapi.domain.Training;
import com.pnu.skynet.trainingmanagerapi.exception.EntityNotFoundException;
import com.pnu.skynet.trainingmanagerapi.mapper.TrainingMapper;
import com.pnu.skynet.trainingmanagerapi.repository.TrainingRepository;
import com.pnu.skynet.trainingmanagerapi.service.TrainingService;
import org.springframework.stereotype.Service;

@Service
public class TrainingServiceImpl implements TrainingService {

    private final TrainingRepository repository;

    private final TrainingMapper mapper;


    public TrainingServiceImpl(TrainingRepository repository, TrainingMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public TrainingDto create(TrainingCreateRequest request) {
        Training training = mapper.trainingCreateRequestToTraining(request);
        Training saved = repository.save(training);
        return mapper.trainingToTrainingDto(saved);
    }

    @Override
    public TrainingDto update(String id, TrainingUpdateRequest request) {
        Training trainingFromDb = findByIdOrThrowException(id);
        mapper.updateTrainingFromTrainingDto(request, trainingFromDb);
        Training updated = repository.save(trainingFromDb);
        return mapper.trainingToTrainingDto(updated);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public TrainingDto getById(String id) {
        return mapper.trainingToTrainingDto(findByIdOrThrowException(id));
    }

    private Training findByIdOrThrowException(String id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(Training.class, id));
    }

}
