package com.neocredit.neocredit.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Data
public class Dado {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    @Enumerated(EnumType.STRING)
    private TipoDado tipo;
    @Enumerated(EnumType.STRING)
    private Comparacao comparacao;
    @OneToMany
    @JoinColumn(name = "dado_id")
    @Cascade(value = CascadeType.ALL)
    private List<OpcaoDado> listaOpcoa;
}
