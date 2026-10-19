package tn.esprit.autoloc.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.service.IAgenceService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/agences")
@Tag(name ="gestion de agences", description = "CRUD")

public class AgenceController {
    private final IAgenceService agenceService;

    @Operation(summary = "afficher toutes les agences")
    @GetMapping("/afficherToutesAgences")
    public List<Agence> getAllAgences(){
        return agenceService.afficherToutesAgences();
    }

    @Operation(summary = "ajouter une agence")
    @PostMapping("/ajouterAgence")
    public Agence ajouterAgence(@RequestBody Agence agence){
        return agenceService.ajouterAgence(agence);
    }

    @Operation(summary = "modifier une agence")
    @PutMapping("/modifierAgence")
    public Agence modifierAgence(@RequestBody Agence agence)
    {
        return agenceService.modifierAgence(agence);
    }

    @Operation(summary = "supprimer une agence")
    @DeleteMapping("/supprimerAgence/{idAgence}")
    public void supprimerAgence(@PathVariable Long idAgence)
    {
        agenceService.supprimerAgence(idAgence);
    }

    @Operation(summary = "trouver une agence par id")
    @GetMapping("/afficherAgenceById/{id}")
    public Agence getAgenceById(@PathVariable Long id)
    {
        return agenceService.afficherAgenceById(id);
    }

}
