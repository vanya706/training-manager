package com.pnu.skynet.trainingmanagerapi.repository;

import com.pnu.skynet.trainingmanagerapi.domain.Program;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProgramRepository extends JpaRepository<Program, String> {

    List<Program> findAllByCreatedBy(String username);

    @Modifying
    @Query("UPDATE Program SET active = false WHERE createdBy = :username and active = true")
    void deactivateAllByCreatedBy(@Param("username") String username);

    @Modifying
    @Query("UPDATE Program SET active = true WHERE id = :id")
    void activateById(@Param("id") String id);

}
