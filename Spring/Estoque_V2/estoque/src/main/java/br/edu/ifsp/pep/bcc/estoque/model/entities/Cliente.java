package br.edu.ifsp.pep.bcc.estoque.model.entities;

import jakarta.persistence.*;
import lombok.*;

// Isso pode ficar tudo em uma linha só separado por espaço
@Entity
@Getter //cria todos os gets
@Setter //cria todos os sets
@EqualsAndHashCode(onlyExplicitlyIncluded = true) // cria os hash e define quem vai ser usado para criar
@NoArgsConstructor // cria o contrutor vazio
@AllArgsConstructor // cria o construtor com tudo
@Table(name="cliente")
public class Cliente {
    @Id
    @Column(name="codigo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include // fala que o código vai ser usado no equals
    private int codigo;

    @Column(name="nome", length = 60, nullable = false)
    private String nome;
    @Column(name="email", length = 30, nullable = false)
    private String email;
    @Column(name="telefone", length = 15, nullable = false)
    private String telefone;
}
