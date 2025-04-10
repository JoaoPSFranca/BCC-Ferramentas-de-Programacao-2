package br.edu.ifsp.pep.bcc.serviceOrder.mapper;

import br.edu.ifsp.pep.bcc.serviceOrder.dto.ServiceOrderDTO;
import br.edu.ifsp.pep.bcc.serviceOrder.model.ServiceOrder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ServiceOrderMapper {
    ServiceOrderMapper INSTANCE = Mappers.getMapper(ServiceOrderMapper.class);

    ServiceOrder serviceOrderDTOToServiceOrder(ServiceOrderDTO serviceOrderDTO);
    ServiceOrderDTO serviceOrderToServiceOrderDTO(ServiceOrder serviceOrder);

    List<ServiceOrderDTO> serviceOrderListTOServiceOrderDTOList(List<ServiceOrder> serviceOrderList);
}
