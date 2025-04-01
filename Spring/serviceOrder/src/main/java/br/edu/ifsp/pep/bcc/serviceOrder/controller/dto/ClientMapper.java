package br.edu.ifsp.pep.bcc.serviceOrder.controller.dto;

import br.edu.ifsp.pep.bcc.serviceOrder.model.entities.Client;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(
    componuntModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface ClientMapper {
    ClientMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    Client clientDTOToClient(ClientDTO clientDTO);

    ClientDTO clientToClientDTO(Client client);

    ClientResponseDTO clientToClientResponseDTO(Client client);
}
