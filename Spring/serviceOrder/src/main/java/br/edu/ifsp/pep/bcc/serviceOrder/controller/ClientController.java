package br.edu.ifsp.pep.bcc.serviceOrder.controller;

import br.edu.ifsp.pep.bcc.serviceOrder.dto.ClientDTO;
import br.edu.ifsp.pep.bcc.serviceOrder.mapper.ClientMapper;
import br.edu.ifsp.pep.bcc.serviceOrder.model.Client;
import br.edu.ifsp.pep.bcc.serviceOrder.service.ClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("client")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;
    private final ClientMapper mapper;

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ClientDTO>> index() {
        List<Client> clients = clientService.findAll();

        if (clients.isEmpty())
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.ok(
                    mapper.clientListToClientDTOList(clients)
            );
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<ClientDTO>> getAll() {
        List<Client> clients = clientService.findAll();

        if (clients.isEmpty())
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.ok(
                    mapper.clientListToClientDTOList(clients)
            );
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClientDTO> getClient(@PathVariable int id) {
        Client client = clientService.getById(id);

        if (client != null)
            return ResponseEntity.ok(
                    mapper.clientToClientDTO(client)
            );
        else
            return ResponseEntity.notFound().build();
    }

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClientDTO> create(@RequestBody @Valid ClientDTO clientDTO) {
        Client client = clientService.save(mapper.clientDTOToClient(clientDTO));

        URI enderecoUri = UriComponentsBuilder.fromPath("/cliente/{id}").buildAndExpand(client.getId()).toUri();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("location", enderecoUri.toString());

        return new ResponseEntity<>(mapper.clientToClientDTO(client),
                httpHeaders,
                HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClientDTO> delete(@PathVariable int id) {
        clientService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClientDTO> update(@PathVariable int id, @RequestBody @Valid ClientDTO clientDTO) {
        Client client = mapper.clientDTOToClient(clientDTO);

        Client alterClient = clientService.update(client, id);
        return new ResponseEntity<>(mapper.clientToClientDTO(alterClient), HttpStatus.OK);
    }

    @PatchMapping(value = "/{id}/enable")
    public ResponseEntity<String> enableClient(@PathVariable int id) {
        clientService.updateStatus(id, 1);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping(value = "/{id}/disable")
    public ResponseEntity<String> disableClient(@PathVariable int id) {
        clientService.updateStatus(id, 0);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}