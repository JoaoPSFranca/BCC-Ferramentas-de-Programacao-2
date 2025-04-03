package br.edu.ifsp.pep.bcc.serviceOrder.repository;

import br.edu.ifsp.pep.bcc.serviceOrder.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    Client findByEmail(String email);

    Client findByPhone(String phone);
}
