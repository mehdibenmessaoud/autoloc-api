package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Paiement;

import java.util.List;
import java.util.Optional;

public interface PaiementService {

    Paiement savePaiement(Paiement paiement);

    Paiement updatePaiement(Long id, Paiement paiement);

    List<Paiement> getAllPaiements();

    Optional<Paiement> getPaiementById(Long id);

    List<Paiement> getPaiementsByContrat(Long idContrat);

    void deletePaiement(Long id);
}
