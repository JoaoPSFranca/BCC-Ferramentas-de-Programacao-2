package br.edu.ifsp.pep.bcc.serviceOrder.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="service_order")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ServiceOrder {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;

    @NotNull
    @PastOrPresent
    @Column(name="open_date")
    @NotBlank(message = "OpenDate can't be empty. ")
    private LocalDate openDate;

    @NotNull
    @PastOrPresent
    @Column(name="close_date")
    private LocalDate closeDate;

    @NotNull
    @Column(name="payment_method")
    @NotBlank(message = "Payment Method can't be empty. ")
    @Size(min=3, max=20, message = "Payment Method must contain between 3 and 20 characters. ")
    private String paymentMethod;

    @NotNull
    @Column(name="status")
    private int status;

    @NotNull
    @ManyToOne
    @JoinColumn(name="client_id", referencedColumnName = "id")
    private Client client;

    public ServiceOrder(String paymentMethod, int id, Client client) {
        this.paymentMethod = paymentMethod;
        this.openDate = LocalDate.now();
        this.id = id;
        this.status = 1;
        this.client = client;
    }
}
