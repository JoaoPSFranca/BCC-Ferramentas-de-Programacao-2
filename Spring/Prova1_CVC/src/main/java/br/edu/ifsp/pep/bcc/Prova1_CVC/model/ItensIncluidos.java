package br.edu.ifsp.pep.bcc.Prova1_CVC.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="itensincluidos")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@IdClass(ItensIncluidosID.class)
public class ItensIncluidos {

    @Id
    @ManyToOne
    @EqualsAndHashCode.Include
    @JoinColumn(name = "idPacote", referencedColumnName = "idPacote")
    private Pacote pacote;

    @Id
    @ManyToOne
    @EqualsAndHashCode.Include
    @JoinColumn(name = "idadicionais", referencedColumnName = "idadicionais")
    private Adicionais adicionais;

    @NotNull
    @NotBlank
    @Positive
    @Column(name="quantidade")
    private int quantidade;

    @NotNull
    @NotBlank
    @Positive
    @Column(name="valor")
    private float valor;
}
