package tn.esprit.autoloc.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.service.IVehiculeService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/vehicule")
@Tag(name ="gestion de vehicules", description = "CRUD")

public class VehiculeController {
    private final IVehiculeService vehiculeService;

    @Operation(summary = "ajouter un vehicule")
    @PostMapping("/ajouterVehicule")
    public Vehicule ajouterVehicule(@RequestBody Vehicule vehicule)
    {
        return vehiculeService.ajouterVehicule(vehicule);
    }

    @Operation(summary = "modifier un vehicule")
    @PutMapping("/modifierVehicule")
    public Vehicule modifierVehicule(@RequestBody Vehicule vehicule)
    {
        return vehiculeService.modifierVehicule(vehicule);
    }

    @Operation(summary = "supprimer un vehicule")
    @DeleteMapping("/supprimerVehicule/{idVehicule}")
    public void supprimerVehicule(@PathVariable Long idVehicule)
    {
        vehiculeService.supprimerVehicule(idVehicule);
    }

    @Operation(summary = "afficher toutes les vehicules")
    @GetMapping("/afficherToutesVehicules")
    public List<Vehicule> getAllVehicules(){
        return vehiculeService.afficherToutesVehicule();
    }

    @Operation(summary = "trouver un vehicule par id")
    @GetMapping("/afficherVehiculeById/{id}")
    public Vehicule getVehiculeById(@PathVariable Long id)
    {
        return vehiculeService.afficherVehiculeById(id);
    }
}
