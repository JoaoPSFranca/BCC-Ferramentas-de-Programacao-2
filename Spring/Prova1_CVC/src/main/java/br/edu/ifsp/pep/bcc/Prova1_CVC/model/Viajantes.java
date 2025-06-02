package br.edu.ifsp.pep.bcc.Prova1_CVC.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="viajantes")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@IdClass(ViajantesID.class)
public class Viajantes {
    @Id
    @ManyToOne
    @EqualsAndHashCode.Include
    @JoinColumn(name = "idPacote", referencedColumnName = "idPacote")
    private Pacote pacote;

    @Id
    @Size(min = 11, max = 14)
    @EqualsAndHashCode.Include
    @Column(name="cpf", length = 14)
    private String cpf;

    @NotNull
    @NotBlank
    @Size(min = 2, max = 45)
    @Column(name="nome", length = 45)
    private String nome;

    @Past
    @NotNull
    @NotBlank
    @Column(name="datanasc")
    private LocalDate dataNasc;
}
