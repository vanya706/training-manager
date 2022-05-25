package com.pnu.skynet.trainingmanagerapi.controller;

import com.pnu.skynet.trainingmanagerapi.controller.dto.StatisticDto;
import com.pnu.skynet.trainingmanagerapi.service.DashboardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/dashboard")
public class DashboardController {

    private final DashboardService service;


    public DashboardController(DashboardService service) {
        this.service = service;
    }


    /*
    * GET /dashboard/${id}
GET /dashboard/${id}/statistic
GET /dashboard/${id}/training (list of trainings)*/

    @GetMapping
    public void getDashboard() {
//        return service.getDashboard();
    }

    @GetMapping("/{programId}/statistic")
    public StatisticDto getStatistic(@PathVariable String programId) {
        return service.getStatistic(programId);
    }

    @GetMapping("/{programId}/training")
    public void getTrainings(@PathVariable String programId) {
//        return service.getTrainings();
    }

}
