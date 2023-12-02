package com.arthur.ordermanagerapi.entity;
import com.arthur.ordermanagerapi.generic.EntidadeGenerica;
import jakarta.persistence.*;
import lombok.*;

@Getter @Setter @NoArgsConstructor
@Entity
@Table(name = "clientes")
public class Cliente extends EntidadeGenerica {

    @Column(name = "nome")
    private String nome;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "cnpj")
    private String cnpj;

    @Column(name = "cpf")
    private String cpf;

    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;
}
