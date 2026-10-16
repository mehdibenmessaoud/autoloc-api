package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Equipement;

import java.util.List;
import java.util.Optional;

public interface EquipementService {

    Equipement saveEquipement(Equipement equipement);

    Equipement updateEquipement(Long id, Equipement equipement);

    List<Equipement> getAllEquipements();

    Optional<Equipement> getEquipementById(Long id);

    Optional<Equipement> getEquipementByLibelle(String libelle);

    void deleteEquipement(Long id);
}
