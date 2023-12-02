package com.arthur.ordermanagerapi.generic;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter @Setter
@MappedSuperclass
public class EntidadeGenerica implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "data_cadastro")
    private Date dataCadastro;

    @Column(name = "data_edicao")
    private Date dataEdicao;

    public EntidadeGenerica() {
        this.active = Boolean.TRUE;
        setDataCadastro(new Date());
    }
}
