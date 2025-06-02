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
@Table(name="Cliente")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cliente {

    @Id
    @Column(name="idCliente")
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCliente;

    @NotNull
    @NotBlank
    @Size(min = 2, max = 45)
    @Column(name="Nome", length = 45)
    private String nome;

    @NotNull
    @Column(name="CPF", length = 14)
    @NotBlank
    @Size(min = 11, max = 14)
    private String cpf;

    @NotNull
    @Column(name="RG", length = 12)
    @NotBlank
    @Size(min = 8, max = 12)
    private String rg;

    @NotNull
    @Column(name="Telefone", length = 14)
    @NotBlank
    @Size(min = 11, max = 14)
    private String telefone;

    @NotNull
    @Column(name="Endereco", length = 65)
    @NotBlank
    @Size(min = 5, max = 65)
    private String endereco;

    @NotNull
    @Column(name="Cidade", length = 45)
    @NotBlank
    @Size(min = 2, max = 45)
    private String cidade;

    @NotNull
    @Column(name="Estado", length = 2)
    @NotBlank
    @Size(min = 2, max = 2)
    private String estado;

    public Cliente(String nome, String cpf, String rg, String telefone, String endereco, String cidade, String estado) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.telefone = telefone;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
    }
}
