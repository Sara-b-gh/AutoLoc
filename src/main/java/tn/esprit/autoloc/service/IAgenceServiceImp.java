package tn.esprit.autoloc.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.repository.AgenceRepository;
import tn.esprit.autoloc.repository.VehiculeRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
@AllArgsConstructor

public class IAgenceServiceImp implements IAgenceService{
    /*@Autowired
    private AgenceRepository agenceRepository;*/
    private final AgenceRepository agenceRepository;

    @Override
    public Agence ajouterAgence(Agence agence) {
        return agenceRepository.save(agence);
    }

    @Override
    public Agence modifierAgence(Agence agence) {
        return agenceRepository.save(agence);
    }

    @Override
    public List<Agence> afficherToutesAgences() {
        return agenceRepository.findAll();
    }

    @Override
    public Agence afficherAgenceById(Long idAgence) {
        return agenceRepository.findById(idAgence).orElse(null);
    }

    @Override
    public void supprimerAgence(Long idAgence) {
         agenceRepository.deleteById(idAgence);

    }

    private final VehiculeRepository vehiculeRepository;

    @Transactional
    @Override
    public Agence ajouterAgenceEtAffecterVehicules(Agence agence) {
        List<Vehicule> vehicules= new ArrayList<>(agence.getVehicules());
        agence.setVehicules(new ArrayList<>());
        Agence agenceSauvegarde = agenceRepository.save(agence);

        for (Vehicule vehicule : vehicules){
            vehicule.setAgence(agenceSauvegarde);
            agenceSauvegarde.getVehicules().add(vehiculeRepository.save(vehicule));
        }
        return agenceSauvegarde;
    }

    @Override
    public List<Agence> retournerAgencesParVille(String ville) {
        return agenceRepository.findByVille(ville);
    }

    @Override
    public List<Agence> retournerAgencesParNomTerminePar(String nom) {
        return agenceRepository.findByNomEndingWith(nom);
    }


    @Scheduled(fixedDelay = 2, timeUnit = TimeUnit.MINUTES)
    public void suivreNombreAgences() {

        List<Agence> agences = agenceRepository.findAll();

        System.out.println("===== SUIVI DES AGENCES =====");
        System.out.println("Nombre total d'agences : " + agences.size());
        System.out.println("Date d'actualisation :"+ LocalDateTime.now());

    }
}
