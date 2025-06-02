package br.edu.ifsp.pep.bcc.Prova1_CVC.repository;

import br.edu.ifsp.pep.bcc.Prova1_CVC.model.Viajantes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViajanteRepository extends JpaRepository<Viajantes, String> { }
