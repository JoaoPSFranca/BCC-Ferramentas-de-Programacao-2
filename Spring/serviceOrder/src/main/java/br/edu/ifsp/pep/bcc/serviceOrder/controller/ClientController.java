package br.edu.ifsp.pep.bcc.serviceOrder.controller;

import br.edu.ifsp.pep.bcc.serviceOrder.model.Client;
import br.edu.ifsp.pep.bcc.serviceOrder.service.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("client")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Client>> index() {
        List<Client> clients = clientService.findAll();

        if (clients.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(clients);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Client> getClient(@PathVariable int id) {
        Client client = clientService.getById(id);

        if (client != null)
            return ResponseEntity.ok(client);
        else
            return ResponseEntity.notFound().build();
    }


}
