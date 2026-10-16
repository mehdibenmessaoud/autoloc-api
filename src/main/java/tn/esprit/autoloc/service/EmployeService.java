package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.domain.RoleEmploye;

import java.util.List;
import java.util.Optional;

public interface EmployeService {

    Employe saveEmploye(Employe employe);

    Employe updateEmploye(Long id, Employe employe);

    List<Employe> getAllEmployes();

    Optional<Employe> getEmployeById(Long id);

    List<Employe> getEmployesByAgence(Long idAgence);

    List<Employe> getEmployesByRole(RoleEmploye role);

    void deleteEmploye(Long id);
}
