package br.edu.ifsp.pep.bcc.Prova1_CVC.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="adicionais")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Adicionais {
    @Id
    @EqualsAndHashCode.Include
    @Column(name="idadicionais")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAdicionais;

    @NotNull
    @NotBlank
    @Size(min = 2, max = 100)
    @Column(name="descricao", length = 100)
    private String descricao;

    @NotNull
    @NotBlank
    @Column(name="valor")
    private float valor;

    public Adicionais(String descricao, float valor) {
        this.descricao = descricao;
        this.valor = valor;
    }
}
