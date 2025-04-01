package br.edu.ifsp.pep.bcc.serviceOrder.controller.dto;

import br.edu.ifsp.pep.bcc.serviceOrder.model.entities.Client;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ClientResponseDTO {
    private int id;
    private String name;
    private String email;
    private String phone;
    private int active;

    public static ClientResponseDTO convertToDTO(Client client) {
        return new ClientResponseDTO(client.getId(), client.getName(), client.getEmail(), client.getPhone(), client.getActive());
    }
}
