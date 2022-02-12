package com.pnu.skynet.trainingmanagerapi.exception;

import lombok.Getter;

@Getter
public class FieldValidationException extends RuntimeException {

    private final String field;

    private final String errorMessage;


    public FieldValidationException(String field, Object value, String errorMessage) {
        super(String.format("Field: %s, has unexpected value: %s, error: %s", field, value, errorMessage));
        this.field = field;
        this.errorMessage = errorMessage;
    }


}
