package com.pnu.skynet.trainingmanagerapi.controller;

import com.pnu.skynet.trainingmanagerapi.controller.dto.ProgramCreateRequest;
import com.pnu.skynet.trainingmanagerapi.controller.dto.ProgramDto;
import com.pnu.skynet.trainingmanagerapi.controller.dto.ProgramUpdateRequest;
import com.pnu.skynet.trainingmanagerapi.domain.AuthUser;
import com.pnu.skynet.trainingmanagerapi.service.ProgramService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/program")
public class ProgramController {

    private final ProgramService service;


    public ProgramController(ProgramService service) {
        this.service = service;
    }


    @PostMapping
    public ProgramDto create(@RequestBody @Valid ProgramCreateRequest request) {
        return service.create(request);
    }

    @PutMapping("/{id}")
    public ProgramDto update(@PathVariable String id, @RequestBody @Valid ProgramUpdateRequest request) {
        return service.update(id, request);
    }

    @GetMapping("/{id}")
    public ProgramDto getById(@PathVariable String id) {
        return service.getById(id);
    }

    @GetMapping
    public List<ProgramDto> getAllByUsername(@AuthenticationPrincipal AuthUser user) {
        return service.getAllByUsername(user.getUsername());
    }

}
