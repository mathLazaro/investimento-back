package com.github.matLazaro.investimento.repository;


import com.github.matLazaro.investimento.domain.Investimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvestimentoRepository extends JpaRepository<Investimento, Long> {

}
