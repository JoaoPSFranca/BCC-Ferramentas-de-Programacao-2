package br.edu.ifsp.pep.bcc.estoque.dto;

import br.edu.ifsp.pep.bcc.estoque.model.entities.Client;
import lombok.Getter;
import lombok.Setter;

//@Getter
//@Setter
//public class ClientDTO {
//
//    private String nome;
//    private String email;
//    private String telefone;
//
//    public Client transformToObject() {
//        return new Client(this.nome, this.email, this.telefone);
//    }
//}

public record ClientDTO (String nome, String email, String telefone) {
    public Client transformToObject() {
        return new Client(this.nome, this.email, this.telefone);
    }
}