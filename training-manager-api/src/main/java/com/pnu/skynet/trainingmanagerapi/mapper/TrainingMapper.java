package com.pnu.skynet.trainingmanagerapi.mapper;

import com.pnu.skynet.trainingmanagerapi.config.MapStructConfig;
import com.pnu.skynet.trainingmanagerapi.controller.dto.TrainingCreateRequest;
import com.pnu.skynet.trainingmanagerapi.controller.dto.TrainingDto;
import com.pnu.skynet.trainingmanagerapi.controller.dto.TrainingUpdateRequest;
import com.pnu.skynet.trainingmanagerapi.domain.Training;
import org.mapstruct.*;

@Mapper(config = MapStructConfig.class)
public interface TrainingMapper {

    @Mapping(target = "program", ignore = true)
    @Mapping(target = "exerciseTasks", ignore = true)
    Training trainingDtoToTraining(TrainingDto trainingDto);

    @BeanMapping(ignoreUnmappedSourceProperties = {"program", "exerciseTasks"})
    TrainingDto trainingToTrainingDto(Training training);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "program", ignore = true)
    @Mapping(target = "exerciseTasks", ignore = true)
    Training trainingCreateRequestToTraining(TrainingCreateRequest request);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "program", ignore = true)
    @Mapping(target = "exerciseTasks", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateTrainingFromTrainingDto(TrainingUpdateRequest trainingUpdateRequest, @MappingTarget Training training);

}
