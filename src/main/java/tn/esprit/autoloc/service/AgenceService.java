package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Agence;

import java.util.List;
import java.util.Optional;

public interface AgenceService {

    Agence saveAgence(Agence agence);

    Agence updateAgence(Long id, Agence agence);

    List<Agence> getAllAgences();

    Optional<Agence> getAgenceById(Long id);

    List<Agence> getAgencesByVille(String ville);

    void deleteAgence(Long id);
}