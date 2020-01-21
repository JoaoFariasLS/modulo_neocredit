package com.neocredit.neocredit.service;

import com.neocredit.neocredit.model.*;
import com.neocredit.neocredit.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ConsultaService {
    @Autowired
    private ConsultaRepository repository;
    @Autowired
    private EmpresaService serviceEmpresa;
    @Autowired
    private DadoService serviceDado;

    public Consulta save(Consulta consulta){
        for (DadoConsulta dc: consulta.getListaDadoConsulta()){
            String nome = dc.getDado().getNome();
            dc.setDado(this.serviceDado.getByNome(nome));
        }
        return repository.save(consulta);
    }
    public void delete(Long id){
        repository.deleteById(id);
    }
    public Consulta getById(Long id){
        return repository.findConsultaById(id);
    }
    public List<Consulta> getAll(){
        return repository.findAll();
    }

    public ConsultaExecucao executarConsulta(Long id, List<String> listacnpj){
        Consulta consulta = repository.findConsultaById(id);
        ConsultaExecucao consultaExecucao = new ConsultaExecucao();
        Date data = new Date();
        consultaExecucao.setData(data);
        for(String cnpj : listacnpj){
            Empresa emp = serviceEmpresa.getByCnpj(cnpj);
            if(emp != null) {
                Integer scoreM = this.getScore(TipoDadoConsulta.M, emp, consulta);
                Integer scoreD = this.getScore(TipoDadoConsulta.D, emp, consulta);
                ConsultaEmpresa ce = new ConsultaEmpresa(data, scoreM, scoreD, emp);
                ce.setConceito(consulta.getListaConceito());
                consultaExecucao.getListaConsultaEmpresa().add(ce);
            }
        }
        consulta.getListaConsultaExecucao().add(consultaExecucao);
        this.repository.save(consulta);
        return consultaExecucao;
    }

    private Integer getScore(TipoDadoConsulta t, Empresa empresa, Consulta consulta){
        Integer score = 0;

        List<DadoConsulta> listaDC = consulta.getListaDadoConsultaByTipoDadoConsulta(t);
        for(DadoConsulta dc: listaDC){
            DadoEmpresa de = empresa.getDadoEmpresaByDado(dc.getDado());
            if(de != null){
                score += this.calcular(dc, de);
            }
        }
        return score;
    }

    private Integer calcular(DadoConsulta dc, DadoEmpresa de){
        Dado dado = dc.getDado();
        OpcaoDado od = dado.getOpcaoDado(de.getValor());
        if(od != null) {
            return od.getValorScore() * dc.getPercentual() / 100;
        }
        return 0;
    }
}
