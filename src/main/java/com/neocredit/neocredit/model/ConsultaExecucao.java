package com.neocredit.neocredit.model;

import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class ConsultaExecucao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date data;
    @OneToMany
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    private List<ConsultaEmpresa> listaConsultaEmpresa;

    public ConsultaExecucao(){
        listaConsultaEmpresa = new ArrayList<>();
    }
}
