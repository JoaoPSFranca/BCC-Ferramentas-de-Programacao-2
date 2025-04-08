package br.edu.ifsp.pep.bcc.serviceOrder.service;

import br.edu.ifsp.pep.bcc.serviceOrder.repository.ServiceOrderItemRepository;
import org.springframework.stereotype.Service;

@Service
public class ServiceOrderItemService {
    private final ServiceOrderItemRepository serviceOrderItemRepository;

    public ServiceOrderItemService(ServiceOrderItemRepository serviceOrderItemRepository) {
        this.serviceOrderItemRepository = serviceOrderItemRepository;
    }


}
