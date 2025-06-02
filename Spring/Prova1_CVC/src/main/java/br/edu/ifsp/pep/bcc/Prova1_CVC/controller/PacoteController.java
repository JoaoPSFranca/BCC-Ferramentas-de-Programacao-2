package br.edu.ifsp.pep.bcc.Prova1_CVC.controller;

import br.edu.ifsp.pep.bcc.Prova1_CVC.dto.ClienteDTO;
import br.edu.ifsp.pep.bcc.Prova1_CVC.dto.ClienteResponseDTO;
import br.edu.ifsp.pep.bcc.Prova1_CVC.dto.PacoteDTO;
import br.edu.ifsp.pep.bcc.Prova1_CVC.dto.PacoteResponseDTO;
import br.edu.ifsp.pep.bcc.Prova1_CVC.mapper.PacoteMapper;
import br.edu.ifsp.pep.bcc.Prova1_CVC.model.Cliente;
import br.edu.ifsp.pep.bcc.Prova1_CVC.model.Pacote;
import br.edu.ifsp.pep.bcc.Prova1_CVC.model.StatusPacote;
import br.edu.ifsp.pep.bcc.Prova1_CVC.service.ClienteService;
import br.edu.ifsp.pep.bcc.Prova1_CVC.service.PacoteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.expression.spel.ast.NullLiteral;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("pacote")
@Slf4j
@RequiredArgsConstructor
@Tag(name = "Pacote Controller", description = "gerenciamento do pacote")
public class PacoteController {
    private final PacoteService pacoteService;
    private final PacoteMapper pacoteMapper;
    private final ClienteService clienteService;

    @Operation(summary = "Listar todos os Pacotes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de pacotes retornada com sucesso"),
            @ApiResponse(responseCode = "204", description = "Nenhum pacote encontrado")
    })
    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PacoteResponseDTO>> getAll(){
        List<Pacote> listaPacote = pacoteService.getAll();
        if (listaPacote == null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(pacoteMapper.pacoteListToPacoteResponseDtoList(listaPacote));
    }

    @Operation(summary = "Criar um novo pacote")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Pacote criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos para criação do pacote")
    })
    @PostMapping(value = "",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PacoteResponseDTO> createPacote(@Valid @RequestBody PacoteDTO dto) throws Exception {
        log.debug("Criando um novo pacote...");
        Pacote pacote = pacoteService.create(pacoteMapper.pacoteDtoTOPacote(dto));
        log.info("Cliente criado com sucesso!");
        return ResponseEntity.status(HttpStatus.CREATED).body(pacoteMapper.pacoteToPacoteResponseDTO(pacote));
    }

    @Operation(summary = "Buscar pacote por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pacote encontrado"),
            @ApiResponse(responseCode = "404", description = "Pacote não encontrado")
    })
    @GetMapping(value = "/{codigo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PacoteResponseDTO> getPacote(@PathVariable int codigo){
        Pacote pacote = pacoteService.getPacoteById(codigo);
        if (pacote != null){
            return ResponseEntity.ok(pacoteMapper.pacoteToPacoteResponseDTO(pacote));
        }
        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Buscar pacotes por cliente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pacotes encontrados"),
            @ApiResponse(responseCode = "404", description = "Nenhum pacote encontrado com o cliente fornecido")
    })
    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PacoteResponseDTO>> getByCliente(@RequestParam(value = "cliente", defaultValue = "") int codigo){
        Cliente cliente = clienteService.getClientById(codigo);
        if (cliente != null){
            List<Pacote> pacotes = pacoteService.getPacoteByCliente(cliente);
            if (!pacotes.isEmpty())
                return ResponseEntity.ok(pacoteMapper.pacoteListToPacoteResponseDtoList(pacotes));
        }

        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Atualizar um pacote")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pacote atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Pacote não encontrado para atualização")
    })
    @PutMapping(value = "/{codigo}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PacoteResponseDTO> updatePacote(@PathVariable int codigo, @RequestBody PacoteDTO dto) {
        Pacote pacoteAlterado = pacoteService.updatePacote(codigo, pacoteMapper.pacoteDtoTOPacote(dto));
        return ResponseEntity.ok(pacoteMapper.pacoteToPacoteResponseDTO(pacoteAlterado));
    }

    @Operation(summary = "Excluir um pacote")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pacote excluído com sucesso"),
            @ApiResponse(responseCode = "404", description = "Pacote não encontrado para exclusão")
    })
    @DeleteMapping(value = "/{codigo}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PacoteResponseDTO> deletePacote(@PathVariable int codigo){
        Pacote pacote = pacoteService.delete(codigo);
        if (pacote != null){
            return ResponseEntity.ok(pacoteMapper.pacoteToPacoteResponseDTO(pacote));
        }
        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Alterar Status do Pacote")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pacote alterado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Erro na alteração")
    })
    @PatchMapping(value = "/{codigo/{status}}")
    public ResponseEntity<PacoteResponseDTO> alterarStatus(@PathVariable int codigo, @PathVariable String status) {
        Pacote pacote = pacoteService.getPacoteById(codigo);
        if (pacote != null){
            switch (status.toLowerCase()){
                case "pago":
                    pacote.setStatus(StatusPacote.PAGO);
                    break;
                case "aberto":
                    pacote.setStatus(StatusPacote.ABERTO);
                    break;
                case "cancelado":
                    pacote.setStatus(StatusPacote.CANCELADO);
                    break;
                default:
                    return ResponseEntity.noContent().build();
            }

            Pacote pacoteAlterado = pacoteService.updatePacote(codigo, pacote);
            return ResponseEntity.ok(pacoteMapper.pacoteToPacoteResponseDTO(pacote));
        }

        return ResponseEntity.notFound().build();
    }

}
