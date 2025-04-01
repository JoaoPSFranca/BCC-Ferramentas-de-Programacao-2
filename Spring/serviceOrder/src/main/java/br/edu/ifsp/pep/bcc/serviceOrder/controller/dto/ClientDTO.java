package br.edu.ifsp.pep.bcc.serviceOrder.controller.dto;

import br.edu.ifsp.pep.bcc.serviceOrder.model.entities.Client;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class ClientDTO {

    @NotBlank
    private String name;

    @NotBlank
    private String email;

    @NotBlank
    private String phone;

    public Client convertToEntity() { return new Client(this.name, this.email, this.phone); }
}
