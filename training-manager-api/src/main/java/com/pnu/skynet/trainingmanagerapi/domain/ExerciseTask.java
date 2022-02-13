package com.pnu.skynet.trainingmanagerapi.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.time.Duration;

@Getter
@Setter
@Entity
public class ExerciseTask extends BaseEntity {

    private Integer sequenceNumber;

    private boolean isDone;

    // for the Exercise with type TIME
    private Duration expectedDuration;

    private Duration finalDuration;

    // for the Exercise with type AMOUNTS_OF_REPEATS
    private Integer expectedRepeats;

    private Integer finalRepeats;

}
