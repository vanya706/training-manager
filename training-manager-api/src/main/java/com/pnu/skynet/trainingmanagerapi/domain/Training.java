package com.pnu.skynet.trainingmanagerapi.domain;

import com.pnu.skynet.trainingmanagerapi.constant.Color;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.Duration;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Training extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private Color color = Color.GREEN;

    private LocalDateTime startDate;

    private Duration duration;

}
