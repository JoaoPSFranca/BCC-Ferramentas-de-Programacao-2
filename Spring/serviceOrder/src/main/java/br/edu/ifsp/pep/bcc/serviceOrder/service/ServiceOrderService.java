package br.edu.ifsp.pep.bcc.serviceOrder.service;

import br.edu.ifsp.pep.bcc.serviceOrder.repository.ClientRepository;
import br.edu.ifsp.pep.bcc.serviceOrder.repository.ServiceOrderRepository;
import org.springframework.stereotype.Service;

@Service
public class ServiceOrderService {

    private final ServiceOrderRepository serviceOrderRepository;

    public ServiceOrderService(ServiceOrderRepository serviceOrderRepository) {
        this.serviceOrderRepository = serviceOrderRepository;
    }

    
}
