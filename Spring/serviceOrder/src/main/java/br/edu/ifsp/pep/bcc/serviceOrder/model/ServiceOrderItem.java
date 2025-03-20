package br.edu.ifsp.pep.bcc.serviceOrder.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="service_order_item")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ServiceOrderItem {
    @Id
    @Column(name="id_item")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int IdItem;

    @Column(name="service")
    @EqualsAndHashCode.Include
    @NotBlank(message = "Service number can't be empty. ")
    private int service;

    @Column(name="price")
    @NotBlank(message = "Price can't be empty. ")
    private int price;
}
