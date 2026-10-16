package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Reservation;
import tn.esprit.autoloc.domain.StatutReservation;

import java.util.List;
import java.util.Optional;

public interface ReservationService {

    Reservation saveReservation(Reservation reservation);

    Reservation updateReservation(Long id, Reservation reservation);

    List<Reservation> getAllReservations();

    Optional<Reservation> getReservationById(Long id);

    List<Reservation> getReservationsByClient(Long idClient);

    List<Reservation> getReservationsByStatut(StatutReservation statut);

    void deleteReservation(Long id);
}
