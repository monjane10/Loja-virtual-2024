package com.dev.Backend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "pessoa")
@Data
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String bi;
    private String email;
    private String Senha;
    private String endereco;
    private String nuit;

    @ManyToOne
    @JoinColumn(name = "idCidade")
    private Cidade cidade;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataActualizacao;

}
