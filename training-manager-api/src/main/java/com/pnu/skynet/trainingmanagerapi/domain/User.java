package com.pnu.skynet.trainingmanagerapi.domain;

import com.pnu.skynet.trainingmanagerapi.constant.UserRole;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;


@Getter
@Setter
@Entity
@Table(name = "A_USER")
public class User extends BaseEntity {

    private String firstName;

    private String lastName;

    @Column(updatable = false)
    private String username;

    private String email;

    private LocalDate birthday;

    private String logoImage;

    private Integer height;

    private Integer weight;

    private String password;

    @Enumerated(EnumType.STRING)
    @Column(updatable = false)
    private UserRole userRole;

}
