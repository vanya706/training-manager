package com.pnu.skynet.trainingmanagerapi.domain;

import com.pnu.skynet.trainingmanagerapi.constant.ProgramDifficultyLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
public class Program extends AuditableEntity {

    private String label;

    private String description;

    private LocalDate startDate;

    private LocalDate endDate;

    @Enumerated(EnumType.STRING)
    private ProgramDifficultyLevel difficultyLevel;

    private boolean finished;

    private boolean active = true;

    @OneToMany(mappedBy = "program")
    private List<Training> trainings;

}
