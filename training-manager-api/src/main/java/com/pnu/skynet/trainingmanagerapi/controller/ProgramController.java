package com.pnu.skynet.trainingmanagerapi.controller;

import com.pnu.skynet.trainingmanagerapi.controller.dto.ProgramDto;
import com.pnu.skynet.trainingmanagerapi.service.ProgramService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/program")
public class ProgramController {

    private final ProgramService service;


    public ProgramController(ProgramService service) {
        this.service = service;
    }


    @GetMapping("/{id}")
    public ProgramDto getById(@PathVariable String id) {
        return service.getById(id);
    }

}
