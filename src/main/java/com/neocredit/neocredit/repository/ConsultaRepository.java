package com.neocredit.neocredit.repository;

import com.neocredit.neocredit.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    Consulta findConsultaById(Long id);
}
