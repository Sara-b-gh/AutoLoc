package tn.esprit.autoloc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Reservation;
import tn.esprit.autoloc.repository.ReservationRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class IReservationServiceImp implements IReservationService {

    private final ReservationRepository reservationRepository;
    @Override
    public Reservation ajouterReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation modifierReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public List<Reservation> afficherToutesReservation() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation afficherReservationById(Long id) {
        return reservationRepository.findById(id).orElse(null);
    }

    @Override
    public void supprimerReservation(Long id) {
        reservationRepository.deleteById(id);

    }

    @Override
    public List<Reservation> retournerReservationsParDateDebutApres(LocalDate date) {
        return reservationRepository.findByDateDebutAfter(date);

    }

    @Override
    public List<Reservation> retournerReservationsParDateFinAvant(LocalDate date) {
        return reservationRepository.findByDateFinBefore(date);

    }
}
