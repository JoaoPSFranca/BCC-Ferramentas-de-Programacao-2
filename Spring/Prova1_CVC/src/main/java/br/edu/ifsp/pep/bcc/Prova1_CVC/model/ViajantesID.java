package br.edu.ifsp.pep.bcc.Prova1_CVC.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ViajantesID implements Serializable {
    private int pacote;
    private String cpf;
}
