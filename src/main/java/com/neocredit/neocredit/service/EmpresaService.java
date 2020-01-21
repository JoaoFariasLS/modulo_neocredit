package com.neocredit.neocredit.service;

import com.neocredit.neocredit.model.DadoConsulta;
import com.neocredit.neocredit.model.DadoEmpresa;
import com.neocredit.neocredit.model.Empresa;
import com.neocredit.neocredit.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpresaService {
    @Autowired
    private EmpresaRepository repository;
    @Autowired
    private DadoService serviceDado;

    public Empresa save(Empresa empresa){
        for (DadoEmpresa de: empresa.getListaDado()){
            String nome = de.getDado().getNome();
            de.setDado(this.serviceDado.getByNome(nome));
        }
        return repository.save(empresa);
    }
    public List<Empresa> save(List<Empresa> listaEmpresa){
        List<Empresa> lista = new ArrayList<>();
        for (Empresa e: listaEmpresa){
            lista.add(this.save(e));
        }
        return lista;
    }
    public void delete(Long id){
        repository.deleteById(id);
    }
    public Empresa getById(Long id){
        return repository.findEmpresaById(id);
    }
    public List<Empresa> getAll(){
        return repository.findAll();
    }
    public Empresa getByCnpj(String cnpj){
        return repository.findEmpresaByCnpj(cnpj);
    }
}
