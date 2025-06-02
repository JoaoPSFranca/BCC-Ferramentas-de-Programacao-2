package br.edu.ifsp.pep.bcc.Prova1_CVC.mapper;

import br.edu.ifsp.pep.bcc.Prova1_CVC.dto.ClienteDTO;
import br.edu.ifsp.pep.bcc.Prova1_CVC.dto.ClienteResponseDTO;
import br.edu.ifsp.pep.bcc.Prova1_CVC.model.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ClienteMapper {
    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    Cliente clientDtoTOClient(ClienteDTO clientDTO);
    ClienteDTO clientToClientDTO(Cliente client);
    ClienteResponseDTO clientToClientResponseDTO(Cliente client);
    List<ClienteResponseDTO> clientListToClienteResponseDtoList(List<Cliente> clientes);
}
