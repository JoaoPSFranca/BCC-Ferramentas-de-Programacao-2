package br.edu.ifsp.pep.bcc.serviceOrder.model;

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
