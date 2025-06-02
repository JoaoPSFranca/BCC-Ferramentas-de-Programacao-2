package br.edu.ifsp.pep.bcc.Prova1_CVC.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ClienteResponseDTO(
        int idCliente,
        String nome,
        String cpf
){}
