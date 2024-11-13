package com.dev.Backend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "producto_imagens")
@Data
public class imagem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataActualizacao;
    @ManyToOne
    @JoinColumn(name = "producto_id", nullable = false)
    private  Producto producto;
}
