package com.pnu.skynet.trainingmanagerapi.constant;

public enum UserRole {
    CUSTOMER, ADMIN;

    public String getNameWithRolePrefix() {
        return "ROLE_" + name();
    }

}
