package com.neocredit.neocredit.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class DadoEmpresa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String valor;
    @ManyToOne
    private Dado dado;

    public boolean isDadoType(Dado dado){
        return this.dado.getId() == dado.getId();
    }
}
