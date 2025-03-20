package br.edu.ifsp.pep.bcc.serviceOrder.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

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

    @PastOrPresent
    @Column(name="open_date")
    @NotBlank(message = "OpenDate can't be empty. ")
    private Date openDate;

    @PastOrPresent
    @Column(name="close_date")
    private Date closeDate;

    @Column(name="payment_method")
    @NotBlank(message = "Payment Method can't be empty. ")
    @Size(min=3, max=20, message = "Payment Method must contain between 3 and 20 characters. ")
    private String paymentMethod;

    @Column(name="status")
    private int status;

    public ServiceOrder(String paymentMethod, Date openDate, int id) {
        this.paymentMethod = paymentMethod;
        this.openDate = openDate;
        this.id = id;
        this.status = 1;
    }
}
