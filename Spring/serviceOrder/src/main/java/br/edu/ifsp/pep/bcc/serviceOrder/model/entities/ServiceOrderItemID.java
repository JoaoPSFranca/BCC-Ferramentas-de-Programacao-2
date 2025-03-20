package br.edu.ifsp.pep.bcc.serviceOrder.model.entities;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class ServiceOrderItemID {

    private ServiceOrder serviceOrder;

    private ServiceOrderItem serviceOrderItem;
}
