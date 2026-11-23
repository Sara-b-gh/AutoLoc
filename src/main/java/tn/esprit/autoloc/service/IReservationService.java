package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Reservation;

import java.time.LocalDate;
import java.util.List;

public interface IReservationService {
    Reservation ajouterReservation(Reservation reservation);
    Reservation modifierReservation(Reservation reservation);
    List<Reservation> afficherToutesReservation();
    Reservation afficherReservationById(Long id);
    void supprimerReservation(Long id);
    List<Reservation> retournerReservationsParDateDebutApres(LocalDate date);
    List<Reservation> retournerReservationsParDateFinAvant(LocalDate date);

}
