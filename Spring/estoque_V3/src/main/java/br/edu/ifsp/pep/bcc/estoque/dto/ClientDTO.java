package br.edu.ifsp.pep.bcc.estoque.dto;

import br.edu.ifsp.pep.bcc.estoque.model.entities.Client;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class ClientDTO {

    @NotBlank
    private String nome;

    @NotBlank
    private String email;

    @NotBlank
    private String telefone;

    public Client convertToObject() {
        return new Client(this.nome, this.email, this.telefone);
    }
}

//public record ClientDTO (String nome, String email, String telefone) {
//    public Client convertToObject() {
//        return new Client(this.nome, this.email, this.telefone);
//    }
//}