package br.edu.ifsp.pep.bcc.Prova1_CVC.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Pacote")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Pacote {
    @Id
    @Column(name="idPacote")
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPacote;

    @NotNull
    @NotBlank
    @FutureOrPresent
    @Column(name="dataviagem")
    private LocalDate dataViagem;

    @NotNull
    @NotBlank
    @Future
    @Column(name="dataretorno")
    private LocalDate dataRetorno;

    @NotNull
    @NotBlank
    @Positive
    @Column(name="qtddiarias")
    private int qtdDiarias;

    @NotNull
    @NotBlank
    @Positive
    @Column(name="valordiaria")
    private float valorDiaria;

    @NotNull
    @NotBlank
    @Positive
    @Column(name="valortotal")
    private float valorTotal;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "idCliente", referencedColumnName = "idCliente")
    private Cliente cliente;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pacote", orphanRemoval = true)
    List<Viajantes> viajantes = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    @Column(name="status", nullable = false)
    private StatusPacote status;

    public Pacote(LocalDate dataViagem, LocalDate dataRetorno, int qtdDiarias, float valorDiaria, Cliente cliente) {
        this.dataViagem = dataViagem;
        this.dataRetorno = dataRetorno;
        this.qtdDiarias = qtdDiarias;
        this.valorDiaria = valorDiaria;
        this.valorTotal = valorDiaria * qtdDiarias;
        this.cliente = cliente;
        this.status = StatusPacote.ABERTO;
    }
}
