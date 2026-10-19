package tn.esprit.autoloc.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Paiement;
import tn.esprit.autoloc.service.IPaiementService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/paiement")
@Tag(name ="gestion de paiements", description = "CRUD")

public class PaiementController {
    private final IPaiementService paiementService;

    @Operation(summary = "ajouter un paiement")
    @PostMapping("/ajouterPaiement")
    public Paiement ajouterPaiement(@RequestBody Paiement paiement)
    {
        return paiementService.ajouterPaiement(paiement);
    }

    @Operation(summary = "modifier un paiement")
    @PutMapping("/modifierPaiement")
    public Paiement modifierPaiement(@RequestBody Paiement paiement)
    {
        return paiementService.modifierPaiement(paiement);
    }

    @Operation(summary = "supprimer un paiement")
    @DeleteMapping("/supprimerPaiement/{idPaiement}")
    public void supprimerPaiement(@PathVariable Long idPaiement)
    {
        paiementService.supprimerPaiement(idPaiement);
    }

    @Operation(summary = "afficher toutes les paiements")
    @GetMapping("/afficherToutesPaiements")
    public List<Paiement> getAllPaiement(){
        return paiementService.afficherToutesPaiement();
    }

    @Operation(summary = "trouver un paiement par id")
    @GetMapping("/afficherPaiementById/{id}")
    public Paiement getPaiementById(@PathVariable Long id)
    {
        return paiementService.afficherPaiementById(id);
    }
}
