package br.edu.ifsp.pep.bcc.estoque.model.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "produto")
@Getter @Setter @EqualsAndHashCode(onlyExplicitlyIncluded = true) @NoArgsConstructor @AllArgsConstructor
public class Produto {
    @Id
    @Column(name="codigo")
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @Column(name = "descricao", length = 60, nullable = false)
    private String descricao;

    @Column(name = "preco")
    private double preco;
}
