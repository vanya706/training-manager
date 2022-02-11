package com.pnu.skynet.trainingmanagerapi.controller;

import com.pnu.skynet.trainingmanagerapi.controller.dto.UserCreateRequest;
import com.pnu.skynet.trainingmanagerapi.controller.dto.UserDto;
import com.pnu.skynet.trainingmanagerapi.controller.dto.UserUpdateRequest;
import com.pnu.skynet.trainingmanagerapi.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    private final UserService service;


    public UserController(UserService service) {
        this.service = service;
    }


    @PostMapping(value = "", consumes = {"application/json"})
    public UserDto create(@RequestBody @Valid UserCreateRequest request) {
        return service.create(request);
    }

    @PutMapping("/{id}")
    public UserDto update(@PathVariable String id, @RequestBody @Valid UserUpdateRequest request) {
        return service.update(id, request);
    }

    @GetMapping("/{id}")
    public UserDto getById(@PathVariable String id) {
        return service.getById(id);
    }

}
