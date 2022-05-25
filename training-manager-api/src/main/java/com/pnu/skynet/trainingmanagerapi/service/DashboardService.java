package com.pnu.skynet.trainingmanagerapi.service;

import com.pnu.skynet.trainingmanagerapi.controller.dto.StatisticDto;

public interface DashboardService {

    StatisticDto getStatistic(String programId);

}
