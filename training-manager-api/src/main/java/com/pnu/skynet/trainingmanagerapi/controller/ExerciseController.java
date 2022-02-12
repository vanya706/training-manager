package com.pnu.skynet.trainingmanagerapi.controller;

import com.pnu.skynet.trainingmanagerapi.controller.dto.ExerciseCreateRequest;
import com.pnu.skynet.trainingmanagerapi.controller.dto.ExerciseDto;
import com.pnu.skynet.trainingmanagerapi.controller.dto.ExerciseUpdateRequest;
import com.pnu.skynet.trainingmanagerapi.service.ExerciseService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/exercise")
public class ExerciseController {

    private final ExerciseService service;


    public ExerciseController(ExerciseService service) {
        this.service = service;
    }


    @PostMapping
    public ExerciseDto create(@RequestBody @Valid ExerciseCreateRequest request) {
        return service.create(request);
    }

    @PutMapping("/{id}")
    public ExerciseDto update(@PathVariable String id, @RequestBody @Valid ExerciseUpdateRequest request) {
        return service.update(id, request);
    }

    @GetMapping
    public List<ExerciseDto> getAll() {
        return service.getAll();
    }

}
