package br.edu.ifsp.pep.bcc.estoque.controller;

import br.edu.ifsp.pep.bcc.estoque.model.entities.Cliente;
import br.edu.ifsp.pep.bcc.estoque.model.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("cliente")
public class ClienteController {
    @Autowired
    ClienteRepository clienteRepository;

    @GetMapping(value="/", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Cliente> getAll() {
        return clienteRepository.findAll();
    }

    @GetMapping(value="/{codigo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Cliente> getClient(@PathVariable int codigo) {
        return clienteRepository.findById(codigo);
    }

    @GetMapping(value="", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Cliente> getByName(@RequestParam(value = "nome", defaultValue = "") String nome) {
        return clienteRepository.findByNomeLike("%" + nome + "%");
    }
}
