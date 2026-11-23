package tn.esprit.autoloc.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Maintenance;
import tn.esprit.autoloc.service.IMaintenanceService;

import java.time.LocalDate;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/maintenance")
@Tag(name ="gestion de maintenances", description = "CRUD")

public class MaintenanceController {
    private final IMaintenanceService maintenanceService;

    @Operation(summary = "ajouter un maintenance")
    @PostMapping("/ajouterMaintenance")
    public Maintenance ajouterMaintenance(@RequestBody Maintenance maintenance)
    {
        return maintenanceService.ajouterMaintenance(maintenance);
    }

    @Operation(summary = "modifier un maintenance")
    @PutMapping("/modifierMaintenance")
    public Maintenance modifierMaintenance(@RequestBody Maintenance maintenance)
    {
        return maintenanceService.modifierMaintenance(maintenance);
    }

    @Operation(summary = "supprimer un maintenance")
    @DeleteMapping("/supprimerMaintenance/{idMaintenance}")
    public void supprimerMaintenance(@PathVariable Long idMaintenance)
    {
        maintenanceService.supprimerMaintenance(idMaintenance);
    }

    @Operation(summary = "afficher toutes les maintenances")
    @GetMapping("/afficherToutesMaintenances")
    public List<Maintenance> getAllMaintenance(){
        return maintenanceService.afficherToutesMaintenance();
    }

    @Operation(summary = "trouver un maintenance par id")
    @GetMapping("/afficherMaintenanceById/{id}")
    public Maintenance getMaintenanceById(@PathVariable Long id)
    {
        return maintenanceService.afficherMaintenanceById(id);
    }

    @GetMapping("/afficherEntreDeuxDates")
    public List<Maintenance> afficherMaintenancesEntreDeuxDates(
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateDebut,
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateFin) {

        return maintenanceService.retournerMaintenancesEntreDeuxDates(
                dateDebut, dateFin);
    }
}
