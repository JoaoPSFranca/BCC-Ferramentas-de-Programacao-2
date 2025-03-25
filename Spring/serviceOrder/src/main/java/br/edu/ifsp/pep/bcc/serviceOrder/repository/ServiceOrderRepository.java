package br.edu.ifsp.pep.bcc.serviceOrder.repository;

import br.edu.ifsp.pep.bcc.serviceOrder.model.entities.ServiceOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ServiceOrderRepository extends JpaRepository<ServiceOrder, Integer> {
    List<ServiceOrder> getByOpenDate(LocalDate date);

    List<ServiceOrder> getByCloseDate(LocalDate date);

    List<ServiceOrder> getByClient(int client_id);
}
