package com.pnu.skynet.trainingmanagerapi.service.impl;

import com.pnu.skynet.trainingmanagerapi.controller.dto.StatisticDto;
import com.pnu.skynet.trainingmanagerapi.service.DashboardService;
import com.pnu.skynet.trainingmanagerapi.service.TrainingService;
import org.springframework.stereotype.Service;

@Service
public class DashboardServiceImpl implements DashboardService {

    private final TrainingService trainingService;


    public DashboardServiceImpl(TrainingService trainingService) {
        this.trainingService = trainingService;
    }


    @Override
    public StatisticDto getStatistic(String programId) {
        long countFinishedTrainings = trainingService.countFinishedTrainings(programId);
//        Duration spentTime = trainingService.
//        return new StatisticDto(countFinishedTrainings, spentTime);
        return null;
    }

}
