package com.neocredit.neocredit.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Collections;
import java.util.Comparator;
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
    @Cascade(value = CascadeType.ALL)
    private List<OpcaoDado> listaOpcoa;
    
    public OpcaoDado getOpcaoDado(String valor){
        OpcaoDado opcaoDado = null;
        if(comparacao == Comparacao.MAIOR_IGUAL) {
            listaOpcoa.sort(new SortByValor());
        }else if (comparacao == Comparacao.MENOR_IGUAL){
            listaOpcoa.sort(Collections.reverseOrder(new SortByValor()));
        }
        for (OpcaoDado od: this.listaOpcoa) {
            if(od.comparacao(valor, comparacao)){
                opcaoDado = od;
            }
        }
        return opcaoDado;
    }

    private class SortByValor implements Comparator<OpcaoDado>
    {
        public int compare(OpcaoDado a, OpcaoDado b)
        {
            return a.getValorComparacao().compareTo(b.getValorComparacao());
        }
    }
}
