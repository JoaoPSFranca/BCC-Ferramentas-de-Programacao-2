package br.edu.ifsp.pep.bcc.estoque.controller;

import br.edu.ifsp.pep.bcc.estoque.model.entities.Cliente;
import br.edu.ifsp.pep.bcc.estoque.model.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("cliente")
public class ClienteController {
    @Autowired
    ClienteRepository clienteRepository;

    @GetMapping(value="/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Cliente>> getAll() {
        List<Cliente> listaClientes = clienteRepository.findAll();
        if (listaClientes.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else
            return ResponseEntity.ok(listaClientes);
    }

    @GetMapping(value="/{codigo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cliente> getClient(@PathVariable int codigo) {
        Optional<Cliente> cliente = clienteRepository.findById(codigo);
        if (cliente.isPresent())
            return ResponseEntity.ok(cliente.get());
        else
            return ResponseEntity.notFound().build();
            // return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value="", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Cliente>> getByName(@RequestParam(value = "nome", defaultValue = "") String nome) {
        List<Cliente> clientes = clienteRepository.findByNomeLike("%" + nome + "%");

        if (clientes.isEmpty())
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(clientes);
    }

    @PostMapping(value = "",
                 consumes = MediaType.APPLICATION_JSON_VALUE,
                 produces = MediaType.APPLICATION_JSON_VALUE)
    public Cliente createCliente(@RequestBody Cliente cliente){
        clienteRepository.save(cliente);
        return cliente;
    }

    @DeleteMapping(value = "/{codigo}")
    public ResponseEntity<Cliente> deleteCliente(@PathVariable int codigo){
        Optional<Cliente> cliente = clienteRepository.findById(codigo);

        if (cliente.isPresent()){
            clienteRepository.deleteById(codigo);
            return ResponseEntity.ok(cliente.get());
        }
        else
            return ResponseEntity.notFound().build();
    }
    @PutMapping(value = "/{codigo}",
                consumes = MediaType.APPLICATION_JSON_VALUE,
                produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cliente> updateCliente(@PathVariable int codigo,
                                 @RequestBody Cliente cliente) {
        if (clienteRepository.existsById(cliente.getCodigo())){
            cliente.setCodigo(codigo);
            clienteRepository.save(cliente);
            return ResponseEntity.ok(cliente);
        } else
            return ResponseEntity.notFound().build();
    }

    @PatchMapping(value = "/{codigo}/ativar")
    public ResponseEntity<String> ativarCliente(@PathVariable int codigo){
        Optional<Cliente> optionalCliente = clienteRepository.findById(codigo);

        if (optionalCliente.isPresent()){
            Cliente cliente = optionalCliente.get();
            cliente.setAtivo(1);
            clienteRepository.save(cliente);
            return ResponseEntity.ok(null);
        } else
            return ResponseEntity.notFound().build();
    }

    @PatchMapping(value = "/{codigo}/desativar")
    public ResponseEntity<String> desativarCliente(@PathVariable int codigo){
        Optional<Cliente> optionalCliente = clienteRepository.findById(codigo);

        if (optionalCliente.isPresent()) {
            Cliente cliente = optionalCliente.get();
            cliente.setAtivo(0);
            clienteRepository.save(cliente);
            return ResponseEntity.ok(null);
        } else
            return ResponseEntity.notFound().build();
    }
}
