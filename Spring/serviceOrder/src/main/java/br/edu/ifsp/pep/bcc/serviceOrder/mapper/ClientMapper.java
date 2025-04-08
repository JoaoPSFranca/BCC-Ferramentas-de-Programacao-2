package br.edu.ifsp.pep.bcc.serviceOrder.mapper;

import br.edu.ifsp.pep.bcc.serviceOrder.dto.ClientDTO;
import br.edu.ifsp.pep.bcc.serviceOrder.dto.ClientResponseDTO;
import br.edu.ifsp.pep.bcc.serviceOrder.model.Client;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface ClientMapper {
    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    Client clientDTOToClient(ClientDTO clientDTO);
    ClientResponseDTO clientToClientResponseDTO(Client client);
    ClientDTO clientToClientDTO(Client client);

    List<ClientDTO> clientListToClientDTOList(List<Client> clientList);
}
