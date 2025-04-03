package br.edu.ifsp.pep.bcc.serviceOrder.service;

import br.edu.ifsp.pep.bcc.serviceOrder.model.Client;
import br.edu.ifsp.pep.bcc.serviceOrder.repository.ClientRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.Objects.nonNull;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client save(Client client) throws ServiceException {
        try {
            if(nonNull(clientRepository.findByEmail(client.getEmail())))
                throw new ServiceException("Email já cadastrado. ");
            if(nonNull(clientRepository.findByPhone(client.getPhone())))
                throw new ServiceException("Telefone já cadastrado. ");

            return clientRepository.save(client);
        } catch (Exception e){
            throw new ServiceException("Erro ao salvar cliente", e);
        }
    }

    public Client update(Client client) throws ServiceException {
        Optional<Client> optional = clientRepository.findById(client.getId());

        if(optional.isPresent())
            return clientRepository.save(client);

        return null;
    }

    public Client delete(int id) throws ServiceException {
        Optional<Client> client = clientRepository.findById(id);
        if(client.isPresent()) {
            Client c = client.get();
            clientRepository.delete(c);
            return c;
        }
        return null;
    }

    public boolean updateStatus(int id, int status) throws ServiceException {
        Optional<Client> client = clientRepository.findById(id);

        if(client.isPresent()) {
            Client c = client.get();
            c.setActive(status);
            clientRepository.save(c);
            return true;
        }

        return false;
    }

    public List<Client> findAll() {
        List<Client> clients = clientRepository.findAll();
        if (clients.isEmpty())
            return null;
        return clients;
    }

    public Client getById(int id) throws ServiceException {
        Optional<Client> client = clientRepository.findById(id);
        return client.orElse(null);
    }

}