package tn.esprit.autoloc.service;

import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.repository.EquipementRepository;
import tn.esprit.autoloc.repository.VehiculeRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor

public class IVehiculeServiceImp implements IVehiculeService{

    private final VehiculeRepository vehiculeRepository;
    private final EquipementRepository equipementRepository;

    @Override
    public Vehicule ajouterVehicule(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public Vehicule modifierVehicule(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public List<Vehicule> afficherToutesVehicule() {
        return vehiculeRepository.findAll();
    }

//    @Override
//    public Vehicule afficherVehiculeById(Long idVehicule) {
//        return vehiculeRepository.findById(idVehicule).orElse(null);
//    }
    @Override
    public Vehicule afficherVehiculeById(Long id) {
        return vehiculeRepository.findById(id)
              .orElseThrow(() ->
                        new RuntimeException("Véhicule introuvable"));
    }

    @Override
    public void supprimerVehicule(Long idVehicule) {
        vehiculeRepository.deleteById(idVehicule);

    }

    @Override
    @Transactional
    public Vehicule affecterEquipement(Long idVehicule, Long idEquipement) {
        Vehicule vehicule= vehiculeRepository.findById(idVehicule).get();
        Equipement equipement = equipementRepository.findById(idEquipement).get();
        vehicule.getEquipements().add(equipement);
        return vehiculeRepository.save(vehicule);
    }

    @Override
    @Transactional
    public Vehicule desaffecterEquipement(Long idVehicule, Long idEquipement) {
        Vehicule vehicule= vehiculeRepository.findById(idVehicule).get();
        vehicule.getEquipements().removeIf(e->e.getIdEquipement().equals(idEquipement));
        return vehiculeRepository.save(vehicule);
    }
    @Scheduled(fixedRate = 60000,initialDelay = 5000)
    public void actualiserEtatVehicule(){
        //Recuperation de tous les vehicules
        List<Vehicule>vehicules = vehiculeRepository.findAll();
        System.out.println("===Actualisation des véhicules===");
        System.out.println("Nombre total de véhicule :"+vehicules.size());
        System.out.println("Date d'actualisation :"+ LocalDateTime.now());

    }


    @Scheduled(cron = "0 0 9 * * MON", zone = "Africa/Tunis")
    public void genererRapportVehicules() {

        List<Vehicule> vehicules = vehiculeRepository.findAll();
        System.out.println("========== RAPPORT HEBDOMADAIRE DES VEHICULES ==========");
        System.out.println("Nombre total de véhicules : " + vehicules.size());
        System.out.println("Date d'actualisation :"+ LocalDateTime.now());
        System.out.println("========================================================");

    }
}
