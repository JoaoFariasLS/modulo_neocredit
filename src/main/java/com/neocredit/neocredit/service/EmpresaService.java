package com.neocredit.neocredit.service;

import com.neocredit.neocredit.model.Empresa;
import com.neocredit.neocredit.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaService {
    @Autowired
    private EmpresaRepository repository;

    public Empresa save(Empresa empresa){
        return repository.save(empresa);
    }
    public void delete(Long id){
        repository.deleteById(id);
    }
    public Empresa getById(Long id){
        return repository.getOne(id);
    }
    public List<Empresa> getAll(){
        return repository.findAll();
    }
    public Empresa getByCnpj(String cnpj){
        return repository.findEmpresaByCnpj(cnpj);
    }
}
