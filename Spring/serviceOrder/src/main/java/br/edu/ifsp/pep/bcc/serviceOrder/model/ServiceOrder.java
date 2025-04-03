package br.edu.ifsp.pep.bcc.serviceOrder.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@Table(name="service_order")
public class ServiceOrder implements Serializable {

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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "serviceOrder", orphanRemoval = true)
    List<ServiceOrderItem> services = new ArrayList<>();

    public ServiceOrder(String paymentMethod, int id, Client client) {
        this.paymentMethod = paymentMethod;
        this.openDate = LocalDate.now();
        this.id = id;
        this.status = 1;
        this.client = client;
    }
}

