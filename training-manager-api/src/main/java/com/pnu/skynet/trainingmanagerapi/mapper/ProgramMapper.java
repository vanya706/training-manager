package com.pnu.skynet.trainingmanagerapi.mapper;

import com.pnu.skynet.trainingmanagerapi.config.MapStructConfig;
import com.pnu.skynet.trainingmanagerapi.controller.dto.ProgramCreateRequest;
import com.pnu.skynet.trainingmanagerapi.controller.dto.ProgramDto;
import com.pnu.skynet.trainingmanagerapi.controller.dto.ProgramUpdateRequest;
import com.pnu.skynet.trainingmanagerapi.domain.Program;
import org.mapstruct.*;

import java.util.List;

@Mapper(config = MapStructConfig.class)
public interface ProgramMapper {

    Program programDtoToProgram(ProgramDto programDto);

    ProgramDto programToProgramDto(Program program);

    List<ProgramDto> programsToProgramDtos(List<Program> programs);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "finished", ignore = true)
    Program programCreateRequestToProgram(ProgramCreateRequest programCreateRequest);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateProgramFromProgramDto(ProgramUpdateRequest programUpdateRequest, @MappingTarget Program program);

}
