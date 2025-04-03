package br.edu.ifsp.pep.bcc.serviceOrder.repository;

import br.edu.ifsp.pep.bcc.serviceOrder.model.ServiceOrder;
import br.edu.ifsp.pep.bcc.serviceOrder.model.ServiceOrderItem;
import br.edu.ifsp.pep.bcc.serviceOrder.model.ServiceOrderItemID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceOrderItemRepository extends JpaRepository<ServiceOrderItem, ServiceOrderItemID> {
    List<ServiceOrderItem> findByServiceOrder(ServiceOrder serviceOrder);
}
