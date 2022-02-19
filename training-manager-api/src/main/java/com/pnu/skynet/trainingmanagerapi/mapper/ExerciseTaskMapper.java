package com.pnu.skynet.trainingmanagerapi.mapper;

import com.pnu.skynet.trainingmanagerapi.config.MapStructConfig;
import com.pnu.skynet.trainingmanagerapi.controller.dto.ExerciseTaskCreateRequest;
import com.pnu.skynet.trainingmanagerapi.controller.dto.ExerciseTaskDto;
import com.pnu.skynet.trainingmanagerapi.controller.dto.ExerciseTaskUpdateRequest;
import com.pnu.skynet.trainingmanagerapi.domain.ExerciseTask;
import org.mapstruct.*;

@Mapper(config = MapStructConfig.class)
public interface ExerciseTaskMapper {

    @Mapping(target = "training", ignore = true)
    @Mapping(target = "exercise", ignore = true)
    ExerciseTask exerciseTaskDtoToExerciseTask(ExerciseTaskDto exerciseTaskDto);

    @BeanMapping(ignoreUnmappedSourceProperties = {"training", "exercise"})
    ExerciseTaskDto exerciseTaskToExerciseTaskDto(ExerciseTask exerciseTask);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "done", ignore = true)
    @Mapping(target = "sequenceNumber", ignore = true)
    @Mapping(target = "finalDuration", ignore = true)
    @Mapping(target = "finalRepeats", ignore = true)
    @Mapping(target = "training", ignore = true)
    @Mapping(target = "exercise", ignore = true)
    ExerciseTask exerciseCreateRequestToExercise(ExerciseTaskCreateRequest request);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "sequenceNumber", ignore = true)
    @Mapping(target = "training", ignore = true)
    @Mapping(target = "exercise", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateExerciseTaskFromExerciseTaskDto(ExerciseTaskUpdateRequest exerciseTaskUpdateRequest, @MappingTarget ExerciseTask exerciseTask);

}
