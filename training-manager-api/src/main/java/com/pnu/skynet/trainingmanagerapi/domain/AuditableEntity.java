package com.pnu.skynet.trainingmanagerapi.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public class AuditableEntity extends BaseEntity {

    @CreatedBy
    private String createdBy;

    @CreatedDate
    private LocalDateTime createdDate;

}