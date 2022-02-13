package com.pnu.skynet.trainingmanagerapi.repository;

import com.pnu.skynet.trainingmanagerapi.domain.ExerciseTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ExerciseTaskRepository extends JpaRepository<ExerciseTask, String> {

    @Modifying
    @Query("UPDATE ExerciseTask SET isDone = true WHERE id = :id")
    void markAsDone(String id);

}