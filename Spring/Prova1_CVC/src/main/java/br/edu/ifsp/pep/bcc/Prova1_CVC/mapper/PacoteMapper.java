package br.edu.ifsp.pep.bcc.Prova1_CVC.mapper;

import br.edu.ifsp.pep.bcc.Prova1_CVC.dto.PacoteDTO;
import br.edu.ifsp.pep.bcc.Prova1_CVC.dto.PacoteResponseDTO;
import br.edu.ifsp.pep.bcc.Prova1_CVC.model.Pacote;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PacoteMapper {
    PacoteMapper INSTANCE = Mappers.getMapper(PacoteMapper.class);

    Pacote pacoteDtoTOPacote(PacoteDTO pacoteDTO);
    PacoteDTO pacoteToPacoteDTO(Pacote pacote);
    PacoteResponseDTO pacoteToPacoteResponseDTO(Pacote pacote);
    List<PacoteResponseDTO> pacoteListToPacoteResponseDtoList(List<Pacote> pacotes);
}
