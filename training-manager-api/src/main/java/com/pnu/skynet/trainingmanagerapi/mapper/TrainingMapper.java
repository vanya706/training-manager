package com.pnu.skynet.trainingmanagerapi.mapper;

import com.pnu.skynet.trainingmanagerapi.config.MapStructConfig;
import com.pnu.skynet.trainingmanagerapi.controller.dto.TrainingCreateRequest;
import com.pnu.skynet.trainingmanagerapi.controller.dto.TrainingDto;
import com.pnu.skynet.trainingmanagerapi.controller.dto.TrainingUpdateRequest;
import com.pnu.skynet.trainingmanagerapi.domain.Training;
import org.mapstruct.*;

@Mapper(config = MapStructConfig.class)
public interface TrainingMapper {

    Training trainingDtoToTraining(TrainingDto trainingDto);

    TrainingDto trainingToTrainingDto(Training training);

    @Mapping(target = "id", ignore = true)
    Training trainingCreateRequestToTraining(TrainingCreateRequest request);

    @Mapping(target = "id", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateTrainingFromTrainingDto(TrainingUpdateRequest trainingUpdateRequest, @MappingTarget Training training);

}
