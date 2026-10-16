package tn.esprit.autoloc.controller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.*;
import tn.esprit.autoloc.repository.*;

import java.util.List;
import java.util.function.Consumer;

@RestController
@RequestMapping("/api")
public class ApiController {

    private final AgenceRepository agenceRepository;
    private final ClientRepository clientRepository;
    private final ContratRepository contratRepository;
    private final EmployeRepository employeRepository;
    private final EquipementRepository equipementRepository;
    private final MaintenanceRepository maintenanceRepository;
    private final PaiementRepository paiementRepository;
    private final ReservationRepository reservationRepository;
    private final VehiculeRepository vehiculeRepository;

    public ApiController(AgenceRepository agenceRepository, ClientRepository clientRepository,
                        ContratRepository contratRepository, EmployeRepository employeRepository,
                        EquipementRepository equipementRepository, MaintenanceRepository maintenanceRepository,
                        PaiementRepository paiementRepository, ReservationRepository reservationRepository,
                        VehiculeRepository vehiculeRepository) {
        this.agenceRepository = agenceRepository;
        this.clientRepository = clientRepository;
        this.contratRepository = contratRepository;
        this.employeRepository = employeRepository;
        this.equipementRepository = equipementRepository;
        this.maintenanceRepository = maintenanceRepository;
        this.paiementRepository = paiementRepository;
        this.reservationRepository = reservationRepository;
        this.vehiculeRepository = vehiculeRepository;
    }

    @GetMapping("/agences")
    public List<Agence> getAgences(@RequestParam(required = false) String ville) {
        return ville == null ? agenceRepository.findAll() : agenceRepository.findByVille(ville);
    }

    @GetMapping("/agences/{id}")
    public ResponseEntity<Agence> getAgence(@PathVariable Long id) {
        return findById(agenceRepository, id);
    }

    @PostMapping("/agences")
    public ResponseEntity<Agence> createAgence(@RequestBody Agence agence) {
        return ResponseEntity.status(201).body(agenceRepository.save(agence));
    }

    @PutMapping("/agences/{id}")
    public ResponseEntity<Agence> updateAgence(@PathVariable Long id, @RequestBody Agence agence) {
        return update(agenceRepository, id, agence, value -> value.setIdAgence(id));
    }

    @DeleteMapping("/agences/{id}")
    public ResponseEntity<Void> deleteAgence(@PathVariable Long id) {
        return delete(agenceRepository, id);
    }

    @GetMapping("/clients")
    public List<Client> getClients(@RequestParam(required = false) String email,
                                   @RequestParam(required = false) String numPermis) {
        if (email != null) {
            return clientRepository.findByEmail(email).stream().toList();
        }
        if (numPermis != null) {
            return clientRepository.findByNumPermis(numPermis).stream().toList();
        }
        return clientRepository.findAll();
    }

    @GetMapping("/clients/{id}")
    public ResponseEntity<Client> getClient(@PathVariable Long id) {
        return findById(clientRepository, id);
    }

    @PostMapping("/clients")
    public ResponseEntity<Client> createClient(@RequestBody Client client) {
        return ResponseEntity.status(201).body(clientRepository.save(client));
    }

    @PutMapping("/clients/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client client) {
        return update(clientRepository, id, client, value -> value.setIdClient(id));
    }

    @DeleteMapping("/clients/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        return delete(clientRepository, id);
    }

    @GetMapping("/employes")
    public List<Employe> getEmployes(@RequestParam(required = false) Long agenceId,
                                     @RequestParam(required = false) RoleEmploye role) {
        return employeRepository.findAll().stream()
                .filter(employe -> agenceId == null || (employe.getAgence() != null
                        && agenceId.equals(employe.getAgence().getIdAgence())))
                .filter(employe -> role == null || role == employe.getRole())
                .toList();
    }

    @GetMapping("/employes/{id}")
    public ResponseEntity<Employe> getEmploye(@PathVariable Long id) {
        return findById(employeRepository, id);
    }

    @PostMapping("/employes")
    public ResponseEntity<Employe> createEmploye(@RequestBody Employe employe) {
        return ResponseEntity.status(201).body(employeRepository.save(employe));
    }

