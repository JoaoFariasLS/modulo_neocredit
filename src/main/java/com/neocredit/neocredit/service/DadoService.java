package com.neocredit.neocredit.service;

import com.neocredit.neocredit.model.Dado;
import com.neocredit.neocredit.model.Dado;
import com.neocredit.neocredit.repository.DadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DadoService {
    @Autowired
    private DadoRepository repository;

    public Dado save(Dado dado){
        return repository.save(dado);
    }

    public List<Dado> save(List<Dado> listaDado){
        return repository.saveAll(listaDado);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
    public Dado getById(Long id){
        return repository.findDadoById(id);
    }
    public Dado getByNome(String nome){
        return repository.findDadoByNome(nome);
    }
    public List<Dado> getAll(){
        return repository.findAll();
    }
}
