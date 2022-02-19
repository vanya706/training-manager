package com.pnu.skynet.trainingmanagerapi.domain;

import com.pnu.skynet.trainingmanagerapi.constant.Color;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Training extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private Color color = Color.GREEN;

    private LocalDateTime startDate;

    private Duration duration;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(nullable = false)
    private Program program;

    @OneToMany(mappedBy = "training")
    private List<ExerciseTask> exerciseTasks;

}
