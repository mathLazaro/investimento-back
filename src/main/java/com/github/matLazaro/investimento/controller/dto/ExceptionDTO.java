package com.github.matLazaro.investimento.controller.dto;

import org.springframework.validation.FieldError;

import java.util.List;

public record ExceptionDTO(
        Integer status,
        String message,
        List<FieldErrorDTO> errors
) {

}