    @PutMapping("/employes/{id}")
    public ResponseEntity<Employe> updateEmploye(@PathVariable Long id, @RequestBody Employe employe) {
        return update(employeRepository, id, employe, value -> value.setIdEmploye(id));
    }

    @DeleteMapping("/employes/{id}")
    public ResponseEntity<Void> deleteEmploye(@PathVariable Long id) {
        return delete(employeRepository, id);
    }

    @GetMapping("/equipements")
    public List<Equipement> getEquipements(@RequestParam(required = false) String libelle) {
        return libelle == null ? equipementRepository.findAll()
                : equipementRepository.findByLibelle(libelle).stream().toList();
    }

    @GetMapping("/equipements/{id}")
    public ResponseEntity<Equipement> getEquipement(@PathVariable Long id) {
        return findById(equipementRepository, id);
    }

    @PostMapping("/equipements")
    public ResponseEntity<Equipement> createEquipement(@RequestBody Equipement equipement) {
        return ResponseEntity.status(201).body(equipementRepository.save(equipement));
    }

    @PutMapping("/equipements/{id}")
    public ResponseEntity<Equipement> updateEquipement(@PathVariable Long id, @RequestBody Equipement equipement) {
        return update(equipementRepository, id, equipement, value -> value.setIdEquipement(id));
    }

    @DeleteMapping("/equipements/{id}")
    public ResponseEntity<Void> deleteEquipement(@PathVariable Long id) {
        return delete(equipementRepository, id);
    }

    @GetMapping("/maintenances")
    public List<Maintenance> getMaintenances(@RequestParam(required = false) Long vehiculeId) {
        return vehiculeId == null ? maintenanceRepository.findAll()
                : maintenanceRepository.findByVehiculeIdVehicule(vehiculeId);
    }

    @GetMapping("/maintenances/{id}")
    public ResponseEntity<Maintenance> getMaintenance(@PathVariable Long id) {
        return findById(maintenanceRepository, id);
    }

    @PostMapping("/maintenances")
    public ResponseEntity<Maintenance> createMaintenance(@RequestBody Maintenance maintenance) {
        return ResponseEntity.status(201).body(maintenanceRepository.save(maintenance));
    }

    @PutMapping("/maintenances/{id}")
    public ResponseEntity<Maintenance> updateMaintenance(@PathVariable Long id,
                                                        @RequestBody Maintenance maintenance) {
        return update(maintenanceRepository, id, maintenance, value -> value.setIdMaintenance(id));
    }

    @DeleteMapping("/maintenances/{id}")
    public ResponseEntity<Void> deleteMaintenance(@PathVariable Long id) {
        return delete(maintenanceRepository, id);
    }

    @GetMapping("/paiements")
    public List<Paiement> getPaiements(@RequestParam(required = false) Long contratId) {
        return contratId == null ? paiementRepository.findAll()
                : paiementRepository.findByContratIdContrat(contratId);
    }

    @GetMapping("/paiements/{id}")
    public ResponseEntity<Paiement> getPaiement(@PathVariable Long id) {
        return findById(paiementRepository, id);
    }

    @PostMapping("/paiements")
    public ResponseEntity<Paiement> createPaiement(@RequestBody Paiement paiement) {
        return ResponseEntity.status(201).body(paiementRepository.save(paiement));
    }

    @PutMapping("/paiements/{id}")
    public ResponseEntity<Paiement> updatePaiement(@PathVariable Long id, @RequestBody Paiement paiement) {
        return update(paiementRepository, id, paiement, value -> value.setIdPaiement(id));
    }

    @DeleteMapping("/paiements/{id}")
    public ResponseEntity<Void> deletePaiement(@PathVariable Long id) {
        return delete(paiementRepository, id);
    }

    @GetMapping("/reservations")
    public List<Reservation> getReservations(@RequestParam(required = false) Long clientId,
                                             @RequestParam(required = false) StatutReservation statut) {
        return reservationRepository.findAll().stream()
                .filter(reservation -> clientId == null || (reservation.getClient() != null
                        && clientId.equals(reservation.getClient().getIdClient())))
                .filter(reservation -> statut == null || statut == reservation.getStatut())
                .toList();
    }

