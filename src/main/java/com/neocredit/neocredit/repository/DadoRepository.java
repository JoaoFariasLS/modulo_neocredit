package com.neocredit.neocredit.repository;

import com.neocredit.neocredit.model.Dado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DadoRepository extends JpaRepository<Dado, Long> {
    public Dado findDadoById(Long id);
    public Dado findDadoByNome(String nome);
}
