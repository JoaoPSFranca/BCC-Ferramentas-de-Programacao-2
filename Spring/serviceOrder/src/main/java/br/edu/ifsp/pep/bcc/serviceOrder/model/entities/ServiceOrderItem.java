package br.edu.ifsp.pep.bcc.serviceOrder.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
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
    @EmbeddedId
    @EqualsAndHashCode.Include
    private ServiceOrderItemID id;

    @Column(name="service")
    @EqualsAndHashCode.Include
    @NotBlank(message = "Service number can't be empty. ")
    private int service;

    @Positive
    @Column(name="price")
    @NotBlank(message = "Price can't be empty. ")
    private int price;
}
