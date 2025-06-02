package br.edu.ifsp.pep.bcc.Prova1_CVC.service;

import br.edu.ifsp.pep.bcc.Prova1_CVC.exception.NoContent;
import br.edu.ifsp.pep.bcc.Prova1_CVC.exception.NotFoundException;
import br.edu.ifsp.pep.bcc.Prova1_CVC.model.Cliente;
import br.edu.ifsp.pep.bcc.Prova1_CVC.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.Objects.nonNull;

@Service
@RequiredArgsConstructor
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public Cliente create(Cliente client) {
        return clienteRepository.save(client);
    }

    public List<Cliente> getAll() throws NoContent {
        List<Cliente> listaClientes = clienteRepository.findAll();
        if (listaClientes.isEmpty()){
            throw new NoContent("Lista de clientes vazia.");
        }
        return listaClientes;
    }

    public Cliente getClientById(int codigo){
        Optional<Cliente> optionalClient = clienteRepository.findById(codigo);
        return optionalClient.orElse(null);
    }

    public List<Cliente> getClientByNome(String nome){
        List<Cliente> listaCliente = clienteRepository.findByNomeLike("%"+nome+"%");
        if (listaCliente.isEmpty()){
            return null;
        }
        return listaCliente;
    }

    public Cliente updateClient(int codigo, Cliente client) throws NotFoundException {
        Cliente optionalClient = clienteRepository.findById(client.getIdCliente()).
                orElseThrow(() -> new NotFoundException("Cliente não encontrado."));

        client.setIdCliente(codigo);
        return clienteRepository.save(client);
    }

    public Cliente delete(int id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if (cliente.isPresent()) {
            clienteRepository.delete(cliente.get());
            return cliente.get();
        }
        return null;
    }
}
