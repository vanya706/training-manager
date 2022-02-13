package com.pnu.skynet.trainingmanagerapi.exception.handler;

import com.pnu.skynet.trainingmanagerapi.exception.EntityNotFoundException;
import com.pnu.skynet.trainingmanagerapi.exception.FieldValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.*;

@Slf4j
@RestControllerAdvice
public class ExceptionInterceptor {


    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(FieldValidationException.class)
    public ErrorResponse handleFieldValidationException(FieldValidationException e) {
        log.info(e.getLocalizedMessage(), e);
        return new ErrorResponse(e.getField(), e.getErrorMessage());
    }


    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(EntityNotFoundException.class)
    public ErrorResponse handleEntityNotFoundException(EntityNotFoundException e) {
        log.info("{} entity not found by the id: {}", e.getClazz().getSimpleName(), e.getId(), e);
        return new ErrorResponse(e.getLocalizedMessage());
    }


    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.debug(e.getMessage(), e);
        return new ErrorResponse(e.getBindingResult());
    }


    @ResponseStatus(UNPROCESSABLE_ENTITY)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ErrorResponse handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        log.error(e.getMessage(), e);
        return new ErrorResponse(e.getLocalizedMessage());
    }


    @ResponseStatus(INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RuntimeException.class)
    public ErrorResponse handleRuntimeException(RuntimeException e) {
        log.error(e.getMessage(), e);
        return new ErrorResponse(e.getLocalizedMessage());
    }


    private record ErrorResponse(List<FieldError> errors) {

        private ErrorResponse(BindingResult bindingResult) {
            this(bindingResult.getFieldErrors()
                    .stream()
                    .map(FieldError::new)
                    .collect(Collectors.toList()));
        }

        private ErrorResponse(String field, String errorMessage) {
            this(Collections.singletonList(new FieldError(field, errorMessage)));
        }

        private ErrorResponse(String errorMessage) {
            this("GENERAL_ERROR", errorMessage);
        }

        private record FieldError(String field, String error) {

            private FieldError(org.springframework.validation.FieldError fieldError) {
                this(fieldError.getField(), fieldError.getDefaultMessage());
            }

        }

    }

}
