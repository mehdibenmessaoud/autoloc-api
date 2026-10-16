package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Contrat;

import java.util.List;
import java.util.Optional;

public interface ContratService {

    Contrat saveContrat(Contrat contrat);

    Contrat updateContrat(Long id, Contrat contrat);

    List<Contrat> getAllContrats();

    Optional<Contrat> getContratById(Long id);

    Optional<Contrat> getContratByReservation(Long idReservation);

    void deleteContrat(Long id);
}
