package br.edu.ifsp.pep.bcc.Prova1_CVC.dto;

import br.edu.ifsp.pep.bcc.Prova1_CVC.model.Cliente;
import br.edu.ifsp.pep.bcc.Prova1_CVC.model.StatusPacote;
import br.edu.ifsp.pep.bcc.Prova1_CVC.model.Viajantes;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public record PacoteDTO (
        @Id
        @Column(name="idPacote")
        @EqualsAndHashCode.Include
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        int idPacote,

        @NotNull
        @NotBlank
        @FutureOrPresent
        @Column(name="dataviagem")
        LocalDate dataViagem,

        @NotNull
        @NotBlank
        @Future
        @Column(name="dataretorno")
        LocalDate dataRetorno,

        @NotNull
        @NotBlank
        @Positive
        @Column(name="qtddiarias")
        int qtdDiarias,

        @NotNull
        @NotBlank
        @Positive
        @Column(name="valordiaria")
        float valorDiaria,

        @NotNull
        @NotBlank
        @Positive
        @Column(name="valortotal")
        float valorTotal,

        @NotNull
        @ManyToOne
        @JoinColumn(name = "idCliente", referencedColumnName = "idCliente")
        Cliente cliente,

        @Enumerated(EnumType.STRING)
        @Column(name="status", nullable = false)
        StatusPacote status
) {}
