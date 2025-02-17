package com.github.matLazaro.investimento.controller.dto;


import com.github.matLazaro.investimento.domain.TipoInvestimento;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

// dto para validação e operações IO da api
public record InvestimentoDTO(
        String nome,
        TipoInvestimento tipo,
        @Positive(message = "Deve ser positivo")
        Double valor,
        @PastOrPresent(message = "Deve ser data passada ou atual")
        LocalDate data
) {

}
