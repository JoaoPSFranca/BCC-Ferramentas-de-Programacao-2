package br.edu.ifsp.pep.bcc.Prova1_CVC.service;

import br.edu.ifsp.pep.bcc.Prova1_CVC.exception.NoContent;
import br.edu.ifsp.pep.bcc.Prova1_CVC.exception.NotFoundException;
import br.edu.ifsp.pep.bcc.Prova1_CVC.model.Cliente;
import br.edu.ifsp.pep.bcc.Prova1_CVC.model.Pacote;
import br.edu.ifsp.pep.bcc.Prova1_CVC.model.StatusPacote;
import br.edu.ifsp.pep.bcc.Prova1_CVC.model.Viajantes;
import br.edu.ifsp.pep.bcc.Prova1_CVC.repository.PacoteRepository;
import br.edu.ifsp.pep.bcc.Prova1_CVC.repository.ViajanteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PacoteService {
    private final PacoteRepository pacoteRepository;
    private final ViajanteRepository viajanteRepository;

    public Pacote create(Pacote pacote) {
        return pacoteRepository.save(pacote);
    }

    public List<Pacote> getAll() throws NoContent {
        List<Pacote> listaPacotes = pacoteRepository.findAll();
        if (listaPacotes.isEmpty()){
            throw new NoContent("Lista de clientes vazia.");
        }
        return listaPacotes;
    }

    public Pacote getPacoteById(int codigo){
        Optional<Pacote> optionalPacote = pacoteRepository.findById(codigo);
        return optionalPacote.orElse(null);
    }

    public List<Pacote> getPacoteByCliente(Cliente cliente){
        List<Pacote> listaPacotes = pacoteRepository.findByCliente(cliente);
        if (listaPacotes.isEmpty()){
            return null;
        }
        return listaPacotes;
    }

    public Pacote updatePacote(int codigo, Pacote pacote) throws NotFoundException {
        Pacote optionalPacote = pacoteRepository.findById(pacote.getIdPacote()).
                orElseThrow(() -> new NotFoundException("Cliente não encontrado."));

        pacote.setIdPacote(codigo);
        return pacoteRepository.save(pacote);
    }

    public Pacote delete(int id) {
        Optional<Pacote> pacote = pacoteRepository.findById(id);
        if (pacote.isPresent()) {
            pacoteRepository.delete(pacote.get());
            return pacote.get();
        }
        return null;
    }

    public boolean alterarStatus(int codigo, StatusPacote status){
        Optional<Pacote> optionalPacote = pacoteRepository.findById(codigo);
        if (optionalPacote.isPresent()){
            Pacote p = optionalPacote.get();
            p.setStatus(status);
            pacoteRepository.save(p);
            return true;
        }
        return false;
    }

//    public Pacote createViajante(Pacote pacote, Viajantes viajante){
//        Viajantes viajanteNovo = viajanteRepository.save(viajante);
//        pacote.getViajantes().add(viajanteNovo);
//        return
//    }
}
