package com.arthur.ordermanagerapi.entity;

import com.arthur.ordermanagerapi.generic.EntidadeGenerica;
import jakarta.persistence.*;
import lombok.*;

@Getter @Setter @NoArgsConstructor
@Entity
@Table(name = "enderecos")
public class Endereco extends EntidadeGenerica {
    @Column(name = "casa")
    private String casa;
    @Column(name = "rua")
    private String rua;
    @Column(name = "bairro")
    private String bairro;
    @Column(name = "cep")
    private String cep;
    @Column(name = "referencia")
    private String referencia;
}
