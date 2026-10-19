package tn.esprit.autoloc.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Reservation;
import tn.esprit.autoloc.service.IReservationService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/reservation")
@Tag(name ="gestion de reservations", description = "CRUD")

public class ReservationController {
    private final IReservationService reservationService;

    @Operation(summary = "ajouter un reservation")
    @PostMapping("/ajouterResevation")
    public Reservation ajouterReservation(@RequestBody Reservation reservation)
    {
        return reservationService.ajouterReservation(reservation);
    }

    @Operation(summary = "modifier un reservation")
    @PutMapping("/modifierReservation")
    public Reservation modifierReservation(@RequestBody Reservation reservation)
    {
        return reservationService.modifierReservation(reservation);
    }

    @Operation(summary = "supprimer un reservation")
    @DeleteMapping("/supprimerReservation/{idReservation}")
    public void supprimerReservation(@PathVariable Long idReservation)
    {
        reservationService.supprimerReservation(idReservation);
    }

    @Operation(summary = "afficher toutes les reservations")
    @GetMapping("/afficherToutesReservations")
    public List<Reservation> getAllReservation(){
        return reservationService.afficherToutesReservation();
    }

    @Operation(summary = "trouver un reservation par id")
    @GetMapping("/afficherReservationById/{id}")
    public Reservation getReservationById(@PathVariable Long id)
    {
        return reservationService.afficherReservationById(id);
    }

}
