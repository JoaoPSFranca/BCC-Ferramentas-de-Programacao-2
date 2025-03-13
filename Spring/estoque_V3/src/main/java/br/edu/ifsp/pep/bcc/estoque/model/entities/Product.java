package br.edu.ifsp.pep.bcc.estoque.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "produto")
public class Product {

    @Id
    @Column(name = "codigo")
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @NotBlank(message = "Descrição do produto não pode estar vaiza. ")
    @Size(min = 2, max = 50, message = "Descrição deve conter entre 2 e 50 caracteres. ")
    @Column(name = "descricao", length = 50, nullable = false)
    private String descricao;

    @NotBlank(message = "Valor não pode estar vazio. ")
    @Column(name = "valor", nullable = false)
    private  double valor;

}
