package tn.esprit.autoloc.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Contract;
import tn.esprit.autoloc.service.IContractService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/contract")

public class ContractController {
    private final IContractService contractService;

    @PostMapping("/ajouterContract")
    public Contract ajouterContract(@RequestBody Contract contract)
    {
        return contractService.ajouterContract(contract);
    }

    @PutMapping("/modifierContract")
    public Contract modifierContract(@RequestBody Contract contract)
    {
        return contractService.modifierContract(contract);
    }

    @DeleteMapping("/supprimerContract/{idContract}")
    public void supprimerContract(@PathVariable Long idContract)
    {
        contractService.supprimerContract(idContract);
    }

    @GetMapping("/afficherToutesContracts")
    public List<Contract> getAllContract(){
        return contractService.afficherToutesContracts();
    }

    @GetMapping("/afficherContractById/{id}")
    public Contract getContractById(@PathVariable Long id)
    {
        return contractService.afficherContractById(id);
    }
}
