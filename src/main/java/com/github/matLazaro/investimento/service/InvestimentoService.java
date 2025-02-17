package com.github.matLazaro.investimento.service;

import com.github.matLazaro.investimento.domain.Investimento;
import com.github.matLazaro.investimento.repository.InvestimentoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InvestimentoService {

    private final InvestimentoRepository repository;

    public Investimento get(Long id) {

        Optional<Investimento> opt = repository.findById(id);
        if (opt.isEmpty())
            throw new EntityNotFoundException("Id não encontrado");
        return opt.get();
    }

    public Page<Investimento> list(Pageable pageRequest) {

        return repository.findAll(pageRequest);
    }

    public Long create(Investimento investimento) {
        return repository.save(investimento).getId();
    }

    @Transactional
    public void update(Long id, Investimento input) {

        Investimento investimentoOnDB = get(id);
        investimentoOnDB.setNome(input.getNome());
        investimentoOnDB.setTipo(input.getTipo());
        investimentoOnDB.setData(input.getData());
        investimentoOnDB.setValor(input.getValor());
    }

    @Transactional
    public void delete(Long id) {

        // verifica se o id existe no BD
        Investimento investimentoToDelete = get(id);
        repository.delete(investimentoToDelete);
    }



}
