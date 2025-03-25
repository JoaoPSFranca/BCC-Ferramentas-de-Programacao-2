package br.edu.ifsp.pep.bcc.serviceOrder.model.entities;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

public class ServiceOrderItemID implements Serializable {
    private int serviceOrder;
    private int idItem;
}
