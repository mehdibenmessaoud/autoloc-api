package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Maintenance;

import java.util.List;
import java.util.Optional;

public interface MaintenanceService {

    Maintenance saveMaintenance(Maintenance maintenance);

    Maintenance updateMaintenance(Long id, Maintenance maintenance);

    List<Maintenance> getAllMaintenances();

    Optional<Maintenance> getMaintenanceById(Long id);

    List<Maintenance> getMaintenancesByVehicule(Long idVehicule);

    void deleteMaintenance(Long id);
}
