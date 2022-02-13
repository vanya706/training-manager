package com.pnu.skynet.trainingmanagerapi.domain;

import com.pnu.skynet.trainingmanagerapi.constant.BodyPart;
import com.pnu.skynet.trainingmanagerapi.constant.ExerciseType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Set;

@Getter
@Setter
@Entity
public class Exercise extends BaseEntity {

    private String name;

    @Enumerated(EnumType.STRING)
    private ExerciseType type;

    @SuppressWarnings("JpaAttributeTypeInspection")
    private Set<BodyPart> relatedBodyParts;

}
