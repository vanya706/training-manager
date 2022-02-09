package com.pnu.skynet.trainingmanagerapi.controller;

import com.pnu.skynet.trainingmanagerapi.controller.dto.TrainingDto;
import com.pnu.skynet.trainingmanagerapi.service.TrainingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/training")
public class TrainingController {

    private final TrainingService service;


    public TrainingController(TrainingService service) {
        this.service = service;
    }


    @GetMapping("/{id}")
    public TrainingDto getById(@PathVariable String id) {
        return service.getById(id);
    }

}
