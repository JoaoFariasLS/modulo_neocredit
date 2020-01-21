package com.neocredit.neocredit.repository;

import com.neocredit.neocredit.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
    Empresa findEmpresaByCnpj(String cnpj);
    Empresa findEmpresaById(Long id);
}
