package com.github.matLazaro.investimento.controller;

import com.github.matLazaro.investimento.controller.dto.InvestimentoDTO;
import com.github.matLazaro.investimento.controller.mapper.InvestimentoMapper;
import com.github.matLazaro.investimento.domain.Investimento;
import com.github.matLazaro.investimento.service.InvestimentoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("investimentos")
@RequiredArgsConstructor
public class InvestimentoController {

    private final InvestimentoService service;
    private final InvestimentoMapper mapper;

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public InvestimentoDTO getInvestimento(@PathVariable("id") Long id) {

        Investimento data = service.get(id);
        return mapper.toInvestimentoDTO(data);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Page<Investimento> listInvestimento(@RequestParam(required = false, defaultValue = "0") @PositiveOrZero Integer page,
                                               @RequestParam(required = false, defaultValue = "20") @Positive Integer size) {

        PageRequest request = PageRequest.of(page, size, Sort.by("id"));
        return service.list(request);
    }


    @PostMapping
    public ResponseEntity<Object> postInvestimento(@RequestBody @Valid InvestimentoDTO investimento) {

        Long id = service.create(mapper.toInvestimento(investimento));
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(id).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void putInvestimento(@PathVariable("id") Long id, @RequestBody InvestimentoDTO investimento) {

        service.update(id, mapper.toInvestimento(investimento));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteInvestimento(@PathVariable("id") Long id) {

        service.delete(id);
    }
}
