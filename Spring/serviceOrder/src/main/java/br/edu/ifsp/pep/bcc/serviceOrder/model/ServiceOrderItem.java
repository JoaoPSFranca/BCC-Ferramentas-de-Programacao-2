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

    @Enumerated(EnumType.STRING)
    @Column(name="service", nullable = false)
    @ElementCollection(targetClass = TypeServices.class, fetch = FetchType.EAGER)
    @JoinTable(
            name="service_order_item_type_service",
            joinColumns = {
                    @JoinColumn(name="so_id"),
                    @JoinColumn(name="item_id")
            }
    )
    private TypeServices service;

    @Positive
    @Column(name="price")
    @NotBlank(message = "Price can't be empty. ")
    private int price;
}
