package com.neocredit.neocredit.model;

import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String cnpj;
    private String razao_social;
    private String nome_fantasia;
    @OneToMany
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    private List<DadoEmpresa> listaDado;

    public DadoEmpresa getDadoEmpresaByDado(Dado dado){
        for(DadoEmpresa de: this.listaDado){
            if(de.isDadoType(dado)){
                return de;
            }
        }
        return null;
    }
}
