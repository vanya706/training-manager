package com.pnu.skynet.trainingmanagerapi.repository;

import com.pnu.skynet.trainingmanagerapi.domain.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseRepository extends JpaRepository<Exercise, String> {

}
