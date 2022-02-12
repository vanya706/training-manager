package com.pnu.skynet.trainingmanagerapi.exception;

import lombok.Getter;

@Getter
public class EntityNotFoundException extends RuntimeException {

    private final Class<?> clazz;

    private final String id;

    public EntityNotFoundException(Class<?> clazz, String id) {
        super(String.format("%s not found!", clazz.getSimpleName()));
        this.clazz = clazz;
        this.id = id;
    }

}
