package com.pnu.skynet.trainingmanagerapi.domain;

import com.pnu.skynet.trainingmanagerapi.constant.BodyPart;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.Set;

@Getter
@Setter
@Entity
public class Exercise extends BaseEntity {

    private String name;

    @SuppressWarnings("JpaAttributeTypeInspection")
    private Set<BodyPart> relatedBodyParts;

}
