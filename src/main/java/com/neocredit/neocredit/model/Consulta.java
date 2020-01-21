package com.neocredit.neocredit.model;

import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    @OneToMany
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    private List<Conceito> listaConceito;
    @OneToMany
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    private List<DadoConsulta> listaDadoConsulta;
    @OneToMany
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    private List<ConsultaExecucao> listaConsultaExecucao;

    public List<DadoConsulta> getListaDadoConsultaByTipoDadoConsulta(TipoDadoConsulta tipo){
        List<DadoConsulta> lista = new ArrayList<>();
        for(DadoConsulta dc : this.listaDadoConsulta){
            if(dc.getTipo().equals(tipo)){
                lista.add(dc);
            }
        }
        return lista;
    }
}
