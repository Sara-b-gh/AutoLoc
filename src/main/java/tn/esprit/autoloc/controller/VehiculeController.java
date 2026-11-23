package tn.esprit.autoloc.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.CategorieVehicule;
import tn.esprit.autoloc.domain.StatutVehicule;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.service.IVehiculeService;

import java.math.BigDecimal;
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

    @Operation(summary = "afficher tous les vehicules")
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

    @Operation(summary = "affecter un équipements à un vehicule")
    @PutMapping("/affecterEquipement/{idVehicule}/{idEquipement}")
    public Vehicule affecterEquipement(@PathVariable Long idVehicule,@PathVariable Long idEquipement){
    return vehiculeService.affecterEquipement(idVehicule,idEquipement);
    }

    @Operation(summary = "desaffecter un équipements à un vehicule")
    @PutMapping("/desaffecterEquipement/{idVehicule}/{idEquipement}")
    public     Vehicule desaffecterEquipement(Long idVehicule, Long idEquipement){
        return vehiculeService.desaffecterEquipement(idVehicule,idEquipement);
    }

    @GetMapping("/afficherParMarque/{b}")
    public List<Vehicule> afficherVehiculesMarque(@PathVariable String b){
        return vehiculeService.retournerVehiculesParMarque(b);
    }

    @GetMapping("/afficherParCategorie/{categorie}")
    public List<Vehicule> afficherVehiculesParCategorie(@PathVariable CategorieVehicule categorie) {
        return vehiculeService.retournerVehiculesParCategorie(categorie);
    }

    @GetMapping("/afficherParStatut/{statut}")
    public List<Vehicule> afficherVehiculesParStatut(@PathVariable StatutVehicule statut) {
        return vehiculeService.retournerVehiculesParStatut(statut);
    }

    @GetMapping("/afficherParMarqueContenant/{marque}")
    public List<Vehicule> afficherVehiculesParMarqueContenant(@PathVariable String marque) {
        return vehiculeService.retournerVehiculesParMarqueContenant(marque);
    }
    @GetMapping("/afficherParModeleCommencantPar/{modele}")
    public List<Vehicule> afficherVehiculesParModeleCommencantPar(@PathVariable String modele) {
        return vehiculeService.retournerVehiculesParModeleCommencantPar(modele);
    }

    @GetMapping("/afficherParTarifSuperieur/{tarif}")
    public List<Vehicule> afficherVehiculesParTarifSuperieur(@PathVariable BigDecimal tarif) {
        return vehiculeService.retournerVehiculesParTarifSuperieur(tarif);
    }

    @GetMapping("/afficherParTarifInferieur/{tarif}")
    public List<Vehicule> afficherVehiculesParTarifInferieur(@PathVariable BigDecimal tarif) {
        return vehiculeService.retournerVehiculesParTarifInferieur(tarif);
    }

    @GetMapping("/afficherParTarifSuperieurOuEgal/{tarif}")
    public List<Vehicule> afficherVehiculesParTarifSuperieurOuEgal(@PathVariable BigDecimal tarif) {
        return vehiculeService.retournerVehiculesParTarifSuperieurOuEgal(tarif);
    }

    @GetMapping("/afficherParMarqueEtStatut/{marque}/{statut}")
    public List<Vehicule> afficherVehiculesParMarqueEtStatut(@PathVariable String marque, @PathVariable StatutVehicule statut) {
        return vehiculeService.retournerVehiculesParMarqueEtStatut(marque, statut);
    }

    @GetMapping("/afficherParCategories")
    public List<Vehicule> afficherVehiculesParCategories(@RequestParam List<CategorieVehicule> categories) {
        return vehiculeService.retournerVehiculesParCategories(categories);
    }

    @GetMapping("/afficherParMarqueEtTarifInferieur/{marque}/{tarif}")
    public List<Vehicule> afficherVehiculesParMarqueEtTarifInferieur(@PathVariable String marque, @PathVariable BigDecimal tarif) {
        return vehiculeService.retournerVehiculesParMarqueEtTarifInferieur(marque, tarif);
    }

    @GetMapping("/afficherDisponiblesParTarifCroissant")
    public List<Vehicule> afficherDisponiblesParTarifCroissant() {
        return vehiculeService.retournerVehiculesDisponiblesParTarifCroissant();
    }

    @GetMapping("/afficherParTarifDecroissant")
    public List<Vehicule> afficherParTarifDecroissant() {
        return vehiculeService.retournerVehiculesParTarifDecroissant();
    }
}

