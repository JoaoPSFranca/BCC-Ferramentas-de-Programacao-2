package br.edu.ifsp.pep.bcc.Prova1_CVC.dto;

import br.edu.ifsp.pep.bcc.Prova1_CVC.model.Cliente;
import br.edu.ifsp.pep.bcc.Prova1_CVC.model.StatusPacote;

import java.time.LocalDate;

public record PacoteResponseDTO(
        int idPacote,
        LocalDate dataViagem,
        LocalDate dataRetorno,
        int qtdDiarias,
        float valorDiaria,
        float valorTotal,
        Cliente cliente,
        StatusPacote status) {
}
