package com.neocredit.neocredit.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class ConsultaEmpresa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date data;
    private Integer scoreFinal;
    private Integer scoreM;
    private Integer scoreD;
    @ManyToOne
    private Conceito conceito;
    @ManyToOne
    private Empresa empresa;

    public ConsultaEmpresa(){

    }

    public ConsultaEmpresa(Date data, Integer scoreM, Integer scoreD, Empresa empresa){
        this.data = data;
        this.empresa = empresa;
        this.scoreM = scoreM;
        this.scoreD = scoreD;
        this.scoreFinal = scoreM - scoreD;
    }

    public void setConceito(List<Conceito> lista){
        lista.sort(new SortByPiso());
        for(Conceito c : lista){
            if(c.getPiso() <= this.scoreFinal)
                this.conceito = c;
        }
    }

    private class SortByPiso implements Comparator<Conceito>
    {
        public int compare(Conceito a, Conceito b)
        {
            return a.getPiso().compareTo(b.getPiso());
        }
    }

}
