package com.pnu.skynet.trainingmanagerapi.repository;

import com.pnu.skynet.trainingmanagerapi.domain.Training;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrainingRepository extends JpaRepository<Training, String> {

    long countByProgramId(String programId);

    long countDistinctByProgramIdAndExerciseTasks_DoneFalse(String programId);


    List<Training> findAllByProgramIdAndExerciseTasks_DoneTrue(String programId);

}
