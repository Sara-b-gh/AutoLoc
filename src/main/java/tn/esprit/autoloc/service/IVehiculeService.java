package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.CategorieVehicule;
import tn.esprit.autoloc.domain.StatutVehicule;
import tn.esprit.autoloc.domain.Vehicule;

import java.math.BigDecimal;
import java.util.List;

public interface IVehiculeService {
    Vehicule ajouterVehicule(Vehicule vehicule);
    Vehicule modifierVehicule(Vehicule vehicule);
    List<Vehicule> afficherToutesVehicule();
    Vehicule afficherVehiculeById(Long idVehicule);
    void supprimerVehicule(Long idVehicule);
    Vehicule affecterEquipement(Long idVehicule, Long idEquipement);
    Vehicule desaffecterEquipement(Long idVehicule, Long idEquipement);
    public List<Vehicule> retournerVehiculesParMarque(String m);
    List<Vehicule> retournerVehiculesParCategorie(CategorieVehicule categorie);
    List<Vehicule> retournerVehiculesParStatut(StatutVehicule statut);
    List<Vehicule> retournerVehiculesParMarqueContenant(String marque);
    List<Vehicule> retournerVehiculesParModeleCommencantPar(String modele);
    List<Vehicule> retournerVehiculesParTarifSuperieur(BigDecimal tarif);
    List<Vehicule> retournerVehiculesParTarifInferieur(BigDecimal tarif);
    List<Vehicule> retournerVehiculesParTarifSuperieurOuEgal(BigDecimal tarif);
    List<Vehicule> retournerVehiculesParMarqueEtStatut(String marque, StatutVehicule statut);
    List<Vehicule> retournerVehiculesParCategories(List<CategorieVehicule> categories);
    List<Vehicule> retournerVehiculesParMarqueEtTarifInferieur(String marque, BigDecimal tarif);
    List<Vehicule> retournerVehiculesDisponiblesParTarifCroissant();
    List<Vehicule> retournerVehiculesParTarifDecroissant();

}

