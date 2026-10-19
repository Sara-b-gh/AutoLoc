package tn.esprit.autoloc.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.service.IClientService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/clients")
@Tag(name ="gestion de clients", description = "CRUD")


public class ClientController {
    private final IClientService clientService;

    @Operation(summary = "ajouter un client")
    @PostMapping ("/ajouterClient")
    public Client ajouterClient(@RequestBody Client client)
    {
        return clientService.ajouterClient(client);
    }

    @Operation(summary = "modifier un client")
    @PutMapping("/modifierClient")
    public Client modifierClient(@RequestBody Client client)
    {
        return clientService.modifierClient(client);
    }

    @Operation(summary = "supprimer un client")
    @DeleteMapping("/supprimerClient/{idClient}")
    public void supprimerClient(@PathVariable Long idClient)
    {
        clientService.supprimerClient(idClient);
    }

    @Operation(summary = "afficher tous les clients")
    @GetMapping("/afficherToutesClients")
    public List<Client> getAllClients(){
        return clientService.afficherToutesClient();
    }

    @Operation(summary = "trouver un client par id")
    @GetMapping("/afficherClientById/{id}")
    public Client getClientById(@PathVariable Long id)
    {
        return clientService.afficherClientById(id);
    }


}
