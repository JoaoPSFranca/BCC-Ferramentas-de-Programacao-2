package br.edu.ifsp.pep.bcc.serviceOrder.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record ServiceOrderDTO(
    @NotNull
    @NotBlank
    @PastOrPresent
    LocalDate openDate,

    @PastOrPresent
    LocalDate closeDate,

    @NotNull
    @NotBlank
    @Size(min=3, max=20)
    String paymentMethod
) {

}
