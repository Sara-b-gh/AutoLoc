package tn.esprit.autoloc.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.service.IEmployeService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/employe")
@Tag(name ="gestion de employes", description = "CRUD")


public class EmployeController {
    private final IEmployeService employeService;

    @Operation(summary = "ajouter un employe")
    @PostMapping("/ajouterEmploye")
    public Employe ajouterEmploye(@RequestBody Employe employe)
    {
        return employeService.ajouterEmploye(employe);
    }

    @Operation(summary = "modifier un employe")
    @PutMapping("/modifierEmploye")
    public Employe modifierEmploye(@RequestBody Employe employe)
    {
        return employeService.modifierEmploye(employe);
    }

    @Operation(summary = "supprimer un employe")
    @DeleteMapping("/supprimerEmploye/{idEmploye}")
    public void supprimerEmploye(@PathVariable Long idEmploye)
    {
        employeService.supprimerEmploye(idEmploye);
    }

    @Operation(summary = "afficher tous les employes")
    @GetMapping("/afficherToutesEmployes")
    public List<Employe> getAllEmploye(){
        return employeService.afficherToutesEmploye();
    }

    @Operation(summary = "trouver un employe par id")
    @GetMapping("/afficherEmployeById/{id}")
    public Employe getEmployeById(@PathVariable Long id)
    {
        return employeService.afficherEmployeById(id);
    }
}
