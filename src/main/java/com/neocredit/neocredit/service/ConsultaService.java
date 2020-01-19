package com.neocredit.neocredit.service;

import com.neocredit.neocredit.model.*;
import com.neocredit.neocredit.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaService {
    @Autowired
    private ConsultaRepository repository;
    @Autowired
    private EmpresaService serviceEmpresa;

    public Consulta save(Consulta consulta){
        return repository.save(consulta);
    }
    public void delete(Long id){
        repository.deleteById(id);
    }
    public Consulta getById(Long id){
        return repository.getOne(id);
    }
    public List<Consulta> getAll(){
        return repository.findAll();
    }

    public ConsultaExecucao executarConsulta(Long id, List<String> listacnpj){
        Consulta consulta = repository.findConsultaById(id);
        ConsultaExecucao consultaExecucao = new ConsultaExecucao();
        for(String cnpj : listacnpj){
            Empresa emp = serviceEmpresa.getByCnpj(cnpj);

        }
        return null;
    }

    private Integer getScore(TipoDadoConsulta t, Empresa empresa, Consulta consulta){
        Integer score;
        for(DadoConsulta dc: consulta.getListaDadoConsulta()){
            if(t.equals(dc.getTipo())){
                for(DadoEmpresa de : empresa.getListaDado()){
                    if(dc.getDado().getId() == de.getDado().getId()){

                    }
                }
            }
        }
        return 0;
    }

    private Integer calcular(Dado dado, DadoConsulta dc, DadoEmpresa de){
        if(dado.getComparacao().equals(Comparacao.IGUAL)){
            for(OpcaoDado od : dado.getListaOpcoa()){
                if(od.getValorComparacao().equals(de.getValor())){
                    return od.getValorScore() * (dc.getPercentual() / 100);
                }
            }
        }
        return 0;
    }
}
