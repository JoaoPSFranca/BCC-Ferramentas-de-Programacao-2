package br.edu.ifsp.pep.bcc.serviceOrder.service;

import br.edu.ifsp.pep.bcc.serviceOrder.model.ServiceOrder;
import br.edu.ifsp.pep.bcc.serviceOrder.model.ServiceOrderItem;
import br.edu.ifsp.pep.bcc.serviceOrder.repository.ServiceOrderItemRepository;
import br.edu.ifsp.pep.bcc.serviceOrder.repository.ServiceOrderRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.Objects.nonNull;

@Service
public class ServiceOrderService {

    private final ServiceOrderRepository serviceOrderRepository;

    public ServiceOrderService(ServiceOrderRepository serviceOrderRepository) {
        this.serviceOrderRepository = serviceOrderRepository;
    }

    public ServiceOrder save(ServiceOrder serviceOrder) {
        return serviceOrderRepository.save(serviceOrder);
    }

    public ServiceOrder update(ServiceOrder serviceOrder, int id) throws ServiceException {
        Optional<ServiceOrder> optional = serviceOrderRepository.findById(id);

        if (optional.isPresent()) {
            serviceOrder.setId(id);
            return serviceOrderRepository.save(serviceOrder);
        }

        return null;
    }

    public ServiceOrder delete(int id) throws ServiceException {
        Optional<ServiceOrder> optional = serviceOrderRepository.findById(id);

        if (optional.isPresent()) {
            serviceOrderRepository.delete(optional.get());
            return optional.get();
        }

        return null;
    }

    public ServiceOrder addItem(ServiceOrder serviceOrder, ServiceOrderItem serviceOrderItem) {
        Optional<ServiceOrder> optional = serviceOrderRepository.findById(serviceOrder.getId());
        if (optional.isPresent()) {
            serviceOrder.setId(serviceOrder.getId());
            List<ServiceOrderItem> services = serviceOrder.getServices();
            services.add(serviceOrderItem);
            serviceOrder.setServices(services);
        }

        return serviceOrderRepository.save(serviceOrder);
    }
    
    public List<ServiceOrder> findByClientId(int id) {
        return serviceOrderRepository.getByClient(id);
    }

    public List<ServiceOrder> findAll() {
        return serviceOrderRepository.findAll();
    }

    public ServiceOrder findById(Integer id) {
        return serviceOrderRepository.findById(id).orElse(null);
    }
}
