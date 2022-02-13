package com.pnu.skynet.trainingmanagerapi.controller;

import com.pnu.skynet.trainingmanagerapi.controller.dto.ExerciseTaskCreateRequest;
import com.pnu.skynet.trainingmanagerapi.controller.dto.ExerciseTaskDto;
import com.pnu.skynet.trainingmanagerapi.controller.dto.ExerciseTaskUpdateRequest;
import com.pnu.skynet.trainingmanagerapi.service.ExerciseTaskService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/exercise-task")
public class ExerciseTaskController {

    private final ExerciseTaskService service;


    public ExerciseTaskController(ExerciseTaskService service) {
        this.service = service;
    }


    @PostMapping
    public ExerciseTaskDto create(@RequestBody @Valid ExerciseTaskCreateRequest request) {
        return service.create(request);
    }

    @PutMapping("/{id}")
    public ExerciseTaskDto update(@PathVariable String id, @RequestBody @Valid ExerciseTaskUpdateRequest request) {
        return service.update(id, request);
    }

    @PatchMapping("/{id}")
    public void markAsDone(@PathVariable String id) {
        service.markAsDone(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.deleteById(id);
    }

}
