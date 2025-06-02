package br.edu.ifsp.pep.bcc.Prova1_CVC.repository;

import br.edu.ifsp.pep.bcc.Prova1_CVC.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    List<Cliente> findByNomeLike(String Nome);
}
