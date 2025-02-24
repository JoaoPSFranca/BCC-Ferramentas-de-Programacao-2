package br.edu.ifsp.pep.bcc.estoque.model.repositories;

import br.edu.ifsp.pep.bcc.estoque.model.entities.Cliente;
import br.edu.ifsp.pep.bcc.estoque.model.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    public List<Produto> findByDescricaoLike(String descricao);
}
