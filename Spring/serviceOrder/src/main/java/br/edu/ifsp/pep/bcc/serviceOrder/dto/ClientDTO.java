package br.edu.ifsp.pep.bcc.serviceOrder.dto;

import br.edu.ifsp.pep.bcc.serviceOrder.model.Client;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;

public record ClientDTO(
    @NotBlank
    @Size(min = 3, max = 50)
    String name,

    @Email
    String email,

    @NotBlank
    @Pattern(regexp = "\\(\\d{2}\\)\\s\\d{4,5}\\-\\d{4}")
    String phone
){}