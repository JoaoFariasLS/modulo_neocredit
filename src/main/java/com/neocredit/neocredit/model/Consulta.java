package com.neocredit.neocredit.model;

import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    @OneToMany
    @JoinColumn(name = "consulta_id")
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    private List<Conceito> listaConceito;
    @OneToMany
    @JoinColumn(name = "consulta_id")
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    private List<DadoConsulta> listaDadoConsulta;
    @OneToMany
    @JoinColumn(name = "consulta_id")
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    private List<ConsultaExecucao> listaConsultaExecucao;
}
