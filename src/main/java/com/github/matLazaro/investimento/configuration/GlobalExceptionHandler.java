package com.github.matLazaro.investimento.configuration;

import com.github.matLazaro.investimento.controller.dto.ExceptionDTO;
import com.github.matLazaro.investimento.controller.dto.FieldErrorDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ExceptionDTO handleFieldConstraintViolation(MethodArgumentNotValidException e) {

        List<FieldError> fieldErrors = e.getFieldErrors();
        List<FieldErrorDTO> fieldErrorsDTO = fieldErrors.stream().map(fieldError ->
                new FieldErrorDTO(fieldError.getField(), fieldError.getDefaultMessage())).toList();
        return new ExceptionDTO(HttpStatus.BAD_REQUEST.value(), "Violação de restrição", fieldErrorsDTO);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ExceptionDTO handleEntityNotFoundException(EntityNotFoundException e) {

        return new ExceptionDTO(HttpStatus.NOT_FOUND.value(), e.getMessage(), List.of());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ExceptionDTO handleEnumConstraintViolationC(HttpMessageNotReadableException e) {

        return new ExceptionDTO(HttpStatus.BAD_REQUEST.value(),
                "Violação de tipo de investimento. Deve estar contido em {ACAO, FUNDO, TITULO}",
                List.of());
    }

}
