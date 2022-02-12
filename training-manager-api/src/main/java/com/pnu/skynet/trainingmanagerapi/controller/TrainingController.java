package com.pnu.skynet.trainingmanagerapi.controller;

import com.pnu.skynet.trainingmanagerapi.controller.dto.TrainingCreateRequest;
import com.pnu.skynet.trainingmanagerapi.controller.dto.TrainingDto;
import com.pnu.skynet.trainingmanagerapi.controller.dto.TrainingUpdateRequest;
import com.pnu.skynet.trainingmanagerapi.service.TrainingService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/training")
public class TrainingController {

    private final TrainingService service;


    public TrainingController(TrainingService service) {
        this.service = service;
    }


    @PostMapping
    public TrainingDto create(@RequestBody @Valid TrainingCreateRequest request) {
        return service.create(request);
    }

    @PutMapping("/{id}")
    public TrainingDto update(@PathVariable String id, @RequestBody @Valid TrainingUpdateRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }

    @GetMapping("/{id}")
    public TrainingDto getById(@PathVariable String id) {
        return service.getById(id);
    }

}
