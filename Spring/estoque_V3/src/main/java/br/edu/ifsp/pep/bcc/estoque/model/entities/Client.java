package br.edu.ifsp.pep.bcc.estoque.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Getter // cria todos os gets da entity
@Setter // cria todos os setters da entity
@NoArgsConstructor // cria um construtor vazio
@AllArgsConstructor // cria um construtor com todos os atributos
@EqualsAndHashCode(onlyExplicitlyIncluded = true) // cria o metodo equals e hashCode

@Table(name = "cliente")
public class Client {

    @Id
    @Column(name = "codigo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include // incluindo o atributo no equals and hashCode
    private int codigo;

    @NotBlank(message = "O nome não pode ser vazio")
    @Size(min = 3, max = 60, message = "O nome precisa ter entre 3 e 60 caracteres")
    @Column(name = "nome", length = 60, nullable = false)
    private String nome;

    @Email
    @NotBlank(message = "O email não pode ser vazio")
    @Column(name = "email", length = 30 ,nullable = false)
    private String email;

    @NotBlank(message = "O telefone não pode ser vazio")
    @Size(min = 8, max = 15, message = "O telefone deve ter entre 8 e 15 caracteres")
    @Column(name = "telefone", length = 15, nullable = false)
    private String telefone;

    @Column(name = "ativo")
    private int ativo;

    public Client(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.ativo  = 1;
    }
}
