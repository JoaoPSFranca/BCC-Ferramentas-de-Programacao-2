package br.edu.ifsp.pep.bcc.estoque.model.repositories;

import br.edu.ifsp.pep.bcc.estoque.model.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    public List<Cliente> findByNomeLike(String nome);
}
