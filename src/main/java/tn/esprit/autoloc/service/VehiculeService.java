package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.CategorieVehicule;
import tn.esprit.autoloc.domain.StatutVehicule;
import tn.esprit.autoloc.domain.Vehicule;

import java.util.List;
import java.util.Optional;

public interface VehiculeService {

    Vehicule saveVehicule(Vehicule vehicule);

    Vehicule updateVehicule(Long id, Vehicule vehicule);

    List<Vehicule> getAllVehicules();

    Optional<Vehicule> getVehiculeById(Long id);

    Optional<Vehicule> getVehiculeByImmatriculation(String immatriculation);

    List<Vehicule> getVehiculesByAgence(Long idAgence);

    List<Vehicule> getVehiculesByStatut(StatutVehicule statut);

    List<Vehicule> getVehiculesByCategorie(CategorieVehicule categorie);

    void deleteVehicule(Long id);
}
