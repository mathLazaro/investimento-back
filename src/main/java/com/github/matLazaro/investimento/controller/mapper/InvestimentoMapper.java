package com.github.matLazaro.investimento.controller.mapper;

import com.github.matLazaro.investimento.controller.dto.InvestimentoDTO;
import com.github.matLazaro.investimento.domain.Investimento;
import org.springframework.stereotype.Component;

@Component
public class InvestimentoMapper {

    public Investimento toInvestimento(InvestimentoDTO investimentoDTO) {

        return Investimento.builder()
                .nome(investimentoDTO.nome())
                .tipo(investimentoDTO.tipo())
                .valor(investimentoDTO.valor())
                .data(investimentoDTO.data())
                .build();
    }

    public InvestimentoDTO toInvestimentoDTO(Investimento investimento) {

        return new InvestimentoDTO(
                investimento.getNome(),
                investimento.getTipo(),
                investimento.getValor(),
                investimento.getData()
        );
    }

}
