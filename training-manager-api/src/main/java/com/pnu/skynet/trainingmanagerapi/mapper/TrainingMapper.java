package com.pnu.skynet.trainingmanagerapi.mapper;

import com.pnu.skynet.trainingmanagerapi.config.MapStructConfig;
import com.pnu.skynet.trainingmanagerapi.controller.dto.TrainingDto;
import com.pnu.skynet.trainingmanagerapi.domain.Training;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(config = MapStructConfig.class)
public interface TrainingMapper {

    Training trainingDtoToTraining(TrainingDto trainingDto);

    TrainingDto trainingToTrainingDto(Training training);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateTrainingFromTrainingDto(TrainingDto trainingDto, @MappingTarget Training training);

}
