package br.edu.ifsp.pep.bcc.estoque.dto;

import br.edu.ifsp.pep.bcc.estoque.model.entities.Client;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ClientResponseDTO {
    private int codigo;
    private String nome;
    private String email;
    private String telefone;
    private int ativo;

    public static ClientResponseDTO convertToDTO(Client client){
        return new ClientResponseDTO(client.getCodigo(), client.getNome(), client.getEmail(), client.getTelefone(), client.getAtivo());
    }
}
