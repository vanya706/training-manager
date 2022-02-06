package com.pnu.skynet.trainingmanagerapi.domain;

import com.pnu.skynet.trainingmanagerapi.constant.UserRole;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.time.LocalDate;


@Getter
@Setter
@Entity
@Table(name = "A_USER")
public class User extends BaseEntity {

    private String firstName;

    private String lastName;

    private String username;

    private String email;

    private LocalDate birthday;

    private String logoImage;

    private Integer height;

    private Integer weight;

    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole userRole;

}
