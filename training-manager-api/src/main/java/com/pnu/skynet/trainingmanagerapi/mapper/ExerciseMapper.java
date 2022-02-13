package com.pnu.skynet.trainingmanagerapi.mapper;

import com.pnu.skynet.trainingmanagerapi.config.MapStructConfig;
import com.pnu.skynet.trainingmanagerapi.controller.dto.ExerciseCreateRequest;
import com.pnu.skynet.trainingmanagerapi.controller.dto.ExerciseDto;
import com.pnu.skynet.trainingmanagerapi.controller.dto.ExerciseUpdateRequest;
import com.pnu.skynet.trainingmanagerapi.domain.Exercise;
import org.mapstruct.*;

import java.util.List;

@Mapper(config = MapStructConfig.class)
public interface ExerciseMapper {

    Exercise exerciseDtoToExercise(ExerciseDto exerciseDto);

    @Mapping(target = "atedBodyParts", ignore = true) // todo check how it is happens, where is it atedBodyParts field
    ExerciseDto exerciseToExerciseDto(Exercise exercise);

    List<ExerciseDto> exercisesToExerciseDtos(List<Exercise> exercises);

    @Mapping(target = "id", ignore = true)
    Exercise exerciseCreateRequestToExercise(ExerciseCreateRequest exerciseCreateRequest);

    @Mapping(target = "id", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateExerciseFromExerciseDto(ExerciseUpdateRequest exerciseUpdateRequest, @MappingTarget Exercise exercise);


}
