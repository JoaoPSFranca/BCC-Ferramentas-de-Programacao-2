package br.edu.ifsp.pep.bcc.estoque.service;

import br.edu.ifsp.pep.bcc.estoque.model.entities.Cliente;
import br.edu.ifsp.pep.bcc.estoque.model.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    ClienteRepository clienteRepository;

    public Cliente salvar(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public boolean alterarStatus(int codigo, int status){
        Optional<Cliente> optionalCliente = clienteRepository.findById(codigo);
        if (optionalCliente.isPresent()){ //cliente encontrado
            Cliente c = optionalCliente.get(); // extraindo a entity do Optional
            c.setAtivo(status);
            clienteRepository.save(c);
            return true;
        }
        return false;
    }

    public Cliente delete(int codigo) {
        Optional<Cliente> cliente = clienteRepository.findById(codigo);
        if (cliente.isPresent()) {
            clienteRepository.delete(cliente.get());
            return cliente.get();
        }
        return null;
    }

    public List<Cliente> getAll(){
        List<Cliente> listaClientes = clienteRepository.findAll();
        if (listaClientes.isEmpty()){
            return null;
        }
        return listaClientes;
    }

    public Cliente getClienteById(int codigo){
        Optional<Cliente> optionalCliente = clienteRepository.findById(codigo);
        if (optionalCliente.isPresent()){
            return optionalCliente.get();
        }
        return null;
    }

    public List<Cliente> getClienteByNome(String nome){
        List<Cliente> listaCliente = clienteRepository.findByNomeLike("%"+nome+"%");
        if (listaCliente.isEmpty()){
            return null;
        }
        return listaCliente;
    }

    public Cliente updateCliente(int codigo, Cliente client){
        Optional<Cliente> optionalCliente = clienteRepository.findById(client.getCodigo());

        if (optionalCliente.isPresent()){
            client.setCodigo(codigo);
            Cliente clienteAlter = clienteRepository.save(client);
            return clienteAlter;
        }

        return null;
    }
}
