package br.edu.ifsp.pep.bcc.estoque.controller;

import br.edu.ifsp.pep.bcc.estoque.model.entities.Cliente;
import br.edu.ifsp.pep.bcc.estoque.model.entities.Produto;
import br.edu.ifsp.pep.bcc.estoque.model.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("produto")
public class ProdutoController {
    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping(value="/", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Produto> getAll() {
        return produtoRepository.findAll();
    }

    @GetMapping(value="/{codigo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Produto> getClient(@PathVariable int codigo) {
        return produtoRepository.findById(codigo);
    }

    @GetMapping(value="", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Produto> getByName(@RequestParam(value = "descricao", defaultValue = "") String descricao) {
        return produtoRepository.findByDescricaoLike("%" + descricao + "%");
    }
}
