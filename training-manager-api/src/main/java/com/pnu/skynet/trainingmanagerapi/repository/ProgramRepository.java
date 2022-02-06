package com.pnu.skynet.trainingmanagerapi.repository;

import com.pnu.skynet.trainingmanagerapi.domain.Program;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgramRepository extends JpaRepository<Program, String> {

}
