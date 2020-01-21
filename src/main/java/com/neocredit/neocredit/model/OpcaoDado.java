package com.neocredit.neocredit.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class OpcaoDado {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String valorComparacao;
    private Integer valorScore;

    public boolean comparacao(String valor, Comparacao c){
        switch (c){
            case IGUAL:
                return valor.equals(this.valorComparacao);
            case MAIOR_IGUAL:
                return Float.parseFloat(valor) >= Float.parseFloat(this.valorComparacao);
            case MENOR_IGUAL:
                return Float.parseFloat(valor) <= Float.parseFloat(this.valorComparacao);
            default:
                return false;
        }
    }
}
