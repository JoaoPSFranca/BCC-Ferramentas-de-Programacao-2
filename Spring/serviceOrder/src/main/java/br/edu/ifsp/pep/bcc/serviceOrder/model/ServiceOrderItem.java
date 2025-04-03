package br.edu.ifsp.pep.bcc.serviceOrder.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@IdClass(ServiceOrderItemID.class)
@Table(name="service_order_item")
public class ServiceOrderItem {
    @Id
    @ManyToOne
    @EqualsAndHashCode.Include
    @JoinColumn(name = "so_id", referencedColumnName = "id")
    private ServiceOrder serviceOrder;

    @Id
    @Column(name = "item_id")
    @EqualsAndHashCode.Include
    private Integer idItem;

    @Column(name="service")
    @EqualsAndHashCode.Include
    @NotBlank(message = "Service number can't be empty. ")
    private int service;

    @Positive
    @Column(name="price")
    @NotBlank(message = "Price can't be empty. ")
    private int price;
}
