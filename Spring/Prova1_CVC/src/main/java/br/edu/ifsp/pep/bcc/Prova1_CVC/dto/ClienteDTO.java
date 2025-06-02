package br.edu.ifsp.pep.bcc.Prova1_CVC.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;

public record ClienteDTO (
        @Id
        @Column(name="idCliente")
        @EqualsAndHashCode.Include
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        int idCliente,

        @NotNull
        @NotBlank
        @Size(min = 2, max = 45)
        @Column(name="Nome", length = 45)
        String nome,

        @NotNull
        @Column(name="CPF", length = 14)
        @NotBlank
        @Size(min = 11, max = 14)
        String cpf
){}