    @GetMapping("/reservations/{id}")
    public ResponseEntity<Reservation> getReservation(@PathVariable Long id) {
        return findById(reservationRepository, id);
    }

    @PostMapping("/reservations")
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation) {
        return ResponseEntity.status(201).body(reservationRepository.save(reservation));
    }

    @PutMapping("/reservations/{id}")
    public ResponseEntity<Reservation> updateReservation(@PathVariable Long id,
                                                        @RequestBody Reservation reservation) {
        return update(reservationRepository, id, reservation, value -> value.setIdReservation(id));
    }

    @DeleteMapping("/reservations/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable Long id) {
        return delete(reservationRepository, id);
    }

    @GetMapping("/contrats")
    public List<Contrat> getContrats(@RequestParam(required = false) Long reservationId) {
        return reservationId == null ? contratRepository.findAll()
                : contratRepository.findByReservationIdReservation(reservationId).stream().toList();
    }

    @GetMapping("/contrats/{id}")
    public ResponseEntity<Contrat> getContrat(@PathVariable Long id) {
        return findById(contratRepository, id);
    }

    @PostMapping("/contrats")
    public ResponseEntity<Contrat> createContrat(@RequestBody Contrat contrat) {
        return ResponseEntity.status(201).body(contratRepository.save(contrat));
    }

    @PutMapping("/contrats/{id}")
    public ResponseEntity<Contrat> updateContrat(@PathVariable Long id, @RequestBody Contrat contrat) {
        return update(contratRepository, id, contrat, value -> value.setIdContrat(id));
    }

    @DeleteMapping("/contrats/{id}")
    public ResponseEntity<Void> deleteContrat(@PathVariable Long id) {
        return delete(contratRepository, id);
    }

    @GetMapping("/vehicules")
    public List<Vehicule> getVehicules(@RequestParam(required = false) Long agenceId,
                                       @RequestParam(required = false) StatutVehicule statut,
                                       @RequestParam(required = false) CategorieVehicule categorie,
                                       @RequestParam(required = false) String immatriculation) {
        return vehiculeRepository.findAll().stream()
                .filter(vehicule -> agenceId == null || (vehicule.getAgence() != null
                        && agenceId.equals(vehicule.getAgence().getIdAgence())))
                .filter(vehicule -> statut == null || statut == vehicule.getStatut())
                .filter(vehicule -> categorie == null || categorie == vehicule.getCategorie())
                .filter(vehicule -> immatriculation == null
                        || immatriculation.equals(vehicule.getImmatriculation()))
                .toList();
    }

    @GetMapping("/vehicules/{id}")
    public ResponseEntity<Vehicule> getVehicule(@PathVariable Long id) {
        return findById(vehiculeRepository, id);
    }

    @PostMapping("/vehicules")
    public ResponseEntity<Vehicule> createVehicule(@RequestBody Vehicule vehicule) {
        return ResponseEntity.status(201).body(vehiculeRepository.save(vehicule));
    }

    @PutMapping("/vehicules/{id}")
    public ResponseEntity<Vehicule> updateVehicule(@PathVariable Long id, @RequestBody Vehicule vehicule) {
        return update(vehiculeRepository, id, vehicule, value -> value.setIdVehicule(id));
    }

    @DeleteMapping("/vehicules/{id}")
    public ResponseEntity<Void> deleteVehicule(@PathVariable Long id) {
        return delete(vehiculeRepository, id);
    }

    private static <T> ResponseEntity<T> findById(JpaRepository<T, Long> repository, Long id) {
        return repository.findById(id).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    private static <T> ResponseEntity<T> update(JpaRepository<T, Long> repository, Long id, T entity,
                                                 Consumer<T> setId) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        setId.accept(entity);
        return ResponseEntity.ok(repository.save(entity));
    }

    private static <T> ResponseEntity<Void> delete(JpaRepository<T, Long> repository, Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
