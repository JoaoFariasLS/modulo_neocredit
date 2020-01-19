package com.neocredit.neocredit.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class DadoConsulta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Enumerated(EnumType.STRING)
    private TipoDadoConsulta tipo;
    private Integer percentual;
    @ManyToOne
    private Dado dado;
}